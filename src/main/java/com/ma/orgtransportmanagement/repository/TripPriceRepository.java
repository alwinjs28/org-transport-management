package com.ma.orgtransportmanagement.repository;

import com.ma.orgtransportmanagement.entity.TripPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TripPriceRepository extends JpaRepository <TripPrice,Long>{
    @Query(value = "SELECT t FROM TripPrice t WHERE t.tripPriceId=?1")
    public TripPrice getTripPrice(Long tripPriceId);

    @Query(value = "SELECT t FROM TripPrice t WHERE t.passengerType=?1 AND t.tripId=?2")
    public TripPrice getAmount(String passengerType,Long tripId);

}
