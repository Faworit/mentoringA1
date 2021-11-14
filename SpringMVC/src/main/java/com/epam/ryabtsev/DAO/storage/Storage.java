package com.epam.ryabtsev.DAO.storage;

import com.epam.ryabtsev.model.Event;
import com.epam.ryabtsev.model.Ticket;
import com.epam.ryabtsev.model.User;
import com.epam.ryabtsev.model.impl.EventImpl;
import com.epam.ryabtsev.model.impl.TicketImpl;
import com.epam.ryabtsev.model.impl.UserImpl;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class Storage {

    private Map<Long, User> users;
    private Map<Long, Event> events;
    private Map<Long, Ticket> tickets;
    private static Storage storage = null;

    private Storage() {
        this.users = new ConcurrentHashMap<>();
        this.events = new ConcurrentHashMap<>();
        this.tickets = new ConcurrentHashMap<>();
        addDataToStorage();
    }

    private void addDataToStorage() {
        this.users.put(1L, new UserImpl(1, "Ivan", "test@mail.ru"));
        this.events.put(1L, new EventImpl(1, "test", new GregorianCalendar
                (2014, Calendar.FEBRUARY, 11).getTime()));
        this.tickets.put(1L, new TicketImpl(1, 1, 1, Ticket.Category.STANDARD, 1));

    }

    @PostConstruct
    public static Storage init() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    public Map<Long, User> getUsers() {
        return users;
    }

    public void setUsers(User user, Long id) {
        this.users.put(id, user);
    }

    public Map<Long, Event> getEvents() {
        return events;
    }

    public void setEvents(Long id, Event event) {
        this.events.put(id, event);
    }

    public Map<Long, Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Long id, Ticket ticket) {
        this.tickets.put(id, ticket);
    }
}
