package com.epam.ryabtsev.controller;

import com.epam.ryabtsev.Event;
import com.epam.ryabtsev.EventService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("Description API of Event Controller")
@RestController
@RequestMapping("events")
public class EventServiceController {
    private final EventService eventService;

    public EventServiceController(EventService eventService) {
        this.eventService = eventService;
    }

    @ApiOperation(value = "Creation new event")
    @PostMapping
    public void saveEvent(@RequestBody Event event) {
        eventService.createEvent(event);
    }

    @ApiOperation(value = "Find Event by Id, return only one Event", tags = {"event by id"})
    @GetMapping("/{id}")
    public Event getEventById(@PathVariable long id) {
        return eventService.getEvent(id);
    }

    @ApiOperation(value = "Update event, that was save before")
    @PutMapping
    public void updateEvent(@RequestBody Event event) {
        eventService.updateEvent(event);
    }

    @ApiOperation(value = "This operation for delete existing Event by id", tags = {"delete by id"})
    @DeleteMapping("/id")
    public void deleteEvent(@PathVariable long id) {
        eventService.deleteEvent(id);
    }

    @ApiOperation(value = "This operation return all event, that was saved")
    @GetMapping("/event")
    public List<Event> getAllEvent() {
        return eventService.getAllEvents();
    }

    @ApiOperation(value = "This operation return all event that have same title" )
    @GetMapping("/event/{title}")
    public List<Event> getAllEventByTitle(@PathVariable String title) {
        return eventService.getAllEventsByTitle(title);
    }
}
