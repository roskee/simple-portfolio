package com.portfolio.kiraPortfolio.skill;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Skill implements Serializable {
  @Id
  @GeneratedValue(
    strategy = GenerationType.IDENTITY
  )
  private Long id;
  private String title;
  private LocalDate since;

  public Skill(Long id, String title, LocalDate since, String description, Set<Certificate> certificates) {
    this.id = id;
    this.title = title;
    this.since = since;
    this.description = description;
    this.certificates = certificates;
  }

  private String description;

  public Skill() {
  }

  @OneToMany (mappedBy = "skill",cascade = CascadeType.ALL,orphanRemoval = true)
  private Set<Certificate> certificates = new HashSet<>();

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

  public LocalDate getSince() {
    return since;
  }

  public void setSince(LocalDate since) {
    this.since = since;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Set<Certificate> getCertificates() {
    return certificates;
  }

  public void setCertificates(Set<Certificate> certificates) {
    this.certificates = certificates;
    for(Certificate certificate:certificates)
      certificate.setSkill(this);
  }

  @Override
  public String toString() {
    return "Skill{" +
      "id=" + id +
      ", title='" + title + '\'' +
      ", since=" + since +
      ", description='" + description + '\'' +
      ", certificates=" + certificates +
      '}';
  }
}
