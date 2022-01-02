package com.portfolio.kiraPortfolio.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "companies")
public class CompanyController {
  private final CompanyService companyService;
  @Autowired
  public CompanyController(CompanyService companyService){
    this.companyService = companyService;
  }
  @GetMapping
  public List<Company> getCompanies(){
    return companyService.getCompanies();
  }
  @PostMapping
  public Company addCompany(@RequestBody Company company){
    return companyService.addCompany(company);
  }
}
