package com.spangles.orgtransportmanagement.repository;

import com.spangles.orgtransportmanagement.entity.TripPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripPriceRepository extends JpaRepository <TripPrice,Long>{
    @Query(value = "SELECT t FROM TripPrice t WHERE t.tripPriceId=?1")
    public TripPrice getTripPrice(Long tripPriceId);

    @Query(value = "SELECT t FROM TripPrice t WHERE t.passengerType=?1 AND t.tripId=?2")
    public TripPrice getTripPrice(String passengerType,Long tripId);
    @Query(value = "SELECT t FROM TripPrice t WHERE t.tripId=?1")
    public List<TripPrice> getTripPriceByTripId(Long tripId);

}
