package com.shandov.jdbc1homework.service;


import com.shandov.jdbc1homework.dao.CompanyDAO;
import com.shandov.jdbc1homework.domain.Company;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CompanyService {

    private final CompanyDAO companyDAO;

//    public Company fingCompanyById(Long id){
//        return companyDAO.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("Company not found by id "+ id));
//    }

    public void insertInCompany(Company company){
        companyDAO.insert(company);
    }

    public void updateInCompany(Company company){
        companyDAO.update(company, company.getId());
    }

    public void deleteInCompany(Long id){
        companyDAO.delete(id);
    }

    public List<Company> getAllCompanies(){
        return companyDAO.getAll();
    }

    public Optional<Company> getCompanyByName(String name){
        return companyDAO.getCompanyByName(name);
    }

}
