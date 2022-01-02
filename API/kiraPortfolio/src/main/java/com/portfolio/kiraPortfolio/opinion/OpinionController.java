package com.portfolio.kiraPortfolio.opinion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "opinions")
public class OpinionController {
  private final OpinionService opinionService;
  @Autowired
  public OpinionController(OpinionService opinionService){
    this.opinionService = opinionService;
  }
  @GetMapping
  public List<Opinion> getOpinions(){
    return opinionService.getOpinions();
  }
  @PostMapping
  public Opinion addOpinion(@RequestBody Opinion opinion){
    return opinionService.addOpinion(opinion);
  }
  @PostMapping(path = "{id}")
  public Opinion getOpinionWithId(@PathVariable Long id){
    return opinionService.getOpinionById(id);
  }
}
