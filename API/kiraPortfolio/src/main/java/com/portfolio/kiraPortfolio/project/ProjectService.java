package com.portfolio.kiraPortfolio.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectService {
  private final ProjectRepository projectRepository;
  @Autowired
  public ProjectService(ProjectRepository projectRepository){
    this.projectRepository = projectRepository;
  }
  public List<Project> getProjects(){
    return projectRepository.findAll();
  }

  public Project addProject(Project project) {
    return projectRepository.save(project);
  }
}
