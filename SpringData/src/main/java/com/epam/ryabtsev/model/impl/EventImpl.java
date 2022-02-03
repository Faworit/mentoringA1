package com.epam.ryabtsev.model.impl;

import com.epam.ryabtsev.model.Event;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class EventImpl implements Event {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String title;
    private LocalDate date;
    private Integer ticketPrice;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user")
    private UserImpl user;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    List<TicketImpl> tickets = new ArrayList<>();

    public EventImpl() {
    }

    public EventImpl(long id, String title, LocalDate date, Integer ticketPrice) {
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
    public Integer getTicketPrice() {
        return ticketPrice;
    }

    @Override
    public void setTicketPrice(Integer ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public UserImpl getUser() {
        return user;
    }

    public void setUser(UserImpl user) {
        this.user = user;
    }

    public List<TicketImpl> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketImpl> tickets) {
        this.tickets = tickets;
    }


}
