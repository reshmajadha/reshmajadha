package com.verinite.paymentservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class VisitRequest {
    private int pet_id;
    private Date date;
    private String description;
    private boolean is_delete;

    public int getPet_id() {
        return pet_id;
    }

    public void setPet_id(int pet_id) {
        this.pet_id = pet_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIs_delete() {
        return is_delete;
    }

    public void setIs_delete(boolean is_delete) {
        this.is_delete = is_delete;
    }

    @Override
    public String toString() {
        return "VisitRequest{" +
                "pet_id=" + pet_id +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", is_delete=" + is_delete +
                '}';
    }

}
