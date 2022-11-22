package com.ma.orgtransportmanagement.service.impl;

import com.ma.orgtransportmanagement.service.TicketService;
import com.ma.orgtransportmanagement.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.*;

@Service
@Slf4j
public class TicketServiceImpl implements TicketService {
    @Autowired
    RestTemplate restTemplate;

    @Value("${org.student.service.address}")
    private String studentServiceAddress;
    public Integer getTicketPrice (){
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
        int a=450,b=500,c=550;
        return a+b+c;
    }

    @Override
    public String getRequiredBuses() {

        String name= "Alwin";

        List<String> list = new ArrayList<>();
        list.add(name);

        List<String> myList = Arrays.asList(name);



        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
//
//        Map<String, String> params = new HashMap<>();
//        params.put("id", "1");


        String url = studentServiceAddress.concat(Constants.GET_ALL_STUDENTS_URL);
        // "http://localhost:8087/student/g_stu_all";

        log.info("URL {}", url);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class/*, params*/);

        String responseJson = response.getBody();
        log.info(responseJson);

        return responseJson;
    }
}
