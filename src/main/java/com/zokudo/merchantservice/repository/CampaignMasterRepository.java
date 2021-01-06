package com.zokudo.merchantservice.repository;

import com.zokudo.merchantservice.model.CampaignMasterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("campaignMasterRepository")
public interface CampaignMasterRepository extends JpaRepository<CampaignMasterModel, Integer> {
}

