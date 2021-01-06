package com.zokudo.merchantservice.repository;

import com.zokudo.merchantservice.model.CampaignCustomersModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignCustomerRepository extends JpaRepository<CampaignCustomersModel, Integer> {
}
