package com.zokudo.merchantservice.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Service
public class DashboardApi {

    @NotNull(message = "Mid should not be empty or null")
    private String mid;

    @NotNull(message = "Terminal ids should not be empty or null")
    @NotEmpty(message = "Terminal ids should not be empty")
    private List<Integer> tids;

    @NotEmpty(message = "Transaction channels should not be empty")
    @NotNull(message = "Transaction channels should not be null")
    private List<String> transaction_channels;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
    @NotNull(message = "From date should not be null")
    private Date from_date;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
    @NotNull(message = "To date should not be null")
    private Date to_date;

    @NotEmpty(message = "Transaction status should not be empty")
    @NotNull(message = "Transaction status should not be null")
    private List<String> transaction_status;

    private Map<String, Object> location;

    @Builder.Default
    private Boolean is_graph = false;

    @Override
    public String toString() {
        return "DashboardApi{" +
                "mid=" + mid +
                ", tids=" + tids +
                ", transaction_channels=" + transaction_channels +
                ", from_date=" + from_date +
                ", to_date=" + to_date +
                ", transaction_status=" + transaction_status +
                ", location=" + location +
                ", is_graph=" + is_graph +
                '}';
    }
}
