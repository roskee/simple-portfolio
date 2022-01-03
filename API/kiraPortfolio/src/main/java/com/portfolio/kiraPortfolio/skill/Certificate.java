package com.portfolio.kiraPortfolio.skill;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Certificate {
  public Certificate(Long id, String title, LocalDate date,String school,Boolean topCertificate) {
    this.id = id;
    this.title = title;
    this.date = date;
    this.school = school;
    this.topCertificate=topCertificate;

  }

  public Certificate(String school, String title, LocalDate date, Boolean topCertificate, CertificationImage image, Skill skill) {
    this.school = school;
    this.title = title;
    this.date = date;
    this.topCertificate = topCertificate;
    this.image = image;
    this.skill = skill;
  }

  private String school;

  public String getSchool() {
    return school;
  }

  public void setSchool(String school) {
    this.school = school;
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


  @Override
  public String toString() {
    return "Certificate{" +
      "id=" + id +
      ", title='" + title + '\'' +
      ", date=" + date +
      ", skill=" + skill +
      '}';
  }

  public Certificate() {
  }

  @Id
  @GeneratedValue(
    strategy = GenerationType.IDENTITY
  )
  private Long id;
  private String title;
  private LocalDate date;

  @Column(
    columnDefinition = "boolean default false"
  )
  private Boolean topCertificate;

  public Boolean getTopCertificate() {
    return topCertificate;
  }

  public void setTopCertificate(Boolean topCertificate) {
    this.topCertificate = topCertificate;
  }

  @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
  @JsonManagedReference
  private CertificationImage image;
  public CertificationImage getImage(){return image;}
  public void setImage(CertificationImage image){this.image = image;image.setCertificate(this);}
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

}
