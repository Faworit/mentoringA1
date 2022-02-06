package com.epam.ryabtsev.controller;

import com.epam.ryabtsev.facade.BookingFacade;
import com.epam.ryabtsev.model.Ticket;
import com.epam.ryabtsev.model.User;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

@Controller
public class PDFController {

    @Autowired
    BookingFacade bookingFacade;

    @GetMapping("/get/pdf")
    public void getTicketPdf(HttpServletRequest request,
                             HttpServletResponse response,
                             User user) throws FileNotFoundException, DocumentException {

        Document doc = new Document();
        PdfWriter.getInstance(doc,new FileOutputStream("listDemo.pdf"));
        doc.open();
        ArrayList<Ticket> tickets = (ArrayList<Ticket>) bookingFacade.getBookedTickets(user, 0, 0);
        List list = new List(true, 30);
        for (int i = 0; i < tickets.size(); i++) {
            list.add(new ListItem(tickets.get(i).getUser().getId()));
            list.add(new ListItem(tickets.get(i).getEvent().getId()));
            list.add(new ListItem(tickets.get(i).getPlace()));
            list.add(new ListItem(tickets.get(i).getCategory().toString()));
        }

        doc.add(list);

        String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/downloads/pdf/");
        Path file = Paths.get(dataDirectory, "listDemo.pdf");
        if (Files.exists(file))
        {
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition", "attachment; filename=listDemo.pdf");
            try
            {
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}