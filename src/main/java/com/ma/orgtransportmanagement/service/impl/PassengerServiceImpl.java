package com.ma.orgtransportmanagement.service.impl;

import com.ma.orgtransportmanagement.dto.PassengerDto;
import com.ma.orgtransportmanagement.entity.Passenger;
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

import java.util.Arrays;

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

    public PassengerDto getPassenger(Long passengerId) {
        Passenger getPassenger = passengerRepository.getPassenger(passengerId);
        TransportUtil transportUtil = new TransportUtil();
        PassengerDto dtoGetResponse = transportUtil.convertEntityToDto(getPassenger);

        return dtoGetResponse;
    }

    public PassengerDto savePassenger(PassengerDto passengerDto) {

        Long passengerId = passengerDto.getIdNumber();
        String passengerName = null;
        String type = passengerDto.getPassengerType();
        if (type.equalsIgnoreCase(Constants.PASSENGER_TYPE_STUDENT)) {
            passengerName = getStudentName(passengerId);
        }
        else if(type.equalsIgnoreCase(Constants.PASSENGER_TYPE_STAFF)){
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
}
