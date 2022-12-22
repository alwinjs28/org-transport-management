package com.ma.orgtransportmanagement.dto.response;

import com.ma.orgtransportmanagement.dto.BusFeesDto;

import java.io.Serializable;

public class BusFeesResponseWrapperDto implements Serializable {
    private BusFeesDto busFeesDto;
    private MetaDataDto metaDataDto;

    public BusFeesResponseWrapperDto(){

    }
    public BusFeesResponseWrapperDto(BusFeesDto busFeesDto, MetaDataDto metaDataDto){
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
