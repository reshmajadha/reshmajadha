package com.verinite.paymentservice.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Payment_Table")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Payments {
	@Id
	@GeneratedValue
	private Integer paymentId;
	private String paymentStatus;
	private String transactionId;
	private int id;
	private Integer amount;
	private String accountNumber;
	private String ifsc;
	private String bankName;
	private String branchName;
	private String customerName;
	private  boolean isDelete;
	private Integer doctorFee;

	public Payments(int i, String success, String ud52663, int i1, String s, String bkid, String boi, String pune, String jagruti, boolean b) {
	}
}
