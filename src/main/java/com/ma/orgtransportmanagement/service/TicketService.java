package com.ma.orgtransportmanagement.service;

import com.ma.orgtransportmanagement.entity.Vehicle;

import java.util.List;

public interface TicketService {
    public Integer getTicketPrice ();
    public List<Vehicle> getRequiredBuses ();
    //public Integer getNumberOfStudents();
}
