package com.epam.ryabtsev.service.impl;

import com.epam.ryabtsev.DAO.EventDAO;
import com.epam.ryabtsev.model.Event;
import com.epam.ryabtsev.model.impl.EventImpl;
import com.epam.ryabtsev.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    EventDAO eventDAO;

    @Override
    public Event getEventById(long eventId) {
        return eventDAO.getEventById(eventId);
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return eventDAO.getEventsByTitle(title);
    }

    @Override
    public List<Event> getEventsForDay(LocalDate day, int pageSize, int pageNum) {
        return eventDAO.getEventImplByDate(day);
    }

    @Override
    public Event createEvent(Event event) {
        return eventDAO.save((EventImpl) event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventDAO.save((EventImpl) event);
    }

    @Override
    public boolean deleteEvent(long eventId) {
        return eventDAO.deleteById(eventId);
    }
}
