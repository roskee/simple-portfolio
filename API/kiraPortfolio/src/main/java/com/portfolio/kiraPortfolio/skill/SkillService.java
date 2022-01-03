package com.portfolio.kiraPortfolio.skill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {
  private final SkillRepository skillRepository;
  private final CertificateRepository certificateRepository;
  @Autowired
  public SkillService(SkillRepository skillRepository,CertificateRepository certificateRepository){
    this.skillRepository = skillRepository;
    this.certificateRepository= certificateRepository;
  }
  public List<Skill> getSkills(){
    return skillRepository.findAll();
  }
  public Skill addSkill(Skill skill){
    return skillRepository.save(skill);
  }

  public List<Certificate> getTopCertificates() {
    List<Certificate> certificates = certificateRepository.getTopCertificates();
    System.out.println(certificates.size());
    return certificates;
  }
}
