package com.portfolio.kiraPortfolio.about;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table
public class Email {
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
  private String email;
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Email(Long id, String email) {
    this.id = id;
    this.email = email;
  }

  public Email() {
  }
}
