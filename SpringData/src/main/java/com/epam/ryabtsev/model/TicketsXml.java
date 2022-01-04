package com.epam.ryabtsev.model;

import java.util.List;

public class TicketsXml {
    private List<Ticket> tickets;

    public TicketsXml() {
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
