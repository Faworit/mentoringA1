package com.epam.ryabtsev.model.impl;

import com.epam.ryabtsev.model.Event;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class EventImpl implements Event {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String title;
    private LocalDate date;
    private BigDecimal ticketPrice;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event")
    private UserImpl user;

    public EventImpl() {
    }

    public EventImpl(long id, String title, LocalDate date, BigDecimal ticketPrice) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.ticketPrice = ticketPrice;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    @Override
    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
