package com.stock.yahoofinancestock.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.stock.yahoofinancestock.model.StockWrapper;
import lombok.AllArgsConstructor;
import yahoofinance.YahooFinance;

@AllArgsConstructor
@Service
public class StockService {

  private final RefreshService refreshService;
  
  public StockWrapper findStock(final String ticker) {
    try {
      return new StockWrapper(YahooFinance.get(ticker));
    } catch (IOException e) {
      System.out.println("Error in finding stock: " + e.getMessage());
    }
    return null;
  }

  public List<StockWrapper> findStocks(final List<String> tickers) {
    return tickers.stream().map(this::findStock).filter(Objects::nonNull).collect(Collectors.toList());
  }

  public BigDecimal findPrice(final StockWrapper stock) throws IOException {
    return stock.getStock().getQuote(refreshService.shouldRefresh(stock)).getPrice();
  }

  public BigDecimal findLastChangePercent(final StockWrapper stock) throws IOException {
    return stock.getStock().getQuote(refreshService.shouldRefresh(stock)).getChangeInPercent();
  }

  // 200MA
  public BigDecimal findChangeFrom200MeanPercent(final StockWrapper stock) throws IOException {
    return stock.getStock().getQuote(refreshService.shouldRefresh(stock)).getChangeFromAvg200InPercent();
  }

}
