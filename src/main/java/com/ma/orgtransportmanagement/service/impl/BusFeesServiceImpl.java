package com.ma.orgtransportmanagement.service.impl;

import com.ma.orgtransportmanagement.dto.BusFeesDto;
import com.ma.orgtransportmanagement.dto.PassengerDto;
import com.ma.orgtransportmanagement.dto.TripPriceDto;
import com.ma.orgtransportmanagement.dto.response.MetaDataDto;
import com.ma.orgtransportmanagement.dto.response.ResponseWrapperDto;
import com.ma.orgtransportmanagement.entity.BusFees;
import com.ma.orgtransportmanagement.entity.Passenger;
import com.ma.orgtransportmanagement.repository.BusFeesRepository;
import com.ma.orgtransportmanagement.service.BusFeesService;
import com.ma.orgtransportmanagement.service.PassengerService;
import com.ma.orgtransportmanagement.service.TripPriceService;
import com.ma.orgtransportmanagement.util.TransportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusFeesServiceImpl implements BusFeesService {

    @Autowired
    BusFeesRepository busFeesRepository;
    @Autowired
    PassengerService passengerService;

    @Autowired
    TripPriceService tripPriceService;

    @Override
    public BusFeesDto getBusFees(Long busFeesId) {
        BusFees busFeesEntity = busFeesRepository.getBusFees(busFeesId);
        TransportUtil transportUtil = new TransportUtil();
        BusFeesDto busFeesDto =transportUtil.convertEntityToDto(busFeesEntity);
        return busFeesDto;
    }

    @Override
    public BusFeesDto saveBusFees(BusFeesDto busFeesDto) {
        TransportUtil transportUtilReference = new TransportUtil();
        BusFees busFees = transportUtilReference.convertDtoToEntity(busFeesDto);
        BusFees busFeesEntity = busFeesRepository.save(busFees);
        TransportUtil transportUtil = new TransportUtil();
        BusFeesDto busFeesDtoResponse = transportUtil.convertEntityToDto(busFeesEntity);
        return busFeesDtoResponse;
    }

    @Override
    public BusFeesDto updateBusFees(BusFeesDto busFeesDto) {
        TransportUtil transportUtilReference = new TransportUtil();
        BusFees busFees = transportUtilReference.convertDtoToEntity(busFeesDto);
        BusFees busFeesEntity = busFeesRepository.save(busFees);
        TransportUtil transportUtil = new TransportUtil();
        BusFeesDto busFeesDtoResponse = transportUtil.convertEntityToDto(busFeesEntity);
        return busFeesDtoResponse;
    }

    @Override
    public void deleteBusFees(BusFeesDto busFeesDto) {
        TransportUtil transportUtilReference = new TransportUtil();
        BusFees busFees = transportUtilReference.convertDtoToEntity(busFeesDto);
        busFeesRepository.delete(busFees);

    }

    @Override
    public ResponseWrapperDto saveTotalAmount(BusFeesDto busFeesDto) {
        Long passengerId = busFeesDto.getPassengerId();
        Long busTypeId = busFeesDto.getBusFeesId();
        PassengerDto passenger = passengerService.getPassenger(passengerId);
        String passengerType = passenger.getPassengerType();
        Long tripId = passenger.getTripId();

        TripPriceDto tripPriceDto = tripPriceService.getAmount(passengerType,tripId);
        Double totalAmount = tripPriceDto.getTotalAmount();
        Double paidAmount = busFeesDto.getPaidAmount();
        //BusFees get
        //busfeesid velila eadukanum
        //add paid amount
        //save the due amount
        //set in dto
        //convert entity
        //call update method

        double dueAmount = 0;

        dueAmount = totalAmount-paidAmount;

        busFeesDto.setPassengerId(passengerId);
        busFeesDto.setTotalAmount(totalAmount);
        busFeesDto.setDueAmount(dueAmount);

        BusFees busFeesReference = busFeesRepository.getBusFees(passengerId);
        Long busFeesId = busFeesReference.getBusFeesId();
        BusFeesDto busFeesDtoValue = getBusFees(busFeesId);
        Double alreadyPaidAmount = busFeesDtoValue.getPaidAmount();
        Double totalPaidAmount = alreadyPaidAmount+paidAmount;


        busFeesDto.setPaidAmount(totalPaidAmount);
        busFeesDto.setBusFeesId(busFeesId);


        TransportUtil transportUtil = new TransportUtil();
        BusFees busFees = transportUtil.convertDtoToEntity(busFeesDto);
        BusFees saveTotalAmount = busFeesRepository.save(busFees);

//        TransportUtil transportUtilReference = new TransportUtil();
        BusFeesDto busFeesDtoReference = transportUtil.convertEntityToDto(saveTotalAmount);

        ResponseWrapperDto responseWrapperDto = new ResponseWrapperDto();
        MetaDataDto metaDataDto = new MetaDataDto();
        if(dueAmount <= 0) {
            metaDataDto.setMessage("There is no dues for this passenger Id : " + busFees.getPassengerId());
        }
        else if(dueAmount > 0) {
            metaDataDto.setMessage("Now the pending balance is " + dueAmount);
        }

        responseWrapperDto.setMetaDataDto(metaDataDto);
        responseWrapperDto.setBusFeesDto(busFeesDtoReference);
        return responseWrapperDto;
    }
}
