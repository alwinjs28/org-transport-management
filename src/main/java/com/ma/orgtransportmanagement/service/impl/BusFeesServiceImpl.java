package com.ma.orgtransportmanagement.service.impl;

import com.ma.orgtransportmanagement.dto.BusFeesDto;
import com.ma.orgtransportmanagement.entity.BusFees;
import com.ma.orgtransportmanagement.repository.BusFeesRepository;
import com.ma.orgtransportmanagement.service.BusFeesService;
import com.ma.orgtransportmanagement.util.TransportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusFeesServiceImpl implements BusFeesService {

    @Autowired
    BusFeesRepository busFeesRepository;

    @Override
    public BusFeesDto getBusFees(Long busTypeId) {
        BusFees busFeesEntity = busFeesRepository.getBusFees(busTypeId);
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
}
