package com.bms.service;

import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.bms.entity.Payment;
import com.bms.integration.PaymentIntegration;
import com.bms.repository.PaymentRepository;
import com.razorpay.Order;

@Service
public class PaymentServiceImpl implements PaymentService {

	Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);
	private final PaymentRepository paymentRepository;
	private final PaymentIntegration paymentIntegration;
	private final ReentrantLock paymentLock = new ReentrantLock();

	@Autowired
	public PaymentServiceImpl(PaymentRepository paymentRepository, PaymentIntegration paymentIntegration) {
		this.paymentRepository = paymentRepository;
		this.paymentIntegration = paymentIntegration;
	}

	/**
	 * We need NOT be save Card details We should use synchronize block to maintain
	 * consistency(Atomicity) safe transaction Need to call Payment services API
	 * like paypal, Razorpay etc... Requirement: Razorpay Api key:
	 * https://razorpay.com/docs/payments/dashboard/account-settings/api-keys/ key
	 * Id, key secret
	 * 
	 */
	@Override
	@Transactional(rollbackFor = Throwable.class, isolation = Isolation.SERIALIZABLE)
	public Payment makePayment(Payment payment) {
		try {
			paymentLock.lock();
			Order order = paymentIntegration.createOrder(payment.getAmount());
			payment.setReceiptId(order.get("id"));
			paymentRepository.save(payment);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			paymentLock.unlock();
		}
		return payment;
	}

}
