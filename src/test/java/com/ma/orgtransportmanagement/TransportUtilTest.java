package com.ma.orgtransportmanagement;

import com.ma.orgtransportmanagement.dto.PassengerDto;
import com.ma.orgtransportmanagement.dto.TripDto;
import com.ma.orgtransportmanagement.entity.Passenger;
import com.ma.orgtransportmanagement.entity.Trip;
import com.ma.orgtransportmanagement.util.TransportUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class TransportUtilTest {


    @Test
    public void convertTripEntityToDtoTest(){
        Trip trip = new Trip();
//        Trip trip = new Trip("Munnar Trip", "Karungal","Kanyakumari" );
        trip.setTripName("Munnar");
        trip.setFromPlace("Karungal");
        trip.setNumberOfKm(Double.valueOf(106));
        TransportUtil transportUtil = new TransportUtil();
        TripDto dtoResponse = transportUtil.convertEntityToDto(trip);
        log.info("This is output:{}",dtoResponse.getTripName());
        log.info("This is output:{}",dtoResponse.getFromPlace());
        log.info("This is output:{}",dtoResponse.getNumberOfKm());

    }

    @Test
    public void convertPassengerEntityToDtoTest(){
        Passenger passenger = new Passenger();
//        passenger.setPassengerId(1L);
        passenger.setPassengerId(Long.valueOf(1));
        passenger.setPassengerName("Sudher");
        TransportUtil transportUtil =new TransportUtil();
        PassengerDto dtoResponse = transportUtil.convertEntityToDto(passenger);
        log.info("This is output:{}",dtoResponse.getPassengerId());
        log.info("This is output:{}",dtoResponse.getPassengerName());

    }


}
