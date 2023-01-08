package com.ma.orgtransportmanagement.dto.response;

import java.io.Serializable;

public class StaffCollectionDto implements Serializable {
    private Long sNo;
    private Long staffId;
    private String staffName;
    private Double totalAmount;
    private Double paidAmount;

    public StaffCollectionDto(){

    }
    public StaffCollectionDto(Long sNo,Long staffId,String staffName,Double totalAmount,Double paidAmount){
        this.sNo = sNo;
        this.staffId = staffId;
        this.staffName = staffName;
        this.totalAmount = totalAmount;
        this.paidAmount = paidAmount;
    }

    public Long getsNo() {
        return sNo;
    }

    public void setsNo(Long sNo) {
        this.sNo = sNo;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }
}
