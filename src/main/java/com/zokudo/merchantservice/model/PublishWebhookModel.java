package com.zokudo.merchantservice.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "Publish_Webhook")
@Getter
@Setter
@NoArgsConstructor
public class PublishWebhookModel {

    @Id
    @GeneratedValue
    @Column(name="id")
    private BigInteger id;

    @Column(name="mid")
    private String mid;

    @Column(name="program_id")
    private String programId;

    @NotNull
    @Column(name="created_at")
    private Timestamp createdAt;

    @Column(name="created_by")
    private Timestamp createdBy;

    @Column(name="terminal_id")
    private Integer terminalId;

    @Column(name="cashback")
    private Integer cashback;

    @Column(name="cashback_type")
    private String cashbackType;

    @Column(name="push_notifications")
    private boolean push_notifications;

    @Column(name="target_high_potential_customers")
    private boolean target_high_potential_customers;

    @Column(name="customer_id")
    private String customerId;

    @Column(name="campaign_id")
    private String campaignId;

}
