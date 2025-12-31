package com.example;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/** Service class to handle business logic related to orders **/
@Service
public class OrderService {

  @Value("${app.name}")
  String applicationName;

  @Value("${app.version}")
  String applicationVersion;

  @Value("${app.notification.enabled}")
  String isNotificationEnabled;

  public Map<String, String> getAppDetails() {
    return Map.of("App name", applicationName,
        "App version", applicationVersion,
        "Notification Enabled", isNotificationEnabled);
  }


  public Map<String, String> getOrderConfigMetadata() {
    return Map.of("threshold", "10000.00",
        "minOrderValue", "500.00",
        "currency", "INR");
  }

}
