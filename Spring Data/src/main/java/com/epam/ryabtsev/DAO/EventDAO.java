package com.epam.ryabtsev.DAO;

import com.epam.ryabtsev.model.Event;
import com.epam.ryabtsev.model.impl.EventImpl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface EventDAO extends JpaRepository<EventImpl, Long> {
    Event findById(long eventId);
    List<Event> findByTitle(String title, int pageSize, int pageNum);
    List<Event> findByDate(Date day, int pageSize, int pageNum);
    Event save(Event event);
    boolean delete(long eventId);
}
