package com.portfolio.kiraPortfolio.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
  private final CompanyRepository companyRepository;
  @Autowired
  public CompanyService(CompanyRepository companyRepository){
    this.companyRepository = companyRepository;
  }

  public List<Company> getCompanies() {
    return companyRepository.findAll();
  }

  public Company addCompany(Company company) {
    return companyRepository.save(company);
  }
}
