package com.epam.ryabtsev.service;

import com.epam.ryabtsev.model.Event;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface EventService {
    Event getEventById(long eventId);
    List<Event> getEventsByTitle(String title, int pageSize, int pageNum);
    List<Event> getEventsForDay(LocalDate day, int pageSize, int pageNum);
    Event createEvent(Event event);
    Event updateEvent(Event event);
    boolean deleteEvent(long eventId);
}
