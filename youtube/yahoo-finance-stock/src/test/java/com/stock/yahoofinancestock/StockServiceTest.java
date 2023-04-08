package com.stock.yahoofinancestock;

import java.io.IOException;
import java.math.BigDecimal;
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
    final StockWrapper stock = stockService.findStock("TSLA");
    System.out.println(stock.getStock());

    final BigDecimal price = stockService.findPrice(stock);
    System.out.println(price);
  }

}
