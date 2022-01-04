package com.epam.ryabtsev.service.impl;

import com.epam.ryabtsev.DAO.TicketDAO;
import com.epam.ryabtsev.model.Event;
import com.epam.ryabtsev.model.Ticket;
import com.epam.ryabtsev.model.User;
import com.epam.ryabtsev.model.impl.EventImpl;
import com.epam.ryabtsev.model.impl.TicketImpl;
import com.epam.ryabtsev.model.impl.UserImpl;
import com.epam.ryabtsev.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketDAO ticketDAO;

    @Override
    public Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category) {
        EventImpl event = new EventImpl();
        event.setId(eventId);
        UserImpl user = new UserImpl();
        user.setId(userId);
        TicketImpl ticket = new TicketImpl(category, place, event, user);
        return ticketDAO.save(ticket);
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return ticketDAO.getTicketImplByUser(user);
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return ticketDAO.getTicketImplByEvent(event);
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        return ticketDAO.deleteById(ticketId);
    }
}
