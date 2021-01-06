package com.zokudo.merchantservice.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Service
public class PublishApi {

    private String mid;
    private List<String> program_ids;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date from_date;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date to_date;
    private List<Integer> tids;
    private Integer cashback;
    private String cashback_type;

    private String push_notifications; //temporary made string rather boolean

    private Map<String, Object> location;

    @Override
    public String toString() {
        return "PublishApi{" +
                "mid=" + mid +
                ", program_ids=" + program_ids +
                ", from_date=" + from_date +
                ", to_date=" + to_date +
                ", tids=" + tids +
                ", cashback=" + cashback +
                ", cashback_type='" + cashback_type + '\'' +
                ", push_notifications='" + push_notifications + '\'' +
                ", location=" + location +
                '}';
    }
}
