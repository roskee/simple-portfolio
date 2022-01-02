package com.portfolio.kiraPortfolio.skill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "skills")
public class SkillController {
  private final SkillService skillService;
  @Autowired
  public SkillController(SkillService skillService){
    this.skillService = skillService;
  }
  @GetMapping
  public List<Skill> getSkills(){
    return skillService.getSkills();
  }
  @PostMapping
  public Skill addSkill(@RequestBody Skill skill){
    return skillService.addSkill(skill);
  }
}