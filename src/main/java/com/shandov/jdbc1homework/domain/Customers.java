package com.shandov.jdbc1homework.domain;

import lombok.Data;

@Data
public class Customers {

    private Long customersId;
    private String customersName;
    private String customersSecondName;

    @Override
    public String toString() {
        return "Customers{" +
                "customersId=" + customersId +
                ", customersName='" + customersName + '\'' +
                ", customersSecondName='" + customersSecondName + '\'' +
                '}' + "\n";
    }
}
