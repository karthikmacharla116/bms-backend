package com.bms.integration;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Service
public class PaymentIntegration {
	private final RazorpayClient razorpayClient;

	@Autowired
    public PaymentIntegration(RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;
    }

    public Order createOrder(int amount) throws RazorpayException {
        JSONObject jsonOrder = new JSONObject();
        jsonOrder.put("amount", amount * 100); // Amount is in paise (e.g., 50000 paise = 500 INR)
        jsonOrder.put("currency", "INR");
        //jsonOrder.put("id", Double.toString(Math.random()*100)); //This can be Auto-Generated in real-time

        try {
            Order order = razorpayClient.orders.create(jsonOrder);
            return order;
        } catch (RazorpayException e) {
            throw e;
        }
    }	
}
