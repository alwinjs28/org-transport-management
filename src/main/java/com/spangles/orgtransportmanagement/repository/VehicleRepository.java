package com.spangles.orgtransportmanagement.repository;

import com.spangles.orgtransportmanagement.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
    @Query(value = "SELECT v FROM Vehicle v WHERE v.vehicleId=?1")
    public Vehicle getVehicle(Long vehicleId);
    @Query(value = "SELECT v FROM Vehicle v WHERE v.vehicleType=?1")
    public List<Vehicle> getVehicleByVehicleType(String vehicleType);
}
