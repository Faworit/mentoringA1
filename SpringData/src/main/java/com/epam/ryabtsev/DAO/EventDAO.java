package com.epam.ryabtsev.DAO;

import com.epam.ryabtsev.model.Event;
import com.epam.ryabtsev.model.impl.EventImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface EventDAO extends JpaRepository<EventImpl, Long> {
    Event getEventById(long eventId);
    List<Event> getEventsByTitle(String title);
    List<Event> getEventImplByDate(LocalDate day);
    boolean deleteById(long eventId);
}