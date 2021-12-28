package com.epam.ryabtsev.model;

import com.epam.ryabtsev.model.impl.EventImpl;
import com.epam.ryabtsev.model.impl.TicketImpl;
import com.epam.ryabtsev.model.impl.UserAccountImpl;

import java.util.List;

/**
 * Created by maksym_govorischev on 14/03/14.
 */
public interface User {
    /**
     * User Id. UNIQUE.
     * @return User Id.
     */
    long getId();
    void setId(long id);
    String getName();
    void setName(String name);
    List<EventImpl> getEvent();
    void setEvent(List<EventImpl> event);
    List<TicketImpl> getTickets();
    void setTickets(List<TicketImpl> tickets);
    UserAccountImpl getUserAccount();
    void setUserAccount(UserAccountImpl userAccount);

    /**
     * User email. UNIQUE.
     * @return User email.
     */
    String getEmail();
    void setEmail(String email);
}
