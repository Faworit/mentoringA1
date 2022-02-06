package com.epam.ryabtsev.serviceImpl;

import com.epam.ryabtsev.Event;
import com.epam.ryabtsev.EventService;
import com.epam.ryabtsev.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public void createEvent(Event event) {
        eventRepository.save(event);
    }

    @Override
    public void updateEvent(Event event) {
        eventRepository.save(event);
    }

    @Override
    public Event getEvent(long id) {
        return eventRepository.findById(id);
    }

    @Override
    public void deleteEvent(long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> getAllEventsByTitle(String title) {
        return eventRepository.findAllByTitle(title);
    }
}
