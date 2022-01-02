package com.portfolio.kiraPortfolio.about;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table
public class Education {
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
  @ManyToOne(
    fetch = FetchType.LAZY,
    optional = false
  )
  @JoinColumn(name = "about")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private About about;
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

  public String getSchool() {
    return school;
  }

  public void setSchool(String school) {
    this.school = school;
  }

  public Double getGrade() {
    return grade;
  }

  public void setGrade(Double grade) {
    this.grade = grade;
  }

  public Double getGradeBase() {
    return gradeBase;
  }

  public void setGradeBase(Double gradeBase) {
    this.gradeBase = gradeBase;
  }

  public Education(Long id, String title, String school, Double grade, Double gradeBase) {
    this.id = id;
    this.title = title;
    this.school = school;
    this.grade = grade;
    this.gradeBase = gradeBase;
  }

  public Education() {
  }

  private String title;
  private String school;
  private Double grade;
  private Double gradeBase;
}
