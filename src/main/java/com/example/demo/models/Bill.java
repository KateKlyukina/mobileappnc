package com.example.demo.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity/* аннотация - данная сущность является отображаемой на некую таблицу в базе*/
@Table(name = "bills")/*передает название целевой таблицы*/
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)/*определяет стратегию*/
    private Integer id;

    private String currency;/*валюта*/
    private Integer amount;/*количество*/

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public Bill() {
    }

    public Bill(Integer id, User user, String currency, Integer amount) {
        this.id = id;
        this.user = user;
        this.currency = currency;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency( String currency ) {
        this.currency = currency;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", currency=" + currency +
                ", amount='" + amount + '\'' +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
