package com.portfolio.kiraPortfolio.project;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table
public class ProjectImage {
  @Id
  @GeneratedValue(

    strategy = GenerationType.IDENTITY
  )
  private Long id;
  private String title;
  private String description;
  private String src;


  @ManyToOne(
    fetch = FetchType.LAZY,
    optional = false
  )
  @JoinColumn(name = "project_Id")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Project project;
  public Project getProject(){return project;}
  public ProjectImage(){

  }
  public ProjectImage(Long id, String title, String description, String src) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.src = src;
  }

  public ProjectImage(String title, String description, String src) {
    this.title = title;
    this.description = description;
    this.src = src;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getSrc() {
    return src;
  }

  public void setSrc(String src) {
    this.src = src;
  }

  public void setProject(Project project) {
    this.project = project;
  }
}
