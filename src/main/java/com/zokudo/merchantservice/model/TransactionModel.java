package com.zokudo.merchantservice.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "transaction")
@Getter
@Setter
@NoArgsConstructor
public class TransactionModel {
    @Id
    @GeneratedValue
    @Column(name="id")
    private long id;

    @NotNull
    @Column(name="created_at")
    private Timestamp createdAt;

    @Column(name="created_by")
    private Timestamp createdBy;

    @NotNull
    @Column(name="updated_at")
    private Timestamp updatedAt;

    @Column(name="updated_by")
    private String updatedBy;

    @Column(name="version")
    private Integer version;

    @Column(name="amount")
    private Double amount;

    @Column(name="authorization_code")
    private String authorizationCode;

    @Column(name="billing_amount")
    private Double billingAmount;

    @Column(name="billing_currency_code")
    private String billingCurrencyCode;

    @Column(name="card_hash_id")
    private String cardHashId;

    @Column(name="card_number")
    private String cardNumber;

    @Column(name="channel")
    private String channel;

    @Column(name="client_id")
    private BigInteger clientId;

    @Column(name="comments")
    private String comments;

    @Column(name="current_balance")
    private Double currentBalance;

    @Column(name="customer_hash_id")
    private String customerHashId;

    @Column(name="dcc_amount")
    private Double dccAmount;

    @Column(name="dcc_currency")
    private String dccCurrency;

    @Column(name="effective_auth_amount")
    private Double effectiveAuthAmount;

    @Column(name="fee")
    private Double fee;

    @Column(name="institution_code")
    private String institutionCode;

    @Column(name="is_debit")
    private Boolean isDebit;

    @Column(name="merchant_category_code")
    private String merchantCategoryCode;

    @Column(name="merchant_id")
    private String merchantId;

    @Column(name="merchant_name")
    private String merchantName;

    @Column(name="network")
    private String network;

    @Column(name="product_code")
    private String productCode;

    @Column(name="program_id")
    private BigInteger programId;

    @Column(name="proxy_card_no")
    private String proxyCardNo;

    @Column(name="retrieval_ref_no")
    private String retrievalRefNo;

    @Column(name="settlement_amount")
    private Double settlementAmount;

    @Column(name="settlement_currency")
    private String settlementCurrency;

    @Column(name="settlement_status")
    private String settlementStatus;

    @Column(name="status")
    private String status;

    @Column(name="system_trace_audit_number")
    private String systemTraceAuditNumber;

    @Column(name="tenant")
    private String tenant;

    @Column(name="terminal_id")
    private String terminalId;

    @Column(name="trace_no")
    private String traceNo;

    @Column(name="transaction_amount")
    private Double  transactionAmount;

    @Column(name="transaction_currency_code")
    private String transactionCurrencyCode;

    @Column(name="transaction_ref_no")
    private String transactionRefNo;

    @Column(name="transaction_type")
    private String transactionType;

    @Column(name="auth_currency_id")
    private BigInteger authCurrencyId;

    @Column(name="pocket_definition_id")
    private BigInteger pocketDefinitionId;

    @Column(name="wallet_id")
    private BigInteger walletId;

    @Column(name="crdr")
    private String crdr;

    @Column(name="original_rrn")
    private String originalRrn;

    @Column(name="original_txn_date")
    private String originalTxnDate;

    @Column(name="cashback_amount")
    private Double cashbackAmount;


}
