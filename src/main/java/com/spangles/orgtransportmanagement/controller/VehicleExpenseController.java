package com.spangles.orgtransportmanagement.controller;

import com.spangles.orgtransportmanagement.dto.VehicleExpenseDto;
import com.spangles.orgtransportmanagement.dto.response.ExpenseReportDto;
import com.spangles.orgtransportmanagement.dto.response.ProfitDto;
import com.spangles.orgtransportmanagement.dto.response.VehicleExpenseWrapperDto;
import com.spangles.orgtransportmanagement.service.VehicleExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "vehicleExpense")
@RestController
public class VehicleExpenseController {
    @Autowired
    VehicleExpenseService vehicleExpenseService;

    @RequestMapping(value = "g_vehicle_expense/{expense_id}",method = RequestMethod.GET)
    @ResponseBody
    public VehicleExpenseDto getVehicleExpense(@PathVariable("expense_id") Long expenseId){
        return vehicleExpenseService.getVehicleExpense(expenseId);
    }

    @RequestMapping(value = "/s_vehicle_expense",method = RequestMethod.POST)
    @ResponseBody
    public VehicleExpenseWrapperDto save(@RequestBody VehicleExpenseDto vehicleExpenseDto){
        return vehicleExpenseService.saveVehicleExpense(vehicleExpenseDto);
    }
    @RequestMapping(value = "u_vehicle_expense",method = RequestMethod.PUT)
    @ResponseBody
    public VehicleExpenseDto updateVehicleExpense(@RequestBody VehicleExpenseDto vehicleExpenseDto){
        return vehicleExpenseService.updateVehicleExpense(vehicleExpenseDto);
    }

    @RequestMapping(value = "d_vehicle_expense",method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@RequestBody VehicleExpenseDto vehicleExpenseDto){
        vehicleExpenseService.delete(vehicleExpenseDto);
    }
    @RequestMapping(value = "/g_expense/{vehicle_id}",method = RequestMethod.GET)
    @ResponseBody
    public ExpenseReportDto getExpenseByVehicleId(@PathVariable ("vehicle_id")Long vehicleId){
        return vehicleExpenseService.getExpenseByVehicleId(vehicleId);
    }
    @RequestMapping(value = "/g_profit/{vehicle_id}",method = RequestMethod.GET)
    @ResponseBody
    public ProfitDto getProfitByVehicleId(@PathVariable ("vehicle_id") Long vehicleId){
        return vehicleExpenseService.getProfitByVehicleId(vehicleId);
    }
}
