package com.spangles.orgtransportmanagement.dto.response;

import com.spangles.orgtransportmanagement.dto.BusFeesDto;

import java.io.Serializable;

public class BusFeesResponseWrapperDto implements Serializable {
    private BusFeesDto busFeesDto;
    private AdditionalHeaderDto additionalHeaderDto;

    public BusFeesResponseWrapperDto(){

    }
    public BusFeesResponseWrapperDto(BusFeesDto busFeesDto, AdditionalHeaderDto additionalHeaderDto){
        this.busFeesDto = busFeesDto;
        this.additionalHeaderDto = additionalHeaderDto;
    }

    public BusFeesDto getBusFeesDto() {
        return busFeesDto;
    }

    public void setBusFeesDto(BusFeesDto busFeesDto) {
        this.busFeesDto = busFeesDto;
    }

    public AdditionalHeaderDto getAdditionalHeaderDto() {
        return additionalHeaderDto;
    }

    public void setAdditionalHeaderDto(AdditionalHeaderDto additionalHeaderDto) {
        this.additionalHeaderDto = additionalHeaderDto;
    }
}
