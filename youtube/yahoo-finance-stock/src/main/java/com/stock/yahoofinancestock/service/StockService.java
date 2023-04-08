package com.stock.yahoofinancestock.service;

import java.io.IOException;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import com.stock.yahoofinancestock.model.StockWrapper;
import lombok.AllArgsConstructor;
import yahoofinance.YahooFinance;

@AllArgsConstructor
@Service
public class StockService {
  
  public StockWrapper findStock(final String ticker) {
    try {
      return new StockWrapper(YahooFinance.get(ticker));
    } catch (IOException e) {
      System.out.println("Error in finding stock: " + e.getMessage());
    }
    return null;
  }

  public BigDecimal findPrice(final StockWrapper stock) throws IOException {
    return stock.getStock().getQuote(true).getPrice();
  }

}
