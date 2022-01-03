package com.portfolio.kiraPortfolio.skill;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table
public class CertificationImage {
  @Id
  @GeneratedValue(
    strategy = GenerationType.IDENTITY
  )
  private Long id;
  private String src;
  public CertificationImage(){

  }

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

  public CertificationImage(Long id, String src){
    this.id = id;
    this.src= src;
  }
  @OneToOne(
    optional = false,
    fetch = FetchType.EAGER
  )
  @JoinColumn(name = "certificate")
  @JsonBackReference
  private Certificate certificate;
  public void setCertificate(Certificate certificate){this.certificate = certificate;}
  public Certificate getCertificate(){return certificate;}
}
