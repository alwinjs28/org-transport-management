package com.ma.orgtransportmanagement.controller;

import com.ma.orgtransportmanagement.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "Ticket")
@RestController
public class TicketController {
    @Autowired
    TicketService ticketService;
    @RequestMapping(value = "/g_ticket_price",method = RequestMethod.GET)
    public Integer getTicketPrice(){
        return ticketService.getTicketPrice();
    }

    @RequestMapping(value = "/g_required_buses",method = RequestMethod.GET)
    public String getRequiredBuses(){
        return ticketService.getRequiredBuses();
    }
}
