package com.developer.employeemanagement.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "emp_id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name= "gender")
  private String gender;

  @Column(name = "date_of_birth")
  private Date dateofBirth;

  @Column(name = "address")
  private String address;

  public EmployeeEntity() {
  }

  public EmployeeEntity(Long id, String name, String gender, Date dateofBirth, String address) {
    this.id = id;
    this.name = name;
    this.gender = gender;
    this.dateofBirth = dateofBirth;
    this.address = address;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGender() {
    return this.gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Date getDateofBirth() {
    return this.dateofBirth;
  }

  public void setDateofBirth(Date dateofBirth) {
    this.dateofBirth = dateofBirth;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


}
