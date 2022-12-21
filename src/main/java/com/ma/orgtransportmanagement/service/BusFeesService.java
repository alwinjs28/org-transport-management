package com.ma.orgtransportmanagement.service;

import com.ma.orgtransportmanagement.dto.BusFeesDto;
import com.ma.orgtransportmanagement.dto.response.BusFeesResponseWrapperDto;

public interface BusFeesService {
    public BusFeesDto getBusFees(Long busFeesId);
    public BusFeesDto saveBusFees(BusFeesDto busFeesDto);
    public BusFeesDto updateBusFees(BusFeesDto busFeesDto);
    public void deleteBusFees(BusFeesDto busFeesDto);
    public BusFeesResponseWrapperDto saveTotalAmount(BusFeesDto busFeesDto);
}
