package com.portfolio.kiraPortfolio.skill;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Certificate {
  public Certificate(Long id, String title, LocalDate date, CertificationImage image) {
    this.id = id;
    this.title = title;
    this.date = date;
    this.image = image;
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

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public CertificationImage getImage() {
    return image;
  }

  public void setImage(CertificationImage image) {
    this.image = image;
  }

  public Certificate() {
  }

  @Id
  @SequenceGenerator(
    name = "skill_sequence",
    sequenceName = "skill_sequence"
  )
  @GeneratedValue(
    generator = "skill_sequence",
    strategy = GenerationType.SEQUENCE
  )
  private Long id;
  private String title;
  private LocalDate date;
  @ManyToOne(
    fetch = FetchType.LAZY,
    optional = false
  )
  @JoinColumn(name = "skill")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Skill skill;

  public Skill getSkill() {
    return skill;
  }

  public void setSkill(Skill skill) {
    this.skill = skill;
  }

  @OneToOne(mappedBy = "certificate",cascade = CascadeType.ALL)
  private CertificationImage image;
}
