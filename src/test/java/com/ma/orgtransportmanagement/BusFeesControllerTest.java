package com.ma.orgtransportmanagement;

import com.ma.orgtransportmanagement.controller.BusFeesController;
import com.ma.orgtransportmanagement.dto.BusFeesDto;
import com.ma.orgtransportmanagement.dto.response.ResponseWrapperDto;
import com.ma.orgtransportmanagement.service.BusFeesService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BusFeesControllerTest {

    @Autowired
    BusFeesController busFeesController;

   // @Test
    public void saveTotalAmount(){
        BusFeesDto busFeesDto = new BusFeesDto();
        busFeesDto.setPassengerId(Long.valueOf(1));
        busFeesDto.setPaidAmount(Double.valueOf(2000));
        busFeesDto.setTotalAmount(Double.valueOf(5000));
        busFeesDto.setDueAmount(Double.valueOf(3000));

        ResponseWrapperDto saveTotalAmount = busFeesController.saveTotalAmount(busFeesDto);

        BusFeesDto busFees = saveTotalAmount.getBusFeesDto();

        log.info("PassengerId: {}",busFees.getPassengerId());

    }
}
