package com.shandov.jdbc1homework.domain;

public enum DevGender {
    MALE("male"),
    FEMALE("female");

    private String devGender;

    DevGender(String devGender){
        this.devGender = devGender;
    }

    String getDevGender(){
        return devGender;
    }
}
