package com.spangles.orgtransportmanagement;

import com.spangles.orgtransportmanagement.dto.response.StaffCollectionDto;
import com.spangles.orgtransportmanagement.dto.response.StudentCollectionDto;
import com.spangles.orgtransportmanagement.dto.response.SummaryDto;
import com.spangles.orgtransportmanagement.dto.response.TotalCollectionWrapperDto;
import com.spangles.orgtransportmanagement.service.PassengerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j

public class PassengerServiceImplTest {
    @Autowired
    PassengerService passengerService;

   // @Test
    public void getStudentNameTest(){
        Long passengerId = 1L;
//        when(passengerService.getStudentName(any())).thenReturn("Jebin");
        String name = passengerService.getStudentName(passengerId);
        log.info("name :{}",name);
    }
   // @Test
    public void getStaffNameTest(){
        Long passengerId = 1L;
        String url = passengerService.getStaffName(passengerId);
        log.info("OutPut url is: {}",url);
    }
   // @Test
    public void getTotalCollection(){
        String passengerType = "staff";
        TotalCollectionWrapperDto totalCollectionWrapperDto = passengerService.getTotalCollection(passengerType);
        List<StudentCollectionDto> studentCollectionDto = totalCollectionWrapperDto.getStudentCollectionDtos();
        List<StaffCollectionDto> staffCollectionDto = totalCollectionWrapperDto.getStaffCollectionDtos();
        for (int i=0;i<staffCollectionDto.size();i++) {
            StaffCollectionDto staffCollectionDtos = staffCollectionDto.get(i);
            String staffName = staffCollectionDtos.getStaffName();
            Double paidAmount = staffCollectionDtos.getPaidAmount();
            Double totalAmount = staffCollectionDtos.getTotalAmount();
            Long sNo = staffCollectionDtos.getsNo();

            log.info("The Serial Number : {}",sNo);
            log.info("The Name of the Student is : {}", staffName);
            log.info("The Total Amount : {}",totalAmount);
            log.info("The Paid Amount : {}",paidAmount);

        }
        SummaryDto summaryDto = totalCollectionWrapperDto.getSummaryDto();
        Double totalCollectionAmount = summaryDto.getTotalAmountCollected();
        Double totalBalanceAmount = summaryDto.getTotalBalanceAmount();
        Long totalPersonPaid = summaryDto.getTotalPersonsPaid();

        log.info("The Total Amount Collected : {}",totalCollectionAmount);
        log.info("The Balance Amount : {}",totalBalanceAmount);
        log.info("The Total Person Paid : {}",totalPersonPaid);
    }
    //@Test
    /*public void getTotalCollectionByTripId(){
        Long tripId = 1L;
        SummaryDto summaryDto = passengerService.getTotalCollectionByTripId(tripId);
        Double totalAmountCollected = summaryDto.getTotalAmountCollected();
        Double totalBalanceAmount = summaryDto.getTotalBalanceAmount();
        Long totalPersonPaid = summaryDto.getTotalPersonsPaid();

        log.info("Total Amount Collected : {}",totalAmountCollected);
        log.info("Total Due Amount : {}",totalBalanceAmount);
        log.info("Total Person Paid : {}",totalPersonPaid);
    }*/

}
