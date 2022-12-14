package com.ma.orgtransportmanagement.service.impl;

import com.ma.orgtransportmanagement.entity.Vehicle;
import com.ma.orgtransportmanagement.repository.VehicleRepository;
import com.ma.orgtransportmanagement.service.TicketService;
import com.ma.orgtransportmanagement.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@Slf4j
public class TicketServiceImpl implements TicketService {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    VehicleRepository vehicleRepository;

    @Value("${org.student.service.address}")
    private String studentServiceAddress;

    public Integer getTicketPrice() {
        //1
        //2
        //3
        synchronized (this) {
            //s//d//
            ///s//s
        }
        //....
        //...
        //1500
        int a = 450, b = 500, c = 550;
        return a + b + c;
    }

    @Override
    public List<Vehicle> getRequiredBuses() {


        String student = "Students";
        List<Vehicle> finalVehicleList = new ArrayList();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        /*
         List<MediaType> list = new ArrayList<>();
        list.add(MediaType.APPLICATION_JSON));
        httpHeaders.setAccept(list);
         */
        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
//
//        Map<String, String> params = new HashMap<>();
//        params.put("id", "1");


        String url = studentServiceAddress.concat(Constants.GET_ALL_STUDENTS_URL);
        // "http://localhost:8087/student/g_stu_all";

        log.info("URL {}", url);
        ResponseEntity<String> studentResponseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class/*, params*/);
        //String responseJson3 = "";
        if (studentResponseEntity != null && studentResponseEntity.getStatusCodeValue() == 200) {
            String stringifyJSON = studentResponseEntity.getBody();
            //log.info(responseJson);
            String responseJson[] = stringifyJSON.split("},");
            log.info("Length {}", responseJson.length);
            int numberOfStudents = responseJson.length;
            List<Vehicle> vehicles = vehicleRepository.getVehicleByVehicleType(student);
            int nearestNumber = 0;
            boolean firstTime = true;
            Vehicle finalVehicle = null;
            for (int i = 0; i < vehicles.size(); i++) {
                Vehicle vehicle = vehicles.get(i);
                Integer vehicleSeating = vehicle.getVehicleSeating();
                if (vehicleSeating > numberOfStudents) {
                    if (firstTime || nearestNumber > vehicleSeating) {
                        nearestNumber = vehicleSeating;
                        finalVehicle = vehicle;
                        firstTime = false;
                    }
                }
            }
            finalVehicleList.add(finalVehicle);

        }
        return finalVehicleList;
    }
}
