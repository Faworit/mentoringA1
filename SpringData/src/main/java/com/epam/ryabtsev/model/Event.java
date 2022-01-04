package com.epam.ryabtsev.model;

import com.epam.ryabtsev.model.impl.TicketImpl;
import com.epam.ryabtsev.model.impl.UserImpl;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by maksym_govorischev.
 */
public interface Event {
    /**
     * Event id. UNIQUE.
     * @return Event Id
     */
    long getId();
    void setId(long id);
    String getTitle();
    void setTitle(String title);
    LocalDate getDate();
    void setDate(LocalDate date);
    Integer getTicketPrice();
    void setTicketPrice(Integer ticketPrice);
    List<TicketImpl> getTickets();
    void setTickets(List<TicketImpl> tickets);
    UserImpl getUser();
    void setUser(UserImpl user);
}
