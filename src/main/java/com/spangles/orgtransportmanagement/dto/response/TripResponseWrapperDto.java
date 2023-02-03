package com.spangles.orgtransportmanagement.dto.response;

import com.spangles.orgtransportmanagement.dto.TripDto;

import java.io.Serializable;

public class TripResponseWrapperDto implements Serializable {
    private TripDto tripDto;
    private AdditionalHeaderDto additionalHeaderDto;

    public TripResponseWrapperDto(){

    }
    public TripResponseWrapperDto(TripDto tripDto,AdditionalHeaderDto additionalHeaderDto){
        this.tripDto = tripDto;
        this.additionalHeaderDto = additionalHeaderDto;
    }

    public TripDto getTripDto() {
        return tripDto;
    }

    public void setTripDto(TripDto tripDto) {
        this.tripDto = tripDto;
    }

    public AdditionalHeaderDto getAdditionalHeaderDto() {
        return additionalHeaderDto;
    }

    public void setAdditionalHeaderDto(AdditionalHeaderDto additionalHeaderDto) {
        this.additionalHeaderDto = additionalHeaderDto;
    }
}
