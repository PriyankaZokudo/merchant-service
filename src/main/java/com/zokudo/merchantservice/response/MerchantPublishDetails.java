package com.zokudo.merchantservice.response;

import org.springframework.stereotype.Service;

@Service
public interface MerchantPublishDetails {

    String getTotal_customers_targetted();
    Integer getTotal_customers_targetted_ZOKUDOPROGRAM();
    //Integer getTotal_customers_targetted_INFYGPR();
    //Integer getTotal_targetted_customers_in_city();
    //String getCampaign_id();
}
