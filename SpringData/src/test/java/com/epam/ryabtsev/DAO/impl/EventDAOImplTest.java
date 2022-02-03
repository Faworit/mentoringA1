package com.epam.ryabtsev.DAO.impl;

import com.epam.ryabtsev.model.Event;
import com.epam.ryabtsev.model.impl.EventImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

class EventDAOImplTest {

    StorageMock mock = new StorageMock();

   /* @Test
    void getEventByIdTest() {
        //given
        mock.fillEventStorage(storage);
        Event event = new EventImpl(1, "test", new Date(), new BigDecimal(100.0));

        //when
        Event result = storage.getEvents().get(1L);

        //then
        Assertions.assertEquals(event.getTitle(), result.getTitle());
    }

    @Test
    void getEvetForDay() {
        //given
        EventDAOImpl eventDAO = new EventDAOImpl();
        mock.fillEventStorage(storage);
        eventDAO.setStorage(storage);
        Date day = new GregorianCalendar(2021, Calendar.FEBRUARY, 11).getTime();
        String title = "test4";
        long id = 4L;

        //when
        List<Event> list = eventDAO.getEventsForDay(day, 0, 0);

        //then

        Assertions.assertEquals(title, list.get(0).getTitle());
        Assertions.assertEquals(day, list.get(0).getDate());
    }*/

}