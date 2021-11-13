package com.epam.ryabtsev.DAO.storage;

import com.epam.ryabtsev.model.Event;
import com.epam.ryabtsev.model.Ticket;
import com.epam.ryabtsev.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
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
