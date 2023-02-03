package com.spangles.orgtransportmanagement;

import com.spangles.orgtransportmanagement.dto.PassengerDto;
import com.spangles.orgtransportmanagement.service.impl.PassengerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@Slf4j
//@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PassengerControllerTest {


    @InjectMocks
    PassengerServiceImpl passengerService;




//    @Test
    public void savePassengerTest(){


        Mockito.when(passengerService.getStudentName(Mockito.any())).thenReturn("Ajin");

        PassengerDto passengerDto = new PassengerDto();
        passengerDto.setPassengerId(Long.valueOf(3));
        passengerDto.setPassengerType("student");
        passengerDto.setIdNumber(Long.valueOf(3));
//        passengerDto.setPassengerName("Sudher");
        PassengerDto savePassenger = passengerService.savePassenger(passengerDto);

        log.info("The PassengerId :{}",savePassenger.getPassengerId());
        log.info("The Passenger Type: {}",savePassenger.getPassengerType());
        String response = savePassenger.getPassengerName()+" , "+savePassenger.getIdNumber();
        log.info("The Value are : {}",response);
    }
}
