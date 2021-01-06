package com.zokudo.merchantservice.repository;

import com.zokudo.merchantservice.model.TransactionModel;
import com.zokudo.merchantservice.response.MerchantDashboardDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository("transactionRepository")
public interface TransactionRepository extends JpaRepository<TransactionModel,Integer> {

    @Query(value = "SELECT IFNULL(sum(mt.amount),0) as total_sales, count(*) as total_transactions, IFNULL((SUM(mt.amount)/COUNT(*)),0) AS transactions_ticket_size , COUNT(DISTINCT t.customer_hash_id) as unique_customers, COUNT(DISTINCT t.customer_hash_id) as new_customers, COUNT(DISTINCT t.card_hash_id) as unique_cards FROM `master_account_transactions` mt JOIN `transaction` t ON mt.transactions_id = t.id WHERE t.channel IN (:channels) and t.terminal_id IN (:terminalId) and t.status IN(:status) and DATE(t.created_at) >= DATE(:fromDate) and DATE(t.created_at) <= DATE(:toDate)", nativeQuery = true)
    MerchantDashboardDetails getTransactionSumCnt(@Param("channels") List<String> channels, @Param("terminalId") List<Integer> terminalId, @Param("status") List<String> status, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

    @Query(value = "SELECT DATE_FORMAT(t.created_at, '%Y-%m-%d %H:%i:%s') as transaction_date, IFNULL(sum(mt.amount),0) as total_sales, count(*) as total_transactions, IFNULL((SUM(mt.amount)/COUNT(*)),0) AS transactions_ticket_size , COUNT(DISTINCT t.customer_hash_id) as unique_customers, COUNT(DISTINCT t.customer_hash_id) as new_customers, COUNT(DISTINCT t.card_hash_id) as unique_cards  FROM `master_account_transactions` mt JOIN `transaction` t ON mt.transactions_id = t.id WHERE t.channel IN (:channels) and t.terminal_id IN (:terminalId) and t.status IN(:status) and DATE(t.created_at) >= DATE(:fromDate) and DATE(t.created_at) <= DATE(:toDate) GROUP BY t.created_at", nativeQuery = true)
    List<Map<String, Object>> getTransactionSumCntGraph(@Param("channels") List<String> channels, @Param("terminalId") List<Integer> terminalId, @Param("status") List<String> status, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

    @Query(value = "SELECT program_name AS program_name, COUNT(program_name) AS count_of_program FROM `merchant-portal`.merchant_cashback_config mcc JOIN `merchant-portal`.transaction txn ON mcc.program_id = txn.program_id WHERE mcc.program_name IN (:program_ids) AND mcc.terminal_id IN (:terminal_ids) AND mcc.cashback_value IN (:cashback) AND mcc.is_fixed IN (:cashback_type) AND mcc.status IN (:push_notifications) GROUP BY program_name", nativeQuery = true)
    List<Map<String, Object>> getTxnPublishCount(@Param("program_ids") List<String> program_ids,
                                                @Param("terminal_ids") List<Integer> terminal_ids,
                                                @Param("cashback") Integer cashback,
                                                @Param("cashback_type") String cashback_type,
                                                @Param("push_notifications") String push_notifications);
}
