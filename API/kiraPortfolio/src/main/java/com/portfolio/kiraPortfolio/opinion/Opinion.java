package com.portfolio.kiraPortfolio.opinion;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Opinion {
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
  private String title;
  @Column(
    nullable = false
  )
  private LocalDate date;
  @Column(
    nullable = false
  )
  private String content;

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

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Opinion(Long id, String title, LocalDate date, String content) {
    this.id = id;
    this.title = title;
    this.date = date;
    this.content = content;
  }

  public Opinion() {
  }
}
