package ru.al.bigbank.model.dto;

import ru.al.bigbank.model.entity.Client;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.List;

public class PaymentDTO {
    private long id;

    private String dateOfPayment;
    private Long sender;
    private Long recipient;
    private BigDecimal transfer;
    private String message;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(String dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public Long getSender() {
        return sender;
    }

    public void setSender(Long sender) {
        this.sender = sender;
    }

    public BigDecimal getTransfer() {
        return transfer;
    }

    public void setTransfer(BigDecimal transfer) {
        this.transfer = transfer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getRecipient() {
        return recipient;
    }

    public void setRecipient(Long recipient) {
        this.recipient = recipient;
    }
}
