package com.epam.ryabtsev.model.impl;

import com.epam.ryabtsev.model.User;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserImpl implements User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String email;
    @OneToOne(cascade = CascadeType.REFRESH, orphanRemoval = true)
    @JoinColumn(name = "userAccountId")
    private UserAccountImpl userAccount;
    @OneToMany(mappedBy = "user")
    private List<EventImpl> event;
    @OneToMany(mappedBy = "user")
    private List<TicketImpl> tickets;

    public UserImpl() {
    }

    public UserImpl(long id, String name, String email, UserAccountImpl userAccount) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.userAccount = userAccount;
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
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public UserAccountImpl getUserAccount() {
        return userAccount;
    }

    @Override
    public void setUserAccount(UserAccountImpl userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public List<EventImpl> getEvent() {
        return event;
    }

    @Override
    public void setEvent(List<EventImpl> event) {
        this.event = event;
    }

    @Override
    public List<TicketImpl> getTickets() {
        return tickets;
    }

    @Override
    public void setTickets(List<TicketImpl> tickets) {
        this.tickets = tickets;
    }
}
