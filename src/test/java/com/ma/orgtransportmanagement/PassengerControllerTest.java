package com.ma.orgtransportmanagement;

import com.ma.orgtransportmanagement.controller.PassengerController;
import com.ma.orgtransportmanagement.dto.PassengerDto;
import com.ma.orgtransportmanagement.service.PassengerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@Slf4j
@SpringBootTest
public class PassengerControllerTest {

    @Autowired
    PassengerController passengerController;


    @Test
    public void savePassengerTest(){

//        when(passengerService.getStudentName(any())).thenReturn("Jebin");

        PassengerDto passengerDto = new PassengerDto();
        passengerDto.setPassengerId(Long.valueOf(1));
        passengerDto.setPassengerType("Student");
        passengerDto.setIdNumber(Long.valueOf(1));
        passengerDto.setPassengerName("Sudher");
        PassengerDto savePassenger = passengerController.savePassenger(passengerDto);

        log.info("The PassengerId :{}",savePassenger.getPassengerId());
        log.info("The Passenger Type: {}",savePassenger.getPassengerType());
        String response = savePassenger.getPassengerName()+" , "+savePassenger.getIdNumber();
        log.info("The Value are : {}",response);
    }
}
