package com.shandov.jdbcHomework.service;


import com.shandov.jdbcHomework.dao.DevelopersDAO;
import com.shandov.jdbcHomework.domain.Developers;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DevelopersService {

    private final DevelopersDAO developersDAO;

    public Developers getAllDevelopersByProjectName(String message){
        return developersDAO.getAllDevelopersByProjectName(message);
    }
}
