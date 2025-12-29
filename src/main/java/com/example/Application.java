package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    @GetMapping("/details")
    public ResponseEntity<String> getAppDetails(){
        return ResponseEntity.ok("github-actions-sample-app is up and running. App version 1.0.0");
    }

    @GetMapping("/health")
    public ResponseEntity<String> health(){
        return ResponseEntity.ok("github-actions-sample-app is up and running. App version 1.0.0");
    }

}
