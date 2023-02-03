package com.spangles.orgtransportmanagement.service;

import com.spangles.orgtransportmanagement.entity.Vehicle;

import java.util.List;

public interface TicketService {
    public Integer getTicketPrice ();
    public List<Vehicle> getRequiredBuses ();
    //public Integer getNumberOfStudents();
}
