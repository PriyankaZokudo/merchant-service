package com.zokudo.merchantservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "campaign_master" )
@TableGenerator(name="campaign_master", table="SEQUENCES", pkColumnValue="CampaignMaster",allocationSize=1)
public class CampaignMasterModel {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE, generator="campaign_master")
    @Column(name="campaign_master_id")
    private int campaignMasterId;

    @Column(name="campaign_number", length = 50)
    private String campaignNumber;

    @Column(name="m_id")
    private String mId;

    @NotNull
    @Column(name="from_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
    private LocalDate fromDate;

    @NotNull
    @Column(name="to_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
    private LocalDate toDate;

    @Column(name="cashback")
    private Float cashback;

    @Lob
    @Column(name="program_ids")
    private String programIds;

    @Lob
    @Column(name="t_ids")
    private String tIds;

    @Column(name="cashback_type")
    private String cashbackType;

    @Column(name="high_potential_customers",columnDefinition = "boolean default false")
    private Boolean highPotentialCustomers;

    @Column(name="push_notifications")
    private String pushNotifications;
}
