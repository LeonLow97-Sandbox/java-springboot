package com.stock.yahoofinancestock;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.stock.yahoofinancestock.model.StockWrapper;
import com.stock.yahoofinancestock.service.StockService;

@SpringBootTest
public class StockServiceTest {

  @Autowired
  private StockService stockService;

  @Test
  void invoke() throws IOException {
    final StockWrapper stock = stockService.findStock("BABA");
    System.out.println(stock.getStock());

    final BigDecimal price = stockService.findPrice(stock);
    System.out.println("Price: " + price);

    final BigDecimal change = stockService.findLastChangePercent(stock);
    System.out.println("Change in %: " + change);

    final BigDecimal mean200DayPercent = stockService.findChangeFrom200MeanPercent(stock);
    System.out.println("Percent from MA200: " + mean200DayPercent);
  }

  @Test
  void multiple() throws IOException, InterruptedException {
    final List<StockWrapper> stocks = stockService.findStocks(Arrays.asList("BABA", "GOOGL", "VOO"));
    findPrices(stocks);

    Thread.sleep(16000); // to refresh it

    final StockWrapper aa = stockService.findStock("AAPL");
    stocks.add(aa);

    System.out.println(stockService.findPrice(aa));

    findPrices(stocks);
  }

  private void findPrices(List<StockWrapper> stocks) {
    stocks.forEach(stock -> {
      try {
        System.out.println(stockService.findPrice(stock));
      } catch (IOException e) {
        System.out.println(e.getMessage());
      }
    });
  }

}
