package com.portfolio.kiraPortfolio.project;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Project {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title, shortDescription,github,
  playStore,video;

  public Set<ProjectImage> getImages() {
    return images;
  }

  public void setImages(Set<ProjectImage> images) {
    this.images = images;
    for(ProjectImage image : images)
      image.setProject(this);
  }

  @OneToMany(
    mappedBy = "project",
    cascade = CascadeType.ALL

  )
  private Set<ProjectImage> images = new HashSet<>();
  @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
      name = "project_platform",
      joinColumns = @JoinColumn(name="project_id",referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "platform_id",referencedColumnName = "id")
    )
  Set<Platform> platforms = new HashSet<>();
  @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
      name = "project_tool",
      joinColumns = @JoinColumn(name = "project_id",referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name="tool_id",referencedColumnName = "id")
    )
  Set<Tool> madeWith = new HashSet<>();
  private Boolean featured;

  public Set<Platform> getPlatforms() {
    return platforms;
  }

  public void setPlatforms(Set<Platform> platforms) {
    this.platforms = platforms;
  }

  public Set<Tool> getMadeWith() {
    return madeWith;
  }

  public void setMadeWith(Set<Tool> madeWith) {
    this.madeWith = madeWith;
  }

  public Project(){

  }
  public Project(Long id, String title, String shortDescription, String github, String playStore, String video, Set<ProjectImage> images, Set<Platform> platforms, Set<Tool> madeWith, Boolean featured) {
    this.id = id;
    this.title = title;
    this.shortDescription = shortDescription;
    this.github = github;
    this.playStore = playStore;
    this.video = video;
    this.images = images;
    this.platforms = platforms;
    this.madeWith = madeWith;
    this.featured = featured;
  }

  public Project(String title, String shortDescription, String github, String playStore, String video, Boolean featured) {
    this.title = title;
    this.shortDescription = shortDescription;
    this.github = github;
    this.playStore = playStore;
    this.video = video;
    this.featured = featured;
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

  public String getShortDescription() {
    return shortDescription;
  }

  public void setShortDescription(String short_description) {
    this.shortDescription = short_description;
  }

  public String getGithub() {
    return github;
  }

  public void setGithub(String github) {
    this.github = github;
  }

  public String getPlayStore() {
    return playStore;
  }

  public void setPlayStore(String playStore) {
    this.playStore = playStore;
  }

  public String getVideo() {
    return video;
  }

  public void setVideo(String video) {
    this.video = video;
  }

  public Boolean getFeatured() {
    return featured;
  }

  public void setFeatured(Boolean featured) {
    this.featured = featured;
  }
}
