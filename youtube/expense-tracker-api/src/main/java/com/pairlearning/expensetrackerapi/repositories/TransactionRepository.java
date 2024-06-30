package com.pairlearning.expensetrackerapi.repositories;

import java.util.List;
import com.pairlearning.expensetrackerapi.domain.Transaction;
import com.pairlearning.expensetrackerapi.exceptions.EtBadRequestException;
import com.pairlearning.expensetrackerapi.exceptions.EtResourceNotFoundException;

public interface TransactionRepository {
  
  List<Transaction> findAll(Integer userId, Integer categoryId);
  Transaction findByid(Integer userId, Integer categoryId, Integer transactionId) throws EtResourceNotFoundException;
  Integer create(Integer userId, Integer categoryId, Double amount, String note, Long transactionDate) throws EtBadRequestException;
  void update(Integer userId, Integer categoryId, Integer transactionId, Transaction transaction) throws EtBadRequestException;
  void removeById(Integer userId, Integer categoryId, Integer transactionId) throws EtResourceNotFoundException;

}
