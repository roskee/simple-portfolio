package com.portfolio.kiraPortfolio.about;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "about")
public class AboutController {
  private final AboutService aboutService;
  @Autowired
  public AboutController(AboutService aboutService){
    this.aboutService = aboutService;
  }
  @GetMapping
  public List<About> getAbouts(){
    return aboutService.getAbouts();
  }
  @PostMapping
  public About addAbout(@RequestBody About about){
    return aboutService.addAbout(about);
  }
}
