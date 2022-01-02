package com.portfolio.kiraPortfolio.opinion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpinionService {
  private final OpinionRepository opinionRepository;
  @Autowired
  public OpinionService(OpinionRepository opinionRepository){
    this.opinionRepository = opinionRepository;
  }
  public Opinion addOpinion(Opinion opinion){
    return opinionRepository.save(opinion);
  }
  public List<Opinion> getOpinions(){
    return opinionRepository.findAll();
  }
}
