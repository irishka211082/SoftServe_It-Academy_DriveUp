package com.softserve.service.provider.repository;

import com.softserve.service.provider.model.Driver;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DriverRepository extends CrudRepository<Driver, UUID> {
    Driver findDriverByCarId(UUID id);

    @Query(value = "SELECT AVG(rating) from histories where driver_id = ?", nativeQuery = true)
    Double getDriverRating(UUID id);
}
