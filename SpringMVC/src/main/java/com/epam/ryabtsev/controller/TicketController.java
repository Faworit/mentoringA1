package com.epam.ryabtsev.controller;

import com.epam.ryabtsev.facade.BookingFacade;
import com.epam.ryabtsev.model.Event;
import com.epam.ryabtsev.model.Ticket;
import com.epam.ryabtsev.model.User;
import com.epam.ryabtsev.model.impl.TicketImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    BookingFacade bookingFacade;

    @PostMapping("/bookTicket")
    public String bookTicket(TicketImpl ticket, Model model) {
        Ticket bookedTicket = bookingFacade.bookTicket(ticket.getUser().getId(),
                ticket.getEvent().getId(),
                ticket.getPlace(),
                ticket.getCategory());
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(bookedTicket);
        model.addAttribute("tickets", tickets);

        return "ticket";
    }

    @GetMapping("/getUserTickets")
    public String getBookedTickets(User user, Model model) {
        List<Ticket> tickets = bookingFacade.getBookedTickets(user, 0, 0);
        model.addAttribute("tickets", tickets);

        return "ticket";
    }

    @GetMapping("/getEventTickets")
    public String getBookedTickets(Event event, Model model) {
        List<Ticket> tickets = bookingFacade.getBookedTickets(event, 0, 0);
        model.addAttribute("tickets", tickets);

        return "ticket";
    }

    @PostMapping("/cancel/{ticketId}")
    public String cancelTicket(@PathVariable long ticketId, Model model) {
        boolean result = bookingFacade.cancelTicket(ticketId);
        if (result) {
            model.addAttribute("result", "user with id: " + ticketId + " was successfully deleted");
        } else {
            model.addAttribute("result", "user with id: " + ticketId + " was not deleted");
        }

        return "actionResult";
    }
}