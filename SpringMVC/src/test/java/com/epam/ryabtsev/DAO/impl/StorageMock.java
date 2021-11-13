package com.epam.ryabtsev.DAO.impl;

import com.epam.ryabtsev.DAO.storage.Storage;
import com.epam.ryabtsev.model.impl.EventImpl;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class StorageMock {

    public void fillEventStorage(Storage storage) {
        storage.setEvents(1L, new EventImpl(1, "test", new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime()));
        storage.setEvents(2L, new EventImpl(2, "test2", new GregorianCalendar(2015, Calendar.FEBRUARY, 11).getTime()));
        storage.setEvents(3L, new EventImpl(3, "test3", new GregorianCalendar(2016, Calendar.FEBRUARY, 11).getTime()));
        storage.setEvents(4L, new EventImpl(4, "test4", new GregorianCalendar(2021, Calendar.FEBRUARY, 11).getTime()));
    }
}
