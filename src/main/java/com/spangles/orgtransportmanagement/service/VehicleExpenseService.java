package com.spangles.orgtransportmanagement.service;

import com.spangles.orgtransportmanagement.dto.VehicleExpenseDto;
import com.spangles.orgtransportmanagement.dto.response.VehicleExpenseWrapperDto;

public interface VehicleExpenseService {

    public VehicleExpenseDto getVehicleExpense(Long expenseId);
    public VehicleExpenseWrapperDto saveVehicleExpense(VehicleExpenseDto vehicleExpenseDto);
    public VehicleExpenseDto updateVehicleExpense(VehicleExpenseDto vehicleExpenseDto);
    public void delete(VehicleExpenseDto vehicleExpenseDto);
}
