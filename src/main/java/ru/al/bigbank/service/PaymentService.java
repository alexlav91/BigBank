package ru.al.bigbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.al.bigbank.model.entity.Payment;
import ru.al.bigbank.repository.PaymentRepository;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public void savePayment(Payment payment){
        this.paymentRepository.save(payment);
    }

}
