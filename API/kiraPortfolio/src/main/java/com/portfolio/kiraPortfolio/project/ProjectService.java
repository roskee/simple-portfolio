package com.portfolio.kiraPortfolio.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

  public Project getProject(Long id) {
    Optional<Project> project = projectRepository.findById(id);
    return project.orElse(null);
  }

  public List<Project> getProjectsWithFeatured(Boolean featured){
    return projectRepository.findByFeatured(featured);
  }

  public List<Platform> getPlatforms() {
    return projectRepository.findPlatforms();
  }

  public List<Tool> getTools() {
    return projectRepository.findTools();
  }
}
