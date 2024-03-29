package com.pairlearning.expensetrackerapi.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pairlearning.expensetrackerapi.domain.Transaction;
import com.pairlearning.expensetrackerapi.exceptions.EtBadRequestException;
import com.pairlearning.expensetrackerapi.exceptions.EtResourceNotFoundException;
import com.pairlearning.expensetrackerapi.repositories.TransactionRepository;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

  @Autowired
  TransactionRepository transactionRepository;
  
  @Override
  public List<Transaction> fetchAllTransactions(Integer userId, Integer categoryId) {
    return transactionRepository.findAll(userId, categoryId);
  }

  @Override
  public Transaction fetchTransactionById(Integer userId, Integer categoryId, Integer transactionId)
      throws EtResourceNotFoundException {
    return transactionRepository.findByid(userId, categoryId, transactionId);
  }

  @Override
  public Transaction addTransaction(Integer userId, Integer categoryId, Double amount, String note,
      Long transactionDate) throws EtBadRequestException {
    int transactionId = transactionRepository.create(userId, categoryId, amount, note, transactionDate);
    return transactionRepository.findByid(userId, categoryId, transactionId);
  }

  @Override
  public void updateTransaction(Integer userId, Integer categoryId, Integer transactionId,
      Transaction transaction) throws EtBadRequestException {
    transactionRepository.update(userId, categoryId, transactionId, transaction);
    
  }

  @Override
  public void removeTransaction(Integer userId, Integer categoryId, Integer transactionId)
      throws EtResourceNotFoundException {
      transactionRepository.removeById(userId, categoryId, transactionId);
  }

} 
