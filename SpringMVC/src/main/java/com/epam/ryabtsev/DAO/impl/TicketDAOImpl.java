package com.epam.ryabtsev.DAO.impl;

import com.epam.ryabtsev.DAO.TicketDAO;
import com.epam.ryabtsev.DAO.storage.Storage;
import com.epam.ryabtsev.model.Event;
import com.epam.ryabtsev.model.Ticket;
import com.epam.ryabtsev.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TicketDAOImpl implements TicketDAO {
    @Autowired
    Storage storage;

    private Map<Long, Ticket> tickets = storage.getTickets();

    @Override
    public Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category) {
        long max = tickets.keySet().stream().max(Long::compareTo).orElse(0L);
        var key = max + 1;
        Ticket ticket = new com.epam.ryabtsev.model.impl.TicketImpl(key, eventId, userId, category, place);
        tickets.put(key, ticket);

        return ticket;
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        List<Ticket> ticket = tickets.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .filter(p-> p.getUserId() == user.getId())
                .collect(Collectors.toList());
        System.out.println(ticket.get(0));
        return ticket;
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        List<Ticket> ticket = tickets.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .filter(p-> p.getEventId() == event.getId())
                .collect(Collectors.toList());
        System.out.println(ticket.get(0));
        return ticket;
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        boolean deleteResult = false;
        tickets.remove(ticketId);
        if (tickets.get(ticketId) == null) {
            deleteResult = true;
        }

        return deleteResult;
    }
}
