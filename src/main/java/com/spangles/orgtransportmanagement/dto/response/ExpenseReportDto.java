package com.spangles.orgtransportmanagement.dto.response;

import com.spangles.orgtransportmanagement.dto.VehicleExpenseDto;

import java.io.Serializable;
import java.util.List;

public class ExpenseReportDto implements Serializable {
    private List<VehicleExpenseDto> vehicleExpenseDtos;
    private ExpenseSummaryDto expenseSummaryDto;
    private AdditionalHeaderDto additionalHeaderDto;

    public ExpenseReportDto(){

    }
    public ExpenseReportDto(List<VehicleExpenseDto> vehicleExpenseDtos, ExpenseSummaryDto expenseSummaryDto, AdditionalHeaderDto additionalHeaderDto) {
        this.vehicleExpenseDtos = vehicleExpenseDtos;
        this.expenseSummaryDto = expenseSummaryDto;
        this.additionalHeaderDto = additionalHeaderDto;
    }

    public List<VehicleExpenseDto> getVehicleExpenseDtos() {
        return vehicleExpenseDtos;
    }

    public void setVehicleExpenseDtos(List<VehicleExpenseDto> vehicleExpenseDtos) {
        this.vehicleExpenseDtos = vehicleExpenseDtos;
    }

    public ExpenseSummaryDto getExpenseSummaryDto() {
        return expenseSummaryDto;
    }

    public void setExpenseSummaryDto(ExpenseSummaryDto expenseSummaryDto) {
        this.expenseSummaryDto = expenseSummaryDto;
    }

    public AdditionalHeaderDto getAdditionalHeaderDto() {
        return additionalHeaderDto;
    }

    public void setAdditionalHeaderDto(AdditionalHeaderDto additionalHeaderDto) {
        this.additionalHeaderDto = additionalHeaderDto;
    }
}
