package com.portfolio.kiraPortfolio.company;

import javax.persistence.*;

@Entity
@Table
public class Company {
  public Company(){}
  public Company(Long id, String name, String website) {
    this.id = id;
    this.name = name;
    this.website = website;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
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
  @Column(
    nullable = false
  )
  private String name;
  private String website;
}
