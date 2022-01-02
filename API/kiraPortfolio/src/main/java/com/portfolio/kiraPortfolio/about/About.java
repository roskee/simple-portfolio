package com.portfolio.kiraPortfolio.about;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class About {
  @Id
  @SequenceGenerator(
    name = "skill_sequence",
    sequenceName = "skill_sequence"
  )
  @GeneratedValue(
    generator = "skill_sequence",
    strategy = GenerationType.SEQUENCE
  )
  public Long id;
  private String name;

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

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }

  public String getResidence() {
    return residence;
  }

  public void setResidence(String residence) {
    this.residence = residence;
  }

  public String getShortDescription() {
    return shortDescription;
  }

  public void setShortDescription(String shortDescription) {
    this.shortDescription = shortDescription;
  }

  public String getEarlyLife() {
    return earlyLife;
  }

  public void setEarlyLife(String earlyLife) {
    this.earlyLife = earlyLife;
  }

  public String getWorkHistory() {
    return workHistory;
  }

  public void setWorkHistory(String workHistory) {
    this.workHistory = workHistory;
  }

  public String getPassionAndGoal() {
    return passionAndGoal;
  }

  public void setPassionAndGoal(String passionAndGoal) {
    this.passionAndGoal = passionAndGoal;
  }

  public String getGithub() {
    return github;
  }

  public void setGithub(String github) {
    this.github = github;
  }

  public String getLinkedIn() {
    return linkedIn;
  }

  public void setLinkedIn(String linkedIn) {
    this.linkedIn = linkedIn;
  }

  public String getCalendy() {
    return calendy;
  }

  public void setCalendy(String calendy) {
    this.calendy = calendy;
  }

  public About() {
  }

  public About(Long id, String name, Integer age, String nationality, String residence, String shortDescription, String earlyLife, String workHistory, String passionAndGoal, String github, String linkedIn, String calendy) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.nationality = nationality;
    this.residence = residence;
    this.shortDescription = shortDescription;
    this.earlyLife = earlyLife;
    this.workHistory = workHistory;
    this.passionAndGoal = passionAndGoal;
    this.github = github;
    this.linkedIn = linkedIn;
    this.calendy = calendy;
  }

  private Integer age;
  private String nationality;
  private String residence;
  private String shortDescription;
  private String earlyLife;
  private String workHistory;
  private String passionAndGoal;
  private String github,linkedIn,calendy;
  @OneToMany(
    mappedBy = "about",
    cascade = CascadeType.ALL
  )
  private Set<Education> educations = new HashSet<>();
  @OneToMany(
    mappedBy = "about",
    cascade = CascadeType.ALL
  )
  private Set<Phone> phones = new HashSet<>();
  @OneToMany(
    mappedBy = "about",
    cascade = CascadeType.ALL
  )
  private Set<Email> emails = new HashSet<>();
}
