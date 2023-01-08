package com.ma.orgtransportmanagement.service.impl;

import com.ma.orgtransportmanagement.dto.PassengerDto;
import com.ma.orgtransportmanagement.dto.response.*;
import com.ma.orgtransportmanagement.entity.BusFees;
import com.ma.orgtransportmanagement.entity.Passenger;
import com.ma.orgtransportmanagement.repository.BusFeesRepository;
import com.ma.orgtransportmanagement.repository.PassengerRepository;
import com.ma.orgtransportmanagement.service.PassengerService;
import com.ma.orgtransportmanagement.util.Constants;
import com.ma.orgtransportmanagement.util.TransportUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j

@Service
public class PassengerServiceImpl implements PassengerService {
    @Autowired
    RestTemplate restTemplate;
    @Value("${org.student.service.address}")
    private String studentServiceAddress;
    @Value("${org.staff.service.address}")
    private String staffServiceAddress;
    @Autowired
    PassengerRepository passengerRepository;
    @Autowired
    BusFeesRepository busFeesRepository;

    public PassengerResponseWrapperDto getPassenger(Long passengerId) {
        Passenger passenger = passengerRepository.getPassenger(passengerId);
        PassengerResponseWrapperDto passengerResponseWrapperDto = new PassengerResponseWrapperDto();
        MetaDataDto metaDataDto = new MetaDataDto();
        if (passenger == null) {
            metaDataDto.setMessage("Invalid passengerId: " + passengerId);
            metaDataDto.setMessageLevel(MessageLevel.ERROR.toString());
        }else {
            TransportUtil transportUtil = new TransportUtil();
            PassengerDto dtoGetResponse = transportUtil.convertEntityToDto(passenger);
            metaDataDto.setMessage("The passenger Id:"+passenger.getPassengerId());
            metaDataDto.setMessageLevel(MessageLevel.INFO.toString());
            passengerResponseWrapperDto.setPassengerDto(dtoGetResponse);

        }
        passengerResponseWrapperDto.setMetaDataDto(metaDataDto);

        return passengerResponseWrapperDto;
    }

    public PassengerDto savePassenger(PassengerDto passengerDto) {

        Long passengerId = passengerDto.getIdNumber();
        String passengerName = null;
        String type = passengerDto.getPassengerType();
        if (type.equals(Constants.PASSENGER_TYPE_STUDENT)) {
            passengerName = getStudentName(passengerId);
        }
        else if(type.equals(Constants.PASSENGER_TYPE_STAFF)){
            passengerName = getStaffName(passengerId);
        }

      
        passengerDto.setPassengerName(passengerName);
        passengerDto.setPassengerId(passengerId);
        TransportUtil transportUtilReference = new TransportUtil();
        Passenger passenger = transportUtilReference.convertDtoToEntity(passengerDto);
        Passenger savePassenger = passengerRepository.save(passenger);
        TransportUtil transportUtil = new TransportUtil();
        PassengerDto dtoSaveResponse = transportUtil.convertEntityToDto(savePassenger);

        return dtoSaveResponse;
    }

    public PassengerDto updatePassenger(Passenger passenger) {
        Passenger updatePassenger = passengerRepository.save(passenger);
        TransportUtil transportUtil = new TransportUtil();
        PassengerDto dtoUpdateResponse = transportUtil.convertEntityToDto(updatePassenger);

        return dtoUpdateResponse;
    }

    public void delete(Passenger passenger) {
        passengerRepository.delete(passenger);
    }

    public String getStudentName(Long passengerId) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);


        // http://localhost:8087/student/g_student

        String url = studentServiceAddress.concat(Constants.GET_STUDENT_BY_ID_URL);

        // url ? id = 1

        String urlWithQueryParam = url.concat(Constants.STUDENT_QUERY).concat(String.valueOf(passengerId));


        log.info("url {}", urlWithQueryParam);
        String name = null;
        ResponseEntity<String> studentResponseEntity = restTemplate.exchange(urlWithQueryParam, HttpMethod.GET, httpEntity, String.class);
        if (studentResponseEntity != null && studentResponseEntity.getStatusCodeValue() == 200) {
            String stringifyJSON = studentResponseEntity.getBody();
            log.info("student response:{}", stringifyJSON);
            String jsonResponse[] = stringifyJSON.split("\"studentName\":\"")[1].split("\",\"");
            name = jsonResponse[0];
            log.info("name: {}",name);
        }
        return name;
    }
    public String getStaffName(Long passengerId){

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);

        String url = staffServiceAddress.concat(Constants.GET_STAFF_BY_ID_URL);
        log.info("OutPut is: {}",url);

        String urlWithQueryParam = url.concat(Constants.STAFF_QUERY).concat(String.valueOf(passengerId));
        log.info("OutPut with query is: {}",urlWithQueryParam);
        String name = null;
        ResponseEntity<String> staffResponseEntity = restTemplate.exchange(urlWithQueryParam,HttpMethod.GET,httpEntity,String.class);
        if (staffResponseEntity != null && staffResponseEntity.getStatusCodeValue() == 200){
            String stringifyJSON = staffResponseEntity.getBody();
            log.info("Staff Response: {}",stringifyJSON);

            String jsonResponse[] = stringifyJSON.split("\"staffName\":\"")[1].split("\",\"");
            name = jsonResponse[0];
        }

        return name;
    }
    public TotalCollectionWrapperDto getTotalCollection(String passengerType){
        TotalCollectionWrapperDto totalCollectionWrapperDto = new TotalCollectionWrapperDto();
        if(passengerType.equals("All")){
            totalCollectionWrapperDto = getTotalCollectionByPassengerType(Constants.PASSENGER_TYPE_STUDENT,totalCollectionWrapperDto);
            totalCollectionWrapperDto = getTotalCollectionByPassengerType(Constants.PASSENGER_TYPE_STAFF,totalCollectionWrapperDto);
        }else {
           totalCollectionWrapperDto = getTotalCollectionByPassengerType(passengerType,totalCollectionWrapperDto);
        }
        return totalCollectionWrapperDto;
    }
    public TotalCollectionWrapperDto getTotalCollectionByPassengerType(String passengerType,TotalCollectionWrapperDto totalCollectionWrapperDto){
        SummaryDto summaryDto = new SummaryDto();
        List<StudentCollectionDto> listOfStudentCollectionDto = new ArrayList<>();
        List<StaffCollectionDto> listOfStaffCollectionDto = new ArrayList<>();

        List<Passenger> passengers = passengerRepository.getTotalCollection(passengerType);

        Double totalCollectedAmount = 0.0;
        Double totalDueAmount = 0.0;
        for (int i=1;i<=passengers.size();i++) {
            Passenger passenger = passengers.get(i-1);
            StudentCollectionDto studentCollectionDto = new StudentCollectionDto();
            StaffCollectionDto staffCollectionDto = new StaffCollectionDto();
            Long passengerId = passenger.getPassengerId();
            String passengerName = passenger.getPassengerName();
            Long idNumber = passenger.getIdNumber();

            List<BusFees> busFees = busFeesRepository.getBusFeesPassengerId(passengerId);
            for (BusFees busFee : busFees) {
                Double totalAmount = busFee.getTotalAmount();
                Double paidAmount = busFee.getPaidAmount();
                Double dueAmount = busFee.getDueAmount();

                totalCollectedAmount = totalAmount+totalCollectedAmount;
                totalDueAmount = dueAmount+totalDueAmount;

                if (passengerType.equals(Constants.PASSENGER_TYPE_STUDENT)) {
                    studentCollectionDto.setsNo((long) i);
                    studentCollectionDto.setStudentId(idNumber);
                    studentCollectionDto.setStudentName(passengerName);
                    studentCollectionDto.setTotalAmount(totalAmount);
                    studentCollectionDto.setPaidAmount(paidAmount);
                }
                else  {
                    staffCollectionDto.setsNo((long) i);
                    staffCollectionDto.setStaffId(idNumber);
                    staffCollectionDto.setStaffName(passengerName);
                    staffCollectionDto.setTotalAmount(totalAmount);
                    staffCollectionDto.setPaidAmount(paidAmount);
                }
            }

            listOfStudentCollectionDto.add(studentCollectionDto);
            listOfStaffCollectionDto.add(staffCollectionDto);

        }
        summaryDto.setTotalAmountCollected(totalCollectedAmount);
        summaryDto.setTotalBalanceAmount(totalDueAmount);
        summaryDto.setTotalPersonsPaid((long)passengers.size());

        if(passengerType.equals(Constants.PASSENGER_TYPE_STUDENT)) {
            totalCollectionWrapperDto.setStudentCollectionDto(listOfStudentCollectionDto);
        }else {
            totalCollectionWrapperDto.setStaffCollectionDto(listOfStaffCollectionDto);
        }
        if(totalCollectionWrapperDto.getSummaryDto() != null) {
            SummaryDto previousSummaryDto = totalCollectionWrapperDto.getSummaryDto();

            Double newTotalAmountCollected = summaryDto.getTotalAmountCollected() + previousSummaryDto.getTotalAmountCollected();
            Double newTotalBalanceAmount = summaryDto.getTotalBalanceAmount() + previousSummaryDto.getTotalBalanceAmount();
            Long totalPersonsPaid = summaryDto.getTotalPersonsPaid() + previousSummaryDto.getTotalPersonsPaid();

            summaryDto.setTotalAmountCollected(newTotalAmountCollected);
            summaryDto.setTotalBalanceAmount(newTotalBalanceAmount);
            summaryDto.setTotalPersonsPaid(totalPersonsPaid);

            totalCollectionWrapperDto.setSummaryDto(summaryDto);
        } else {

            totalCollectionWrapperDto.setSummaryDto(summaryDto);
        }
        return totalCollectionWrapperDto;
    }
}
