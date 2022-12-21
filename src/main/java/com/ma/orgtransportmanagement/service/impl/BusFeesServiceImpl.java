package com.ma.orgtransportmanagement.service.impl;

import com.ma.orgtransportmanagement.dto.BusFeesDto;
import com.ma.orgtransportmanagement.dto.PassengerDto;
import com.ma.orgtransportmanagement.dto.TripPriceDto;
import com.ma.orgtransportmanagement.dto.response.MessageLevel;
import com.ma.orgtransportmanagement.dto.response.MetaDataDto;
import com.ma.orgtransportmanagement.dto.response.BusFeesResponseWrapperDto;
import com.ma.orgtransportmanagement.dto.response.PassengerResponseWrapperDto;
import com.ma.orgtransportmanagement.entity.BusFees;
import com.ma.orgtransportmanagement.entity.Passenger;
import com.ma.orgtransportmanagement.repository.BusFeesRepository;
import com.ma.orgtransportmanagement.service.BusFeesService;
import com.ma.orgtransportmanagement.service.PassengerService;
import com.ma.orgtransportmanagement.service.TripPriceService;
import com.ma.orgtransportmanagement.util.TransportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
    public BusFeesResponseWrapperDto saveTotalAmount(BusFeesDto busFeesDto) {
        BusFeesResponseWrapperDto busFeesResponseWrapperDto = new BusFeesResponseWrapperDto();
        MetaDataDto metaDataDto = new MetaDataDto();
        Long passengerId = busFeesDto.getPassengerId();
        PassengerResponseWrapperDto wrapperDto = passengerService.getPassenger(passengerId);
        PassengerDto passengerDto = wrapperDto.getPassengerDto();

        if (passengerDto == null){
            metaDataDto.setMessage("Invalid passengerId :" + passengerId);
            metaDataDto.setMessageLevel(MessageLevel.ERROR.toString());
            busFeesResponseWrapperDto.setMetaDataDto(metaDataDto);
        }else {

            String passengerType = passengerDto.getPassengerType();
            Long tripId = passengerDto.getTripId();

            TripPriceDto tripPriceDto = tripPriceService.getTripPrice(passengerType, tripId);
            Double totalAmount = tripPriceDto.getTotalAmount();
            Double paidAmount = busFeesDto.getPaidAmount();
            //BusFees get
            //busfeesid velila eadukanum
            //add paid amount
            //save the due amount
            //set in dto
            //convert entity
            //call update method


            busFeesDto.setPassengerId(passengerId);
            busFeesDto.setTotalAmount(totalAmount);
            Date todaysDate = new Date();
            busFeesDto.setPaidDate(todaysDate);
            double dueAmount = 0;
            BusFees busFeesReference = busFeesRepository.getBusFeesByPassengerId(passengerId);
            if(busFeesReference != null){
                //update- value irunthu ina execute aagum
                Long busFeesId = busFeesReference.getBusFeesId();
                BusFeesDto busFeesDtoValue = getBusFees(busFeesId);

                Double alreadyPaidAmount = busFeesDtoValue.getPaidAmount();
                Double totalPaidAmount = alreadyPaidAmount + paidAmount;
                busFeesDto.setPaidAmount(totalPaidAmount);
                busFeesDto.setBusFeesId(busFeesId);

                dueAmount = totalAmount - totalPaidAmount; //5000 - (2000 + 500)
                busFeesDto.setDueAmount(dueAmount);


            }else {
                //save
                busFeesDto.setPaidAmount(paidAmount);
                dueAmount = totalAmount - paidAmount; //5000 - 500
                busFeesDto.setDueAmount(dueAmount);
            }


            if (dueAmount == 0) {
                metaDataDto.setMessage("There is no dues for this passenger Id : " + busFeesDto.getPassengerId());
                metaDataDto.setMessageLevel(MessageLevel.INFO.toString());
            } else if (dueAmount > 0) {
                metaDataDto.setMessage("Now the pending balance is " + dueAmount);
                metaDataDto.setMessageLevel(MessageLevel.INFO.toString());
            } else if (dueAmount < 0) {
                metaDataDto.setMessage("You dont have any balance");
                metaDataDto.setMessageLevel(MessageLevel.INFO.toString());
            }


            TransportUtil transportUtil = new TransportUtil();
            BusFees busFees = transportUtil.convertDtoToEntity(busFeesDto);
            BusFees saveTotalAmount = busFeesRepository.save(busFees);

//        TransportUtil transportUtilReference = new TransportUtil();
            BusFeesDto busFeesDtoReference = transportUtil.convertEntityToDto(saveTotalAmount);



            busFeesResponseWrapperDto.setMetaDataDto(metaDataDto);
            busFeesResponseWrapperDto.setBusFeesDto(busFeesDtoReference);

        }
        return busFeesResponseWrapperDto;
    }
}
