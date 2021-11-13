package com.epam.ryabtsev.DAO;

import com.epam.ryabtsev.model.Event;

import java.util.Date;
import java.util.List;

public interface EventDAO {
    Event getEventById(long eventId);
    List<Event> getEventsByTitle(String title, int pageSize, int pageNum);
    List<Event> getEventsForDay(Date day, int pageSize, int pageNum);
    Event createEvent(Event event);
    Event updateEvent(Event event);
    boolean deleteEvent(long eventId);
}
