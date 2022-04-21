package com.verinite.paymentservice.dto;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackDto {
    private int id;
    private String name;
    private String email;
    private String suggestion;
    private int scale;
    private String comments;
    private boolean isDelete;
}

