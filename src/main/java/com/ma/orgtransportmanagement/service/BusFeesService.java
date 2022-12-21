package com.ma.orgtransportmanagement.service;

import com.ma.orgtransportmanagement.dto.BusFeesDto;
import com.ma.orgtransportmanagement.dto.response.ResponseWrapperDto;

public interface BusFeesService {
    public BusFeesDto getBusFees(Long busTypeId);
    public BusFeesDto saveBusFees(BusFeesDto busFeesDto);
    public BusFeesDto updateBusFees(BusFeesDto busFeesDto);
    public void deleteBusFees(BusFeesDto busFeesDto);
    public ResponseWrapperDto saveTotalAmount(BusFeesDto busFeesDto);
}
