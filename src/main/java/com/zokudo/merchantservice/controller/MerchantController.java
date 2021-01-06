package com.zokudo.merchantservice.controller;

import com.zokudo.merchantservice.exception.ErrorDetails;
import com.zokudo.merchantservice.model.CampaignMasterModel;
import com.zokudo.merchantservice.model.Transaction;
import com.zokudo.merchantservice.request.DashboardApi;
import com.zokudo.merchantservice.request.PublishApi;
import com.zokudo.merchantservice.request.PublishSaveApi;
import com.zokudo.merchantservice.service.DashboardApiService;
import com.zokudo.merchantservice.service.PublishApiService;
import com.zokudo.merchantservice.service.TransactionReportApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/merchant")
public class MerchantController {
    @Autowired
    private DashboardApiService dashboardApiService;

    @Autowired
    private PublishApiService publishApiService;

    @Autowired(required=true)
    private TransactionReportApiService transactionReportApiService;

    @RequestMapping(path="/get-dashboard-details", method = RequestMethod.POST)
    public ResponseEntity getDashboardDetails(@Valid @RequestBody DashboardApi dashboardApi){
        // fetching transaction count/sum and customer / card count
        if(dashboardApi.getTo_date().before(dashboardApi.getFrom_date())) {
            return new ResponseEntity(new ErrorDetails(new Date(),
                    "Validation error","Invalid field from date")
                    , HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(dashboardApiService.getTransactionSumCnt(dashboardApi), HttpStatus.OK);
    }

    @RequestMapping(path="/get-publish-details", method = RequestMethod.POST)
    public ResponseEntity getPublishDetails(@RequestBody PublishApi publishApi){

       /* if (publishApi.getPush_notifications().equals("true")) {
            publishApi.setPush_notifications("ENABLED");
        }*/
       return new ResponseEntity(publishApiService.getTxnPublishCount(publishApi), HttpStatus.OK);
    }

   @RequestMapping(path="/publish-save", method = RequestMethod.POST)
    public ResponseEntity publish(@Valid @RequestBody PublishSaveApi publishSaveApi){
        return new ResponseEntity(publishApiService.savePublish(publishSaveApi), HttpStatus.OK);
    }
    @RequestMapping(path="/get-transaction-report-data/{email}", method = RequestMethod.GET)
    public ResponseEntity<List<Transaction>> getTransactionReportData(@PathVariable("email") String email){
        return new ResponseEntity(transactionReportApiService.getMerchanatTransactionbyEmail(email), HttpStatus.OK);
    }

}
