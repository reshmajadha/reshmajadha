package com.verinite.paymentservice.dto;


import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContactUsDto {
    private int id;
    private String email;
    private String name;
    private String subject;
    private String message;
}
