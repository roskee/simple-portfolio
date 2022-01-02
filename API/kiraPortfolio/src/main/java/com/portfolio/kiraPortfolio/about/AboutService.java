package com.portfolio.kiraPortfolio.about;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AboutService {
  private final AboutRepository aboutRepository;
  @Autowired
  public AboutService(AboutRepository aboutRepository){
    this.aboutRepository = aboutRepository;
  }
  public List<About> getAbouts(){
    return aboutRepository.findAll();
  }
  public About addAbout(About about){
    return aboutRepository.save(about);
  }
}
