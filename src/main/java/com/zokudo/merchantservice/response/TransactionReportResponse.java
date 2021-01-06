package com.zokudo.merchantservice.response;

import com.zokudo.merchantservice.model.Transaction;

import java.util.List;

public class TransactionReportResponse {
    private List<Transaction> transactionList;

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(String email) {
        this.transactionList = transactionList;
    }
}
