package com.verinite.paymentservice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PaymentRequest {
    private Integer paymentId;
    private String paymentStatus;
    private String transactionId;
    private Integer amount;
    private String accountNumber;
    private String ifsc;
    private String bankName;
    private String branchName;
    private String customerName;
    private boolean isDelete;
}

