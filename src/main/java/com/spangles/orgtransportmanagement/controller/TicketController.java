package com.spangles.orgtransportmanagement.controller;

import com.spangles.orgtransportmanagement.entity.Vehicle;
import com.spangles.orgtransportmanagement.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public List<Vehicle> getRequiredBuses(){
        return ticketService.getRequiredBuses();
    }
}
