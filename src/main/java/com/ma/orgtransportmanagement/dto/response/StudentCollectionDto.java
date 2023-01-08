package com.ma.orgtransportmanagement.dto.response;

import java.io.Serializable;

public class StudentCollectionDto implements Serializable {
    private Long sNo;
    private Long studentId;
    private String studentName;
    private Double totalAmount;
    private Double paidAmount;

    public StudentCollectionDto(){

    }
    public StudentCollectionDto(Long sNo,Long studentId,String studentName,Double totalAmount,Double paidAmount){
        this.sNo = sNo;
        this.studentId = studentId;
        this.studentName = studentName;
        this.totalAmount = totalAmount;
        this.paidAmount = paidAmount;
    }

    public Long getsNo() {
        return sNo;
    }

    public void setsNo(Long sNo) {
        this.sNo = sNo;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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
