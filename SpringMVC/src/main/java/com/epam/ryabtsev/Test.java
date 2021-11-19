package com.epam.ryabtsev;

import com.epam.ryabtsev.config.Converter;
import com.epam.ryabtsev.config.MarshallerConfig;
import com.epam.ryabtsev.model.Ticket;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Test {

    public void testXML() throws IOException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(MarshallerConfig.class);
        ctx.refresh();
        Converter converter = ctx.getBean(Converter.class);
        com.epam.ryabtsev.model.impl.TicketImpl customer2 = (com.epam.ryabtsev.model.impl.TicketImpl) converter.convertFromXMLToObject("ticket.xml");
        System.out.println(customer2);
        System.out.println("Done");
        com.epam.ryabtsev.model.impl.TicketImpl ticket = new com.epam.ryabtsev.model.impl.TicketImpl();
        ticket.setCategory(Ticket.Category.STANDARD);
    }
}
