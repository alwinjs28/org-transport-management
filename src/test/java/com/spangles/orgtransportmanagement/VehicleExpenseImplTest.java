package com.spangles.orgtransportmanagement;

import com.spangles.orgtransportmanagement.dto.VehicleExpenseDto;
import com.spangles.orgtransportmanagement.dto.response.ExpenseReportDto;
import com.spangles.orgtransportmanagement.dto.response.ProfitDto;
import com.spangles.orgtransportmanagement.entity.VehicleExpense;
import com.spangles.orgtransportmanagement.service.VehicleExpenseService;
import com.spangles.orgtransportmanagement.service.impl.VehicleExpenseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j

public class VehicleExpenseImplTest {
    @Autowired
    VehicleExpenseService vehicleExpenseService;

    //@Test
    public void getExpenseByVehicleIdTest(){
        Long vehicleId = 1L;
        ExpenseReportDto expenseReportDto = vehicleExpenseService.getExpenseByVehicleId(vehicleId);
        List<VehicleExpenseDto> vehicleExpenses = expenseReportDto.getVehicleExpenseDtos();
        for (int i=0;i<vehicleExpenses.size();i++){
            VehicleExpenseDto vehicleExpenseDto = vehicleExpenses.get(i);

            Long expenseId = vehicleExpenseDto.getExpenseId();
            String expenseName = vehicleExpenseDto.getExpenseName();

            log.info("The ExpenseIs is : {}",expenseId);
            log.info("The Expense Name Is : {}",expenseName);

        }
    }
    @Test
    public void getProfitByVehicleIdTest(){
        Long vehicleId = 1L;
        ProfitDto profitDto = vehicleExpenseService.getProfitByVehicleId(vehicleId);
    }
}
