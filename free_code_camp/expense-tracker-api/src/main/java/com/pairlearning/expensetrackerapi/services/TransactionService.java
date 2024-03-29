package com.pairlearning.expensetrackerapi.services;

import java.util.List;
import com.pairlearning.expensetrackerapi.domain.Transaction;
import com.pairlearning.expensetrackerapi.exceptions.EtBadRequestException;
import com.pairlearning.expensetrackerapi.exceptions.EtResourceNotFoundException;

public interface TransactionService {
  
  List<Transaction> fetchAllTransactions(Integer userId, Integer categoryId);
  Transaction fetchTransactionById(Integer userId, Integer categoryId, Integer transactionId) throws EtResourceNotFoundException;
  Transaction addTransaction(Integer userId, Integer categoryId, Double amount, String note, Long transactionDate) throws EtBadRequestException;
  void updateTransaction(Integer userId, Integer categoryId, Integer transactionId, Transaction transaction) throws EtBadRequestException;
  void removeTransaction(Integer userId, Integer categoryId, Integer transactionId) throws EtResourceNotFoundException;

}
