package com.epam.ryabtsev.DAO;

import com.epam.ryabtsev.model.Event;
import com.epam.ryabtsev.model.Ticket;
import com.epam.ryabtsev.model.User;
import com.epam.ryabtsev.model.impl.TicketImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketDAO extends JpaRepository<TicketImpl, Long> {
    List<Ticket> getTicketImplByUser(User user);
    List<Ticket> getTicketImplByEvent(Event event);
    boolean deleteById(long ticketId);
}
