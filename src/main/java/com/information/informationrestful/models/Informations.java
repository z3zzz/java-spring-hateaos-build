package com.information.informationrestful.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Informations {
  private @Id @GeneratedValue(strategy=GenerationType.IDENTITY) Long id;
  private String title;
  private String content;

  public Informations() {}

  public Informations(String title, String content) {
    this.title = title;
    this.content = content;
  }

  public Long getId() {
    return id;
  }
  public String getTitle() {
    return title;
  }
  public String getContent() {
    return content;
  }

  public void setId(Long id) {
    this.id = id;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) 
      return true;
    if (!(o instanceof Informations)) 
      return false;

    Informations information = (Informations) o;

    return Objects.equals(this.id, information.id) 
      && Objects.equals(this.title, information.title) 
      && Objects.equals(this.content, information.content);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.title, this.content);
  }

  @Override
  public String toString() {
    return String.format("Information id = %s, title = %s, content = %s", id, title, content);
  }
}
