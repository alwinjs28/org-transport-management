package com.spangles.orgtransportmanagement.service;

import com.spangles.orgtransportmanagement.dto.BusFeesDto;
import com.spangles.orgtransportmanagement.dto.response.BusFeesResponseWrapperDto;

public interface BusFeesService {
    public BusFeesDto getBusFees(Long busFeesId);
    public BusFeesDto updateBusFees(BusFeesDto busFeesDto);
    public void deleteBusFees(BusFeesDto busFeesDto);
    public BusFeesResponseWrapperDto saveBusFees(BusFeesDto busFeesDto);
}
