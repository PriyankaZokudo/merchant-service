package com.zokudo.merchantservice.service;


import com.zokudo.merchantservice.repository.TransactionRepository;
import com.zokudo.merchantservice.request.DashboardApi;
import com.zokudo.merchantservice.response.DashboardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;


@Service("dashboardApiService")
public class DashboardApiService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private DashboardResponse dashboardResponse;


    public DashboardResponse getTransactionSumCnt(DashboardApi dashboardApi) {
        // map request in dashboard api class
        dashboardResponse.setMid(dashboardApi.getMid());
        dashboardResponse.setStatus("Success");
        dashboardResponse.setMessage("Successful returned merchant dashboard details.");
        if(dashboardApi.getIs_graph().booleanValue()) {
            dashboardResponse.setMerchant_dashboard_details_graph(transactionRepository.getTransactionSumCntGraph(dashboardApi.getTransaction_channels(), dashboardApi.getTids(), dashboardApi.getTransaction_status(), dashboardApi.getFrom_date(), dashboardApi.getTo_date()));
            dashboardResponse.setMerchant_dashboard_details(null);
        } else {
            dashboardResponse.setMerchant_dashboard_details_graph(null);
            dashboardResponse.setMerchant_dashboard_details(transactionRepository.getTransactionSumCnt(dashboardApi.getTransaction_channels(),dashboardApi.getTids(),dashboardApi.getTransaction_status(),dashboardApi.getFrom_date(),dashboardApi.getTo_date()));
        }
        return dashboardResponse;
    }

    public DashboardResponse getMerchanatTransactionbyEmail(String email) {

        return dashboardResponse;
    }
}
