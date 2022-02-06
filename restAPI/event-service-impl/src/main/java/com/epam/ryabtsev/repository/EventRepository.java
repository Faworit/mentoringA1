package com.epam.ryabtsev.repository;

import com.epam.ryabtsev.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Event findById(long id);
    List<Event> findAllByTitle(String title);

}
