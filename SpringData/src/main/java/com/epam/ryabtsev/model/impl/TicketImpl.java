package com.epam.ryabtsev.model.impl;

import com.epam.ryabtsev.model.Ticket;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class TicketImpl implements Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private Category category;
    private int place;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event")
    private EventImpl event;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user")
    private UserImpl user;

    public TicketImpl() {
    }

    public TicketImpl(Category category, int place, EventImpl event, UserImpl user) {
        this.category = category;
        this.place = place;
        this.event = event;
        this.user = user;
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
    public Category getCategory() {
        return category;
    }

    @Override
    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public int getPlace() {
        return place;
    }

    @Override
    public void setPlace(int place) {
        this.place = place;
    }

    public EventImpl getEvent() {
        return event;
    }

    public void setEvent(EventImpl event) {
        this.event = event;
    }

    public UserImpl getUser() {
        return user;
    }

    public void setUser(UserImpl user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketImpl ticket = (TicketImpl) o;
        return id == ticket.id && place == ticket.place && category == ticket.category && Objects.equals(event, ticket.event) && Objects.equals(user, ticket.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, place, event, user);
    }
}
