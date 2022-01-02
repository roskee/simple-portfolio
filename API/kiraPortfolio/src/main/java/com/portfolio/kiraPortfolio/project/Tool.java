package com.portfolio.kiraPortfolio.project;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Tool {
  @Id
  @GeneratedValue(
    strategy = GenerationType.IDENTITY
  )
  private Long id;
  private String tool;
  @ManyToMany(mappedBy = "madeWith")
  private Set<Project> projects = new HashSet<>();
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTool() {
    return tool;
  }

  public void setTool(String tool) {
    this.tool = tool;
  }

  public Tool() {
  }

  public Tool(Long id, String tool) {
    this.id = id;
    this.tool = tool;
  }
}
