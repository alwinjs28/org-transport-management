package com.spangles.orgtransportmanagement.repository;

import com.spangles.orgtransportmanagement.entity.VehicleExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleExpenseRepository extends JpaRepository<VehicleExpense,Long> {

    @Query(value = "SELECT ve FROM VehicleExpense ve WHERE ve.expenseId=?1")
    public VehicleExpense getVehiclesExpense(Long expenseId);
}
