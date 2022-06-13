package ru.al.bigbank.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name ="client")
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(name="client_name")
    private String clientName;
    @Column(name="phone_numb")
    private String phoneNumb;
    @Column(name="balance")
    private BigDecimal balance;

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

    public long getId() {
        return id;

    }
}
