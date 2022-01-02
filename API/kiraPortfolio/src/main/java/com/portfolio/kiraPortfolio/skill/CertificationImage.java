package com.portfolio.kiraPortfolio.skill;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table
public class CertificationImage {
  public CertificationImage() {
  }

  public CertificationImage(Long id, String src, Certificate certificate) {
    this.id = id;
    this.src = src;
    this.certificate = certificate;
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
  private String src;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSrc() {
    return src;
  }

  public void setSrc(String src) {
    this.src = src;
  }

  public Certificate getCertificate() {
    return certificate;
  }

  public void setCertificate(Certificate certificate) {
    this.certificate = certificate;
  }

  @OneToOne(
    fetch = FetchType.LAZY,
    optional = false
  )
  @JoinColumn(name = "certificate")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Certificate certificate;
}
