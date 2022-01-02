package com.portfolio.kiraPortfolio.project;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Platform {
  @Id
  @GeneratedValue(
    strategy = GenerationType.IDENTITY
  )
  private Long id;
  private String platform;
  @ManyToMany(mappedBy = "platforms")
  private Set<Project> projects = new HashSet<>();
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPlatform() {
    return platform;
  }

  public void setPlatform(String platform) {
    this.platform = platform;
  }

  public Platform() {
  }

  public Platform(Long id, String platform) {
    this.id = id;
    this.platform = platform;
  }
}
