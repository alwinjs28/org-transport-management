package com.spangles.orgtransportmanagement.service.impl;

import com.spangles.orgtransportmanagement.dto.BusFeesDto;
import com.spangles.orgtransportmanagement.dto.PassengerDto;
import com.spangles.orgtransportmanagement.dto.TripPriceDto;
import com.spangles.orgtransportmanagement.util.MessageLevel;
import com.spangles.orgtransportmanagement.dto.response.AdditionalHeaderDto;
import com.spangles.orgtransportmanagement.dto.response.BusFeesResponseWrapperDto;
import com.spangles.orgtransportmanagement.dto.response.PassengerResponseWrapperDto;
import com.spangles.orgtransportmanagement.entity.BusFees;
import com.spangles.orgtransportmanagement.repository.BusFeesRepository;
import com.spangles.orgtransportmanagement.service.BusFeesService;
import com.spangles.orgtransportmanagement.service.PassengerService;
import com.spangles.orgtransportmanagement.service.TripPriceService;
import com.spangles.orgtransportmanagement.util.TransportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    public BusFeesResponseWrapperDto saveBusFees(BusFeesDto busFeesDto) {
        BusFeesResponseWrapperDto busFeesResponseWrapperDto = new BusFeesResponseWrapperDto();
        AdditionalHeaderDto additionalHeaderDto = new AdditionalHeaderDto();
        Long passengerId = busFeesDto.getPassengerId();
        PassengerResponseWrapperDto wrapperDto = passengerService.getPassenger(passengerId);
        PassengerDto passengerDto = wrapperDto.getPassengerDto();

        if (passengerDto == null){
            additionalHeaderDto.setMessage("Invalid passengerId :" + passengerId);
            additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
            busFeesResponseWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);
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
                additionalHeaderDto.setMessage("There is no dues for this passenger Id : " + busFeesDto.getPassengerId());
                additionalHeaderDto.setMessageLevel(MessageLevel.INFO.toString());
            } else if (dueAmount > 0) {
                additionalHeaderDto.setMessage("Now the pending balance is " + dueAmount);
                additionalHeaderDto.setMessageLevel(MessageLevel.INFO.toString());
            } else if (dueAmount < 0) {
                additionalHeaderDto.setMessage("You dont have any balance");
                additionalHeaderDto.setMessageLevel(MessageLevel.INFO.toString());
            }


            TransportUtil transportUtil = new TransportUtil();
            BusFees busFees = transportUtil.convertDtoToEntity(busFeesDto);
            BusFees saveTotalAmount = busFeesRepository.save(busFees);

//        TransportUtil transportUtilReference = new TransportUtil();
            BusFeesDto busFeesDtoReference = transportUtil.convertEntityToDto(saveTotalAmount);



            busFeesResponseWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);
            busFeesResponseWrapperDto.setBusFeesDto(busFeesDtoReference);

        }
        return busFeesResponseWrapperDto;
    }
    public Double getAllBusFees(){

        List<BusFees> busFees = busFeesRepository.getAllBusFees();
        busFees.stream().filter(e->e.getTotalAmount()>1000).forEachOrdered(e->System.out.println(e.getTotalAmount()));

        Double totalAmount = busFees.stream().mapToDouble(e->e.getTotalAmount()).sum();

        return totalAmount;
    }
}
