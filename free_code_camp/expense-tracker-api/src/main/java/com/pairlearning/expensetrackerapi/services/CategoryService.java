package com.pairlearning.expensetrackerapi.services;

import java.util.List;
import com.pairlearning.expensetrackerapi.domain.Category;
import com.pairlearning.expensetrackerapi.exceptions.EtBadRequestException;
import com.pairlearning.expensetrackerapi.exceptions.EtResourceNotFoundException;

public interface CategoryService {
  
  List<Category> fetchAllCategories(Integer userId);
  Category fetchCategoryById(Integer userId, Integer categoryId) throws EtResourceNotFoundException;
  Category addCategory(Integer userId, String title, String description) throws EtBadRequestException;
  void updateCategory(Integer userId, Integer categoryId, Category category) throws EtBadRequestException;
  void removeCategoryWithAllTransactions(Integer userId, Integer categoryId) throws EtResourceNotFoundException; 

}
