package com.projet.stock;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stripe.Stripe;

@SpringBootApplication
public class PStockApplication {
	@PostConstruct
	public void setup() {
	    Stripe.apiKey = "sk_test_VePHdqKTYQjKNInc7u56JBrQ";
	    
	}

	public static void main(String[] args) {
		SpringApplication.run(PStockApplication.class, args);
	}

}
