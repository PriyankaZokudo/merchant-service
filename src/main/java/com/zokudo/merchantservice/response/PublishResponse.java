package com.zokudo.merchantservice.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@Service
public class PublishResponse {

    private String mid;
    private String status;
    private String message;
    private Map<String, Object> merchant_publish_details;

    // webhook response
    //private String result;

}
