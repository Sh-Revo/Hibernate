package com.shandov.jdbc1homework.domain;

import lombok.Data;

@Data
public class Customer {

    private Long customersId;
    private String customersName;
    private String customersSecondName;

    @Override
    public String toString() {
        return "Customer{" +
                "customersId=" + customersId +
                ", customersName='" + customersName + '\'' +
                ", customersSecondName='" + customersSecondName + '\'' +
                '}' + "\n";
    }
}
