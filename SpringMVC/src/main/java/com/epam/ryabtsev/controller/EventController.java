package com.epam.ryabtsev.controller;

import com.epam.ryabtsev.facade.BookingFacade;
import com.epam.ryabtsev.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/event")
public class EventController {

    @Autowired
    BookingFacade bookingFacade;

    @GetMapping("/get/{eventId}")
    public String getById(@PathVariable long eventId, Model model) {
        Event event = bookingFacade.getEventById(eventId);
        model.addAttribute("event", event);

        return "event";
    }

    @GetMapping("/get/{eventDate}")
    public String getEventByDate(@PathVariable Date eventDate, Model model) {
        List<Event> events = bookingFacade.getEventsForDay(eventDate, 0, 0);
        model.addAttribute("events", events);

        return "event";
    }

    @GetMapping("/get/{title}")
    public String getEventByTitle(@PathVariable String title, Model model) {
        List<Event> events = bookingFacade.getEventsByTitle(title, 0, 0);
        model.addAttribute("events", events);

        return "event";
    }

    @PostMapping("/create")
    public String createEvent(Event event, Model model) {
        Event createdEvent = bookingFacade.createEvent(event);
        model.addAttribute("event", createdEvent);

        return "event";
    }

    @PostMapping("/update")
    public String updateEvent(Event event, Model model) {
        Event updatedEvent = bookingFacade.updateEvent(event);
        model.addAttribute("event", updatedEvent);

        return "event";
    }

    @PostMapping("/delete/{eventId}")
    public String deleteEvent(@PathVariable long eventId, Model model) {
        boolean result = bookingFacade.deleteEvent(eventId);
        if (result) {
            model.addAttribute("result", "user with id: " + eventId + " was successfully deleted");
        } else {
            model.addAttribute("result", "user with id: " + eventId + " was not deleted");
        }

        return "actionResult";
    }
}
