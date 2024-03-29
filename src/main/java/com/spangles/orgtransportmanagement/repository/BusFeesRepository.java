package com.spangles.orgtransportmanagement.repository;

import com.spangles.orgtransportmanagement.entity.BusFees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BusFeesRepository extends JpaRepository<BusFees,Long> {
    @Query(value = "SELECT b FROM BusFees b Where b.busFeesId=?1")
    public BusFees getBusFees(Long busFeesId);

    @Query(value = "SELECT b FROM BusFees b Where b.passengerId=?1")
    public BusFees getBusFeesByPassengerId(Long passengerId);

}
