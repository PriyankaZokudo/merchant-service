package com.zokudo.merchantservice.service;

import com.zokudo.merchantservice.model.Transaction;
import com.zokudo.merchantservice.repository.TransactionReportRepository;
import com.zokudo.merchantservice.response.DashboardResponse;
import com.zokudo.merchantservice.response.TransactionReportResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("transactionReportApiService")
public class TransactionReportApiService {

    @Autowired
    private TransactionReportRepository transactionReportRepository;

    public List<Transaction> getMerchanatTransactionbyEmail(String email) {

        return transactionReportRepository.getMerchanatTransactionbyEmail(email);
    }

}
