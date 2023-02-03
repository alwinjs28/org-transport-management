package com.spangles.orgtransportmanagement.repository;

import com.spangles.orgtransportmanagement.entity.VehicleMileage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleMileageRepository extends JpaRepository<VehicleMileage,Long> {
    @Query(value = "SELECT vm FROM VehicleMileage vm WHERE vm.vehicleMileageId=?1")
    public VehicleMileage getVehicleMileage(Long vehicleMileageId);
}
