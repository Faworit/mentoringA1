package com.epam.ryabtsev.DAO.impl;

import com.epam.ryabtsev.DAO.EventDAO;
import com.epam.ryabtsev.DAO.storage.Storage;
import com.epam.ryabtsev.model.Event;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EventDAOImpl implements EventDAO {

    @Autowired
    private Storage storage;

    @Override
    public Event getEventById(long eventId) {
        Map<Long, Event> events = storage.getEvents();
        return events.get(eventId);
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        Map<Long, Event> events = storage.getEvents();
        List<Event> event = events.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .filter(p-> p.getTitle().equals(title))
                .collect(Collectors.toList());
        System.out.println(event.get(0));
        return event;
    }

    @Override
    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        Map<Long, Event> events = storage.getEvents();
        List<Event> event = events.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .filter(p-> p.getDate().equals(day))
                .collect(Collectors.toList());
        System.out.println(event.get(0));

        return event;
    }

    @Override
    public Event createEvent(Event event) {
        Map<Long, Event> events = storage.getEvents();
        long max = events.keySet().stream().max(Long::compareTo).orElse(0L);
        var key = max + 1;
        event.setId(key);
        storage.setEvents(key, event);
        return event;
    }

    @Override
    public Event updateEvent(Event event) {
        Map<Long, Event> events = storage.getEvents();
        long key = event.getId();
        events.put(key, event);
        return event;
    }

    @Override
    public boolean deleteEvent(long eventId) {
        Map<Long, Event> events = storage.getEvents();
        boolean deleteResult = false;
        events.remove(eventId);
        if (events.get(eventId) == null) {
            deleteResult = true;
        }

        return deleteResult;
    }

    @Autowired
    public Storage getStorage() {
        return storage;
    }

    @Autowired
    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
