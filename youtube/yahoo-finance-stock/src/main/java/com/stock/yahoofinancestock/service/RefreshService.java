package com.stock.yahoofinancestock.service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import org.springframework.stereotype.Service;

@Service
public class RefreshService {

  // For refreshing the stock data to fetch the latest data
  private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

}
