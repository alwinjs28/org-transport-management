package com.ma.orgtransportmanagement.service;

import com.ma.orgtransportmanagement.dto.BusFeesDto;

public interface BusFeesService {
    public BusFeesDto getBusFees(Long busTypeId);
    public BusFeesDto saveBusFees(BusFeesDto busFeesDto);
    public BusFeesDto updateBusFees(BusFeesDto busFeesDto);
    public void deleteBusFees(BusFeesDto busFeesDto);
}
