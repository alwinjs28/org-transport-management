package com.ma.orgtransportmanagement;

import com.ma.orgtransportmanagement.service.PassengerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j

public class PassengerServiceImplTest {
    @Autowired
    PassengerService passengerService;

    @Test
    public void getStudentNameTest(){
        Long passengerId = 1L;
//        when(passengerService.getStudentName(any())).thenReturn("Jebin");
        String name = passengerService.getStudentName(passengerId);
        log.info("name :{}",name);
    }
    @Test
    public void getStaffNameTest(){
        Long passengerId = 1L;
        String url = passengerService.getStaffName(passengerId);
        log.info("OutPut url is: {}",url);
    }

}
