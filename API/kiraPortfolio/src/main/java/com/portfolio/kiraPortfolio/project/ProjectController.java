package com.portfolio.kiraPortfolio.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping(path = "projects")
public class ProjectController {
  private final ProjectService projectService;
  @Autowired
  public ProjectController(ProjectService projectService){
      this.projectService = projectService;
  }
  @GetMapping
  public List<Project> getProjects(){
    return projectService.getProjects();
  }
  @PostMapping
  public Project addProject(@RequestBody Project project){
    return projectService.addProject(project);
  }

}
