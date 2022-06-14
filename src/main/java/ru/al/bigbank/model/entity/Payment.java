package ru.al.bigbank.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name ="payment")
public class Payment {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(name ="date_of_payment")
    private String dateOfPayment;
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name="sender")
    private List <Client> sender;
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "recipient")
    private List <Client> recipient;

    @Column(name="transfer")
    private BigDecimal transfer;
    @Column(name="message")
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BigDecimal getTransfer() {
        return transfer;
    }

    public void setTransfer(BigDecimal transfer) {
        this.transfer = transfer;
    }

    public List<Client> getSender() {
        return sender;
    }

    public void setSender(List<Client> sender) {
        this.sender = sender;
    }

    public List<Client> getRecipient() {
        return recipient;
    }

    public void setRecipient(List<Client> recipient) {
        this.recipient = recipient;
    }
}