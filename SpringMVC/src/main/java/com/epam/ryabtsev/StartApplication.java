package com.epam.ryabtsev;

import java.io.IOException;

public class StartApplication {


    public static void main(String[] args) throws IOException {
        Test test = new Test();
        test.testXML();
       /* Ticket ticket = new TicketImpl();
        ticket.setCategory(Ticket.Category.STANDARD);
*/
    }
}
