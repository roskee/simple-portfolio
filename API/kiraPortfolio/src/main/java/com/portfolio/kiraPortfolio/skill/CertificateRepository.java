package com.portfolio.kiraPortfolio.skill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CertificateRepository extends JpaRepository<Certificate,Long> {
  @Query(value = "select * from Certificate c where c.top_certificate=true",nativeQuery = true)
  List<Certificate> getTopCertificates();
}
