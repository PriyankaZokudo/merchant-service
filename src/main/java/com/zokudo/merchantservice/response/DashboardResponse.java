package com.zokudo.merchantservice.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@Service
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DashboardResponse {

    private String mid;
    private String status;
    private String message;
    private MerchantDashboardDetails merchant_dashboard_details;
    private List<Map<String, Object>> merchant_dashboard_details_graph;

}
