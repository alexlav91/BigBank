package ru.al.bigbank.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GenericGenerator(
            name = "ID_GENERATOR",
            strategy = "increment",
            parameters = @org.hibernate.annotations.Parameter(name = "sequence_name", value = "MY_SEQUENCE")
    )
    @GeneratedValue(generator = "ID_GENERATOR")
    private long id;
    @Column(name = "client_name")
    private String clientName;
    @Column(name = "phone_numb")
    private String phoneNumb;

    @Column(name = "balance")
    private BigDecimal balance;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Payment> payments;


    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getPhoneNumb() {
        return phoneNumb;
    }

    public void setPhoneNumb(String phoneNumb) {
        this.phoneNumb = phoneNumb;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public long getId() {
        return id;


    }
}
