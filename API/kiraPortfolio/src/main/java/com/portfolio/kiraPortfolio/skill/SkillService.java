package com.portfolio.kiraPortfolio.skill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {
  private final SkillRepository skillRepository;
  @Autowired
  public SkillService(SkillRepository skillRepository){
    this.skillRepository = skillRepository;
  }
  public List<Skill> getSkills(){
    return skillRepository.findAll();
  }
  public Skill addSkill(Skill skill){
    return skillRepository.save(skill);
  }
}
