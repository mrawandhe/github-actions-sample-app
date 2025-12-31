package com.example;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Controller to expose order related endpoints */
@RestController
@RequestMapping("/api")
public class OrderController {

  @Autowired
  OrderService orderService;


  /** Fetches application details */
  @GetMapping("/details")
  public ResponseEntity<Map<String, String>> getAppDetails() {
    Map<String, String> appDetails = orderService.getAppDetails();
    return ResponseEntity.ok(appDetails);
  }

  /** Fetches order configuration and metadata details */
  @GetMapping("/config")
  public ResponseEntity<Map<String, String>> getOrderConfig() {
    Map<String, String> configMap = orderService.getOrderConfigMetadata();
    return ResponseEntity.ok(configMap);
  }

  /** Checks if application is up and running */
  @GetMapping("/health")
  public ResponseEntity<String> health() {
    return ResponseEntity.ok("github-actions-sample-app is up and running. App version 1.0.0. Testing longer line for checkstyle issue");
  }

}
