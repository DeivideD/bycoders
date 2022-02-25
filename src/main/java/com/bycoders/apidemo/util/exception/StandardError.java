package com.bycoders.apidemo.util.exception;

public class StandardError {

  private Integer status;
  private String mensage;
  private String timeHour;


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getMensage() {
    return mensage;
  }

  public void setMensage(String mensage) {
    this.mensage = mensage;
  }

  public String getTimeHour() {
    return timeHour;
  }

  public void setTimeHour(String timeHour) {
    this.timeHour = timeHour;
  }
}
