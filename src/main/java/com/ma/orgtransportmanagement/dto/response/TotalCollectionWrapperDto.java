package com.ma.orgtransportmanagement.dto.response;

import java.io.Serializable;
import java.util.List;

public class TotalCollectionWrapperDto implements Serializable {
    private List<StudentCollectionDto> studentCollectionDtos;
    private List<StaffCollectionDto> staffCollectionDtos;
    private SummaryDto summaryDto;
    private MetaDataDto metaDataDto;

    public TotalCollectionWrapperDto(){

    }
    public TotalCollectionWrapperDto(List<StudentCollectionDto> studentCollectionDtos, List<StaffCollectionDto> staffCollectionDtos, SummaryDto summaryDto, MetaDataDto metaDataDto){
        this.studentCollectionDtos = studentCollectionDtos;
        this.staffCollectionDtos = staffCollectionDtos;
        this.summaryDto = summaryDto;
        this.metaDataDto = metaDataDto;
    }

    public List<StudentCollectionDto> getStudentCollectionDtos() {
        return studentCollectionDtos;
    }

    public void setStudentCollectionDto(List<StudentCollectionDto> studentCollectionDtos) {
        this.studentCollectionDtos = studentCollectionDtos;
    }

    public List<StaffCollectionDto> getStaffCollectionDtos() {
        return staffCollectionDtos;
    }

    public void setStaffCollectionDto(List<StaffCollectionDto> staffCollectionDtos) {
        this.staffCollectionDtos = staffCollectionDtos;
    }

    public SummaryDto getSummaryDto() {
        return summaryDto;
    }

    public void setSummaryDto(SummaryDto summaryDto) {
        this.summaryDto = summaryDto;
    }

    public MetaDataDto getMetaDataDto() {
        return metaDataDto;
    }

    public void setMetaDataDto(MetaDataDto metaDataDto) {
        this.metaDataDto = metaDataDto;
    }
}
