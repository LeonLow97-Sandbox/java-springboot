package com.pairlearning.expensetrackerapi.domain;

public class Transaction {
  
  private Integer transactionId;
  private Integer categoryId;
  private Integer userId;
  private Double amount;
  private String note;
  private Long transactionDate;

  public Transaction(Integer transactionId, Integer categoryId, Integer userId, Double amount, String note, Long transactionDate) {
    this.transactionId = transactionId;
    this.categoryId = categoryId;
    this.userId = userId;
    this.amount = amount;
    this.note = note;
    this.transactionDate = transactionDate;
  }

  public Integer getTransactionId() {
    return this.transactionId;
  }

  public void setTransactionId(Integer transactionId) {
    this.transactionId = transactionId;
  }

  public Integer getCategoryId() {
    return this.categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  public Integer getUserId() {
    return this.userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Double getAmount() {
    return this.amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public String getNote() {
    return this.note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public Long getTransactionDate() {
    return this.transactionDate;
  }

  public void setTransactionDate(Long transactionDate) {
    this.transactionDate = transactionDate;
  }


}
