package com.ma.orgtransportmanagement;

import com.ma.orgtransportmanagement.dto.TripDto;
import com.ma.orgtransportmanagement.entity.Trip;
import com.ma.orgtransportmanagement.util.TransportUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class TransportUtilTest {
    @Test
    public void convertEntityToDtoTest(){
        Trip trip = new Trip();
        trip.setTripName("Munnar");
        trip.setFromPlace("Karungal");
        TransportUtil transportUtil = new TransportUtil();
        TripDto dtoResponse = transportUtil.convertEntityToDto(trip);
        log.info("This is output:{}",dtoResponse.getTripName());

    }

}
