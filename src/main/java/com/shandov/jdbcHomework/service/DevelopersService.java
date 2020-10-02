package com.shandov.jdbcHomework.service;


import com.shandov.jdbcHomework.dao.DevelopersDAO;
import com.shandov.jdbcHomework.domain.Developers;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DevelopersService {

    private final DevelopersDAO developersDAO;

    public List<Developers> getAllDevelopersByProjectName(String message){
        return developersDAO.getAllDevelopersByProjectName(message);
    }

    public List<Developers> getAllJavaDevelopers(String message){
        return developersDAO.getAllJavaDevelopers(message);
    }

    public List<Developers> getAllMiddleDevelopers(String message){
        return developersDAO.getAllMiddleDevelopers(message);
    }
}
