package com.epam.ryabtsev.controller;

import com.epam.ryabtsev.facade.BookingFacade;
import com.epam.ryabtsev.model.Event;
import com.epam.ryabtsev.model.Ticket;
import com.epam.ryabtsev.model.impl.EventImpl;
import com.epam.ryabtsev.model.impl.TicketImpl;
import com.epam.ryabtsev.model.impl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/event")
public class EventController {

    @Autowired
    BookingFacade bookingFacade;

    @GetMapping("/id/{eventId}")
    public String getById(@PathVariable long eventId, Model model) {
        Event event = bookingFacade.getEventById(eventId);
        List<Event> events = new ArrayList<>();
        events.add(event);
        model.addAttribute("events", events);

        return "event";
    }

    @GetMapping("/eventData/{eventDate}")
    public String getEventByDate(@PathVariable LocalDate eventDate, Model model) {
        List<Event> events = bookingFacade.getEventsForDay(eventDate, 1, 1);
        model.addAttribute("events", events);

        return "event";
    }

    @GetMapping("/title/{title}")
    public String getEventByTitle(@PathVariable String title, Model model) {
        List<Event> events = bookingFacade.getEventsByTitle(title, 1, 1);
        model.addAttribute("events", events);

        return "event";
    }

    @PostMapping("/create")
    public String createEvent(@RequestParam String title,
                              @RequestParam String date,
                              @RequestParam Integer ticketPrice,
                              @RequestParam Long userId,
                              @RequestParam int place,
                              Model model) {
        List<TicketImpl> tickets = new ArrayList<>();
        UserImpl user = (UserImpl) bookingFacade.getUserById(userId);
        Ticket ticket = new TicketImpl();
        ticket.setPlace(place);
        ticket.setUser(user);
        tickets.add((TicketImpl) ticket);
        Event event = new EventImpl();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);
        event.setDate(localDate);
        event.setTicketPrice(ticketPrice);
        event.setTitle(title);
        event.setUser(user);
        Event createdEvent = bookingFacade.createEvent(event);
        List<Event> events = new ArrayList<>();
        events.add(createdEvent);
        model.addAttribute("events", events);

        return "event";
    }

    @PostMapping("/update")
    public String updateEvent(Event event, Model model) {
        Event updatedEvent = bookingFacade.updateEvent(event);
        List<Event> events = new ArrayList<>();
        events.add(updatedEvent);
        model.addAttribute("events", events);

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
