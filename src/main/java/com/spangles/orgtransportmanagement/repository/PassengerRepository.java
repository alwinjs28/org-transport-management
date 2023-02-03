package com.spangles.orgtransportmanagement.repository;

import com.spangles.orgtransportmanagement.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Long> {
    @Query(value = "SELECT p FROM Passenger p WHERE p.passengerId=?1")
    public Passenger getPassenger(Long passengerId);

    @Query(value = "SELECT p FROM Passenger p WHERE p.passengerType=?1")
    public List<Passenger> getTotalCollection(String passengerType);

    @Query(value = "SELECT p FROM Passenger p WHERE p.tripId=?1")
    public List<Passenger>getTotalCollectionByTripId(Long tripId);
}
