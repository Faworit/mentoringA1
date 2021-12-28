package com.epam.ryabtsev.DAO;

import com.epam.ryabtsev.model.Event;
import com.epam.ryabtsev.model.impl.EventImpl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface EventDAO extends JpaRepository<EventImpl, Long> {
    Event getEventById(long eventId);
    List<Event> getEventsByTitle(String title, int pageSize, int pageNum);
    List<Event> getEventsForDay(Date day, int pageSize, int pageNum);
    Event createEvent(Event event);
    Event updateEvent(Event event);
    boolean deleteEvent(long eventId);
}
