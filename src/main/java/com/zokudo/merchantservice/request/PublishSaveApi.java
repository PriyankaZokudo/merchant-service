package com.zokudo.merchantservice.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Service
public class PublishSaveApi {

    @NotEmpty(message = "Program channels should not be empty")
    @NotNull(message = "Program channels should not be null")
    private List<String> program_ids;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
    @NotNull(message = "From date should not be null")
    private LocalDate from_date;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
    @NotNull(message = "To date should not be null")
    private LocalDate to_date;

    @NotNull(message = "Terminal ids should not be empty or null")
    @NotEmpty(message = "Terminal ids should not be empty")
    private List<Integer> tids;

    @NotNull(message = "Mid should not be empty or null")
    private String mid;

    @NotNull(message = "Cashback should not be empty or null")
    private Float cashback;

    @NotNull(message = "Cashback type should not be empty or null")
    @NotEmpty(message = "Cashback type should not be empty")
    private String cashback_type;

    @NotNull(message = "Push notification should not be empty or null")
    @NotEmpty(message = "Push notification should not be empty")
    private String push_notifications; //temporary made string rather boolean

//    @NotNull(message = "Location should not be empty or null")
//    @NotEmpty(message = "Location should not be empty")
    private Map<String, Object> location;

    private boolean target_high_potential_customers;
    private List<Long> customer_mobiles;

    @NotNull(message = "Campaign Id should not be empty or null")
    @NotEmpty(message = "Campaign Id should not be empty")
    private String campaign_id;


    @Override
    public String toString() {
        return "WebhookApi{" +
                "mid=" + mid +
                ", program_ids=" + program_ids +
                ", from_date=" + from_date +
                ", to_date=" + to_date +
                ", tids=" + tids +
                ", cashback=" + cashback +
                ", cashback_type='" + cashback_type + '\'' +
                ", push_notifications='" + push_notifications + '\'' +
                ", location=" + location +
                ", target_high_potential_customers=" + target_high_potential_customers +
                ", customer_mobiles=" + customer_mobiles +
                ", campaign_id=" + campaign_id +
                '}';
    }
}
