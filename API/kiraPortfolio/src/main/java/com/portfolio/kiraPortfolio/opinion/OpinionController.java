package com.portfolio.kiraPortfolio.opinion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
  @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
  public Opinion addOpinion(Opinion opinion){
    return opinionService.addOpinion(opinion);
  }
  // FUCK THIS
  @PostMapping(path = "{id}")
  public Opinion updateOpinion(
    @PathVariable("id") Long id,
    @RequestParam(required = false) String title,
    @RequestParam(required = false) String content
  ){
    return opinionService.updateOpinion(id,title,content);
  }
  @GetMapping(path = "{id}")
  public Opinion getOpinionWithId(@PathVariable Long id){
    return opinionService.getOpinionById(id);
  }
}
