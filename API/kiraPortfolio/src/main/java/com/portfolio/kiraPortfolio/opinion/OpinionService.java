package com.portfolio.kiraPortfolio.opinion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

  public Opinion getOpinionById(Long id) {
    return opinionRepository.findById(id).orElse(null);
  }
  @Transactional
  public Opinion updateOpinion(Long id, String title, String content) {
    Opinion opinion = opinionRepository.findById(id).orElse(null);
    if(opinion!=null){
      if(title !=null && title.length()>0 ) opinion.setTitle(title);
      if(content!=null && content.length()>0) opinion.setContent(content);
      return opinion;
    }else return null;
  }
}
