package com.zokudo.merchantservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="campaign_customers")
@TableGenerator(name="campaign_customers", table="SEQUENCES", pkColumnValue="CampaignCustomers",allocationSize=1)
public class CampaignCustomersModel {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE, generator="campaign_customers")
    @Column(name="campaign_customers_id")
    private int campaignCustomersId;

    @Column(name="campaign_id")
    private int CampaignId;

    @Column(name="mobile_no")
    private long mobileNo;
}
