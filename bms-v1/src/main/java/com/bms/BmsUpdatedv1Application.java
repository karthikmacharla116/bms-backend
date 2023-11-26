package com.bms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@SpringBootApplication
public class BmsUpdatedv1Application {
	
	@Value("${razorpay1.secretid}")
	private static String SECRET_ID;// Secret ID
	@Value("${razorpay1.secretkey}")
	private static String SECRET_KEY;// Secret Key

	public static void main(String[] args) {
		SpringApplication.run(BmsUpdatedv1Application.class, args);
	}
    
    @Bean
    RazorpayClient razorpayClient() throws RazorpayException {
        return new RazorpayClient("rzp_test_wmDl5TjphiigG5", "GLHzG7KW47OM0n8fcpWlmwQQ");
    }

}
