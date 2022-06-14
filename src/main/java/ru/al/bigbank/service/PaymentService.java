package ru.al.bigbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.al.bigbank.model.dto.PaymentDTO;
import ru.al.bigbank.model.entity.Client;
import ru.al.bigbank.model.entity.Payment;
import ru.al.bigbank.repository.ClientRepository;
import ru.al.bigbank.repository.PaymentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService {

    private PaymentRepository paymentRepository;

    private ClientRepository clientRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository, ClientRepository clientRepository) {
        this.paymentRepository = paymentRepository;
        this.clientRepository = clientRepository;
    }

    public void savePayment(PaymentDTO payment){
        Payment payment1=new Payment();
        payment1.setDateOfPayment(payment.getDateOfPayment());
        Client client = clientRepository.findById(payment.getSender()).orElseThrow();
        Client client2 = clientRepository.findById(payment.getRecipient()).orElseThrow();
        client.setBalance(client.getBalance().subtract(payment.getTransfer()));
        client2.setBalance(client2.getBalance().add(payment.getTransfer()));
        List<Client> senders = new ArrayList<>();
        senders.add(client);
        payment1.setSender(senders);
        List<Client> recipients = new ArrayList<>();
        recipients.add(client2);
        payment1.setRecipient(recipients);
        payment1.setTransfer(payment.getTransfer());
        payment1.setMessage(payment.getMessage());
        client.getPayments().add(payment1);
        client2.getPayments().add(payment1);
        this.paymentRepository.save(payment1);
    }

}
