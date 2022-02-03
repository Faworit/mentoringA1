package com.epam.ryabtsev.service.impl;

import com.epam.ryabtsev.DAO.EventDAO;
import com.epam.ryabtsev.model.Event;
import com.epam.ryabtsev.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    EventDAO eventDAO;

    @Override
    public Event getEventById(long eventId) {
        return eventDAO.findById(eventId);
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return eventDAO.findByTitle(title, pageSize, pageNum);
    }

    @Override
    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return eventDAO.findByDate(day, pageSize, pageNum);
    }

    @Override
    public Event createEvent(Event event) {
        return eventDAO.save(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventDAO.save(event);
    }

    @Override
    public boolean deleteEvent(long eventId) {
        return eventDAO.delete(eventId);
    }
}
