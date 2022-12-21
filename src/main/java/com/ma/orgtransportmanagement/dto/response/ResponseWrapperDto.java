package com.ma.orgtransportmanagement.dto.response;

import com.ma.orgtransportmanagement.dto.BusFeesDto;
import com.ma.orgtransportmanagement.dto.PassengerDto;
import com.ma.orgtransportmanagement.dto.TripPriceDto;
import com.ma.orgtransportmanagement.dto.response.MetaDataDto;

import java.io.Serializable;

public class ResponseWrapperDto implements Serializable {
    private BusFeesDto busFeesDto;
    private MetaDataDto metaDataDto;

    public ResponseWrapperDto(){

    }
    public ResponseWrapperDto(BusFeesDto busFeesDto,MetaDataDto metaDataDto){
        this.busFeesDto = busFeesDto;
        this.metaDataDto = metaDataDto;
    }

    public BusFeesDto getBusFeesDto() {
        return busFeesDto;
    }

    public void setBusFeesDto(BusFeesDto busFeesDto) {
        this.busFeesDto = busFeesDto;
    }

    public MetaDataDto getMetaDataDto() {
        return metaDataDto;
    }

    public void setMetaDataDto(MetaDataDto metaDataDto) {
        this.metaDataDto = metaDataDto;
    }
}
