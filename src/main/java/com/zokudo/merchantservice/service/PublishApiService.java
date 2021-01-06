package com.zokudo.merchantservice.service;

import com.zokudo.merchantservice.model.CampaignCustomersModel;
import com.zokudo.merchantservice.model.CampaignMasterModel;
import com.zokudo.merchantservice.repository.CampaignCustomerRepository;
import com.zokudo.merchantservice.repository.CampaignMasterRepository;
import com.zokudo.merchantservice.repository.TransactionRepository;
import com.zokudo.merchantservice.request.CustomersTargetted;
import com.zokudo.merchantservice.request.PublishApi;
import com.zokudo.merchantservice.request.PublishSaveApi;
import com.zokudo.merchantservice.response.PublishResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("publishApiService")
@Slf4j
public class PublishApiService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private PublishResponse publishResponse;

    @Autowired
    private CampaignMasterRepository campaignMasterRepository;

    @Autowired
    private CampaignCustomerRepository campaignCustomerRepository;

    public PublishResponse getTxnPublishCount(PublishApi publishApi) {
        System.out.println("Publish Output: " + publishApi.toString());
        publishResponse.setMid(publishApi.getMid());
        publishResponse.setStatus("Success");
        publishResponse.setMessage("Successful returned merchant publish details.");

        List<Map<String, Object>> list = transactionRepository.getTxnPublishCount(
                publishApi.getProgram_ids(),
                publishApi.getTids(),
                publishApi.getCashback(),
                publishApi.getCashback_type(),
                publishApi.getPush_notifications()
        ) ;

       List<CustomersTargetted> list1 = list.stream().map(m -> new CustomersTargetted(String.valueOf(m.get("program_name")), (BigInteger) m.get("count_of_program"))).collect(Collectors.toList());

       Integer sum = list1.stream()
               .map(x -> x.getCount_of_program())
               .reduce(0, Integer::sum);

       Map<String, Object> result1 = list1.stream().collect(
                Collectors.toMap(CustomersTargetted::getProgram_name, CustomersTargetted::getCount_of_program));

       result1.forEach((k, v) -> System.out.println((k + ":" + v)));

       result1.put("total_customers_targetted", sum);
       publishResponse.setMerchant_publish_details(result1);
       System.out.println("Result 1 : " + result1);

       System.out.println("publishResponse: " + publishResponse.getMerchant_publish_details().toString());
       return publishResponse;
    }

   public PublishResponse savePublish(PublishSaveApi publishSaveApi) {
       log.debug("******* Inside savePublish() *******");
       CampaignMasterModel campaignMasterModel = new CampaignMasterModel();
       String program_ids = String.join(",",publishSaveApi.getProgram_ids());
       String t_ids = publishSaveApi.getTids().stream().map(String::valueOf).collect(Collectors.joining(","));
       campaignMasterModel.setProgramIds(program_ids);
       campaignMasterModel.setTIds(t_ids);
       campaignMasterModel.setCampaignNumber(publishSaveApi.getCampaign_id());
       campaignMasterModel.setCashback(publishSaveApi.getCashback());
       campaignMasterModel.setCashbackType(publishSaveApi.getCashback_type());
       campaignMasterModel.setFromDate(publishSaveApi.getFrom_date());
       campaignMasterModel.setToDate(publishSaveApi.getTo_date());
       campaignMasterModel.setHighPotentialCustomers(publishSaveApi.isTarget_high_potential_customers());
       campaignMasterModel.setPushNotifications(publishSaveApi.getPush_notifications());
       campaignMasterModel.setMId(publishSaveApi.getMid());
       log.debug("******* Before campaign save *******");
       campaignMasterRepository.save(campaignMasterModel);
       log.debug("******* After campaign save *******");
       if(publishSaveApi.isTarget_high_potential_customers()) {
           log.debug("******* before campaign customer save *******");
           for (long mobile : publishSaveApi.getCustomer_mobiles()) {
               CampaignCustomersModel campaignCustomersModel = new CampaignCustomersModel();
               campaignCustomersModel.setCampaignId(campaignMasterModel.getCampaignMasterId());
               campaignCustomersModel.setMobileNo(mobile);
               campaignCustomerRepository.save(campaignCustomersModel);
           }
           log.debug("******* After campaign customer save *******");
       }
       publishResponse.setStatus("Success");
       publishResponse.setMessage("Your campaign sucessfully save.");
       return publishResponse;
    }
}
