package com.spangles.orgtransportmanagement.repository;

import com.spangles.orgtransportmanagement.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip,Long> {
    @Query(value = "SELECT t FROM Trip t WHERE t.tripId=?1")
    public Trip getTrip(Long tripId);
}
