package com.softserve.service.provider.futureFeaturesNotToUse;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TruckRepository extends CrudRepository<Truck, UUID> {
}
