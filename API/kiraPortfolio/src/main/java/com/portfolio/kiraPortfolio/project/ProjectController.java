package com.portfolio.kiraPortfolio.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
  public List<Project> getProjects(
    @Validated @RequestParam(required = false) Boolean featured
  ){
    if(featured!=null)return projectService.getProjectsWithFeatured(featured);
    return projectService.getProjects();
  }
  @GetMapping(path = "{id}")
  public Project getProjectsWith(@PathVariable Long id){
    return projectService.getProject(id);
  }
  @PostMapping
  public Project addProject(@RequestBody Project project){
    return projectService.addProject(project);
  }
}
