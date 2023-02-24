package com.spangles.orgtransportmanagement;

import com.spangles.orgtransportmanagement.service.BusFeesService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j

public class BusFeesServiceImplTest {
    @Autowired
    BusFeesService busFeesService;

    @Test
    public void getAllBusFeesTest(){
        Double totalAmount = busFeesService.getAllBusFees();
        log.info("Total Amount : {}",totalAmount);
    }
}
