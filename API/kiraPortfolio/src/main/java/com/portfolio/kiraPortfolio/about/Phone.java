package com.portfolio.kiraPortfolio.about;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table
public class Phone {
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

  public About getAbout() {
    return about;
  }

  public void setAbout(About about) {
    this.about = about;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Phone(Long id, String phone) {
    this.id = id;
    this.phone = phone;
  }

  private String phone;
  public Phone(){

  }
}
