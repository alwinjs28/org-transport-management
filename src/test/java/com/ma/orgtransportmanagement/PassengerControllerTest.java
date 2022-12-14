package com.ma.orgtransportmanagement;

import com.ma.orgtransportmanagement.dto.PassengerDto;
import com.ma.orgtransportmanagement.entity.Passenger;
import com.ma.orgtransportmanagement.util.TransportUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class PassengerControllerTest {
    @Test
    public void savePassengerTest(){
        PassengerDto passengerDto = new PassengerDto();
        passengerDto.setPassengerId(Long.valueOf(1));
        passengerDto.setPassengerType("Student");
        passengerDto.setIdNumber(Long.valueOf(1));
        passengerDto.setPassengerName("Sudher");
        TransportUtil transportUtil = new TransportUtil();
        Passenger passenger = transportUtil.convertPassengerDtoToEntity(passengerDto);

        log.info("The PassengerId :{}",passenger.getPassengerId());
        log.info("The Passenger Type: {}",passenger.getPassengerType());
        String response = passenger.getPassengerName()+" , "+passenger.getIdNumber();
        log.info("The Value are : {}",response);
    }
}
