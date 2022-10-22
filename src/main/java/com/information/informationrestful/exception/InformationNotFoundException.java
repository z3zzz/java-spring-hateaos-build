package com.information.informationrestful.exception;

public class InformationNotFoundException extends RuntimeException {
  public InformationNotFoundException(String title) {
    super("There is no title: " + title);
  }
}
