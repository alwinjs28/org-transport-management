package com.ma.orgtransportmanagement.service.impl;

import com.ma.orgtransportmanagement.dto.PassengerDto;
import com.ma.orgtransportmanagement.dto.TripPriceDto;
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
import java.util.HashMap;
import java.util.Map;

@Slf4j

@Service
public class PassengerServiceImpl implements PassengerService {
    @Autowired
    RestTemplate restTemplate;
    @Value("${org.student.service.address}")
    private String studentServiceAddress;
    @Autowired
    PassengerRepository passengerRepository;

    public PassengerDto getPassenger(Long passengerId) {
        Passenger getPassenger = passengerRepository.getPassenger(passengerId);
        TransportUtil transportUtil = new TransportUtil();
        PassengerDto dtoGetResponse = transportUtil.convertPassengerEntityToDto(getPassenger);

        return dtoGetResponse;
    }

    public PassengerDto savePassenger(Passenger passenger) {
        Long passengerId = passenger.getIdNumber();
        String studentName = null;
        String type = passenger.getPassengerType();
        if (type.equals(Constants.PASSENGER_TYPE_STUDENT)) {
            studentName = getStudentName();
        }

        passenger.setPassengerType(studentName);
        Passenger savePassenger = passengerRepository.save(passenger);
        TransportUtil transportUtil = new TransportUtil();
        PassengerDto dtoSaveResponse = transportUtil.convertPassengerEntityToDto(savePassenger);

        return dtoSaveResponse;
    }

    public PassengerDto updatePassenger(Passenger passenger) {
        Passenger updatePassenger = passengerRepository.save(passenger);
        TransportUtil transportUtil = new TransportUtil();
        PassengerDto dtoUpdateResponse = transportUtil.convertPassengerEntityToDto(updatePassenger);

        return dtoUpdateResponse;
    }

    public void delete(Passenger passenger) {
        passengerRepository.delete(passenger);
    }

    public String getStudentName() {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);


        Integer studentId = 0;

        // http://localhost:8087/student/g_student

        String url = studentServiceAddress.concat(Constants.GET_STUDENT_BY_ID_URL);

        // url ? id = 1

        String urlWithQueryParam = url.concat(Constants.STUDENT_QUERY).concat(String.valueOf(studentId));


        log.info("url {}", urlWithQueryParam);

        ResponseEntity<String> studentResponseEntity = restTemplate.exchange(urlWithQueryParam, HttpMethod.GET, httpEntity, String.class);
        if (studentResponseEntity != null && studentResponseEntity.getStatusCodeValue() == 200) {
            String stringifyJSON = studentResponseEntity.getBody();
            log.info("student response:{}", stringifyJSON);
            String jsonResponse[] = stringifyJSON.split("},");
      
    }
}
