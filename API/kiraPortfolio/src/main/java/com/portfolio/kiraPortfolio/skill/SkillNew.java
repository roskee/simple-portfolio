package com.portfolio.kiraPortfolio.skill;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class SkillNew {
  @Id
  @GeneratedValue(
    strategy = GenerationType.IDENTITY
  )
  private Long id;
  private String title;
  private String description;
  private LocalDate since;
  @OneToMany(
    mappedBy = "skill",
    cascade = CascadeType.ALL
  )
  private Set<Certificate> certificates = new HashSet<>();
  public SkillNew(){

  }

  public SkillNew(Long id, String title, String description, LocalDate since) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.since = since;
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

  public LocalDate getSince() {
    return since;
  }

  public void setSince(LocalDate since) {
    this.since = since;
  }

  @Override
  public String toString() {
    return "SkillNew{" +
      "id=" + id +
      ", title='" + title + '\'' +
      ", description='" + description + '\'' +
      ", since='"+since+'\''+
      '}';
  }
}
