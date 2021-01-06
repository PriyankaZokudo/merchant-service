package com.zokudo.merchantservice.repository;

import com.zokudo.merchantservice.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("transactionReportRepository")
public interface TransactionReportRepository extends JpaRepository<Transaction, Integer> {
    @Query(value = "SELECT t.* FROM `transaction` AS t JOIN `merchant` AS m ON t.merchant_id= m.m_id WHERE m.email = :email", nativeQuery = true)
    List<Transaction> getMerchanatTransactionbyEmail(@Param("email") String email);

}
