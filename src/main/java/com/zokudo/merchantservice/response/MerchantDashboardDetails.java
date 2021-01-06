package com.zokudo.merchantservice.response;

import org.springframework.stereotype.Service;

@Service
public interface MerchantDashboardDetails {

	Float getTotal_sales();
	Integer getTotal_transactions();
	Integer getTransactions_ticket_size();
	Integer getUnique_cards();
	Integer	getUnique_customers();
	Integer getNew_customers();
}
