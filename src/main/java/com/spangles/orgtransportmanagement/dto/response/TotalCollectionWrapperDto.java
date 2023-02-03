package com.spangles.orgtransportmanagement.dto.response;

import java.io.Serializable;
import java.util.List;

public class TotalCollectionWrapperDto implements Serializable {
    private List<StudentCollectionDto> studentCollectionDtos;
    private List<StaffCollectionDto> staffCollectionDtos;
    private SummaryDto summaryDto;
    private AdditionalHeaderDto additionalHeaderDto;

    public TotalCollectionWrapperDto(){

    }
    public TotalCollectionWrapperDto(List<StudentCollectionDto> studentCollectionDtos, List<StaffCollectionDto> staffCollectionDtos, SummaryDto summaryDto, AdditionalHeaderDto additionalHeaderDto){
        this.studentCollectionDtos = studentCollectionDtos;
        this.staffCollectionDtos = staffCollectionDtos;
        this.summaryDto = summaryDto;
        this.additionalHeaderDto = additionalHeaderDto;
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

    public AdditionalHeaderDto getMetaDataDto() {
        return additionalHeaderDto;
    }

    public void setMetaDataDto(AdditionalHeaderDto additionalHeaderDto) {
        this.additionalHeaderDto = additionalHeaderDto;
    }
}
