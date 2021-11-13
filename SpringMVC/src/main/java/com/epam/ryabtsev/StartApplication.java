package com.epam.ryabtsev;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class StartApplication {

    public static void main(String[] args) throws ParseException {

        Date date = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
        System.out.println(date);
    }
}
