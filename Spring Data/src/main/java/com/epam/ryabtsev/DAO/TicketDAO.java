package com.epam.ryabtsev.DAO;

import com.epam.ryabtsev.model.Event;
import com.epam.ryabtsev.model.Ticket;
import com.epam.ryabtsev.model.User;
import com.epam.ryabtsev.model.impl.TicketImpl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketDAO extends JpaRepository<TicketImpl, Long> {
    Ticket save(long userId, long eventId, int place, Ticket.Category category);
    List<Ticket> findByEvent(User user);
    List<Ticket> findByEvent(Event event);
    boolean deleteById(long ticketId);
}
