package com.portfolio.kiraPortfolio.company;

import javax.persistence.*;

@Entity
@Table
public class Company {
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
