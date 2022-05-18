package com.projet.stock.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projet.stock.model.CreatePayment;
import com.projet.stock.model.CreatePaymentResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;



@RestController
public class StripeController {

	@PostMapping("/create-payment-intent")
	public CreatePaymentResponse createPaymentIntent(CreatePayment createPay) throws StripeException {

		PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
				.setAmount((long)  3 * 100) // Prix à payer
				.setCurrency("eur").setAutomaticPaymentMethods(
						PaymentIntentCreateParams.AutomaticPaymentMethods.builder().setEnabled(true).build())
				.build();

		// Create a PaymentIntent with the order amount and currency
		PaymentIntent paymentIntent = PaymentIntent.create(params);

		return new CreatePaymentResponse(paymentIntent.getClientSecret());
	}
}
