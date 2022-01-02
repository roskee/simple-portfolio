package com.portfolio.kiraPortfolio.skill;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Skill {
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

  @OneToMany (mappedBy = "skill",cascade = CascadeType.ALL)
  private Set<Certificate> certificates = new HashSet<>();
}
