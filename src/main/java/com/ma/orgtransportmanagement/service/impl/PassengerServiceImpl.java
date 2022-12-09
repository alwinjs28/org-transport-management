package com.ma.orgtransportmanagement.service.impl;

import com.ma.orgtransportmanagement.dto.PassengerDto;
import com.ma.orgtransportmanagement.entity.Passenger;
import com.ma.orgtransportmanagement.repository.PassengerRepository;
import com.ma.orgtransportmanagement.service.PassengerService;
import com.ma.orgtransportmanagement.util.TransportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerServiceImpl implements PassengerService {
    @Autowired
    PassengerRepository passengerRepository;
    public PassengerDto getPassenger(Long passengerId){
        Passenger getPassenger = passengerRepository.getPassenger(passengerId);
        TransportUtil transportUtil = new TransportUtil();
        PassengerDto dtoGetResponse = transportUtil.convertPassengerEntityToDto(getPassenger);

        return dtoGetResponse;
    }
    public PassengerDto savePassenger(Passenger passenger){
        Passenger savePassenger = passengerRepository.save(passenger);
        TransportUtil transportUtil = new TransportUtil();
        PassengerDto dtoSaveResponse = transportUtil.convertPassengerEntityToDto(savePassenger);

        return dtoSaveResponse;
    }
    public PassengerDto updatePassenger(Passenger passenger){
        Passenger updatePassenger = passengerRepository.save(passenger);
        TransportUtil transportUtil = new TransportUtil();
        PassengerDto dtoUpdateResponse = transportUtil.convertPassengerEntityToDto(updatePassenger);

        return dtoUpdateResponse;
    }
    public void delete(Passenger passenger){
        passengerRepository.delete(passenger);
    }
}
