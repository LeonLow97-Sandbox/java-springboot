package com.developer.employeemanagement.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.developer.employeemanagement.entity.EmployeeEntity;
import com.developer.employeemanagement.repository.EmployeeRepository;
import com.developer.employeemanagement.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  EmployeeRepository employeeRepository;
  
  @Override
  public List<EmployeeEntity> findAllEmployee() {
    return employeeRepository.findAll();
  }

  @Override
  public Optional<EmployeeEntity> findById(Long id) {
    return employeeRepository.findById(id);
  }

  @Override
  public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity) {
    return employeeRepository.save(employeeEntity);
  }

  @Override
  public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {
    return employeeRepository.save(employeeEntity);
  }

  @Override
  public void deleteEmployee(Long id) {
    employeeRepository.deleteById(id);    
  }

}
