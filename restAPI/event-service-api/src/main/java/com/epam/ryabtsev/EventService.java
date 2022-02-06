package com.epam.ryabtsev;

import java.util.List;

public interface EventService {
    void createEvent(Event event);
    void updateEvent(Event event);
    Event getEvent(long id);
    void deleteEvent(long id);
    List<Event> getAllEvents();
    List<Event> getAllEventsByTitle(String title);
}
