package com.driveUp.service;

import com.driveUp.repository.RouteRepository;
import com.driveUp.requests.BillingDto;
import com.driveUp.model.Route;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GoogleMapsService implements MapsService {

    private final RouteRepository routeRepository;
    private final JsonParser jsonParser;

    @Override
    public Route insertNewRout(String consumeJSONString, String departureTime) {
        return routeRepository.save(
                jsonParser.parseJSON(consumeJSONString, departureTime));
    }

    @Override
    public List<Route> getAllRouts() {
        List<Route> route = new ArrayList<>();
        routeRepository.findAll()
                .forEach(route::add);
        return route;
    }

    @Override
    public Optional<Route> getById(UUID uuid) {
        return routeRepository.findById(uuid);
    }

    //    get distance for billing
    @Override
    public BillingDto getDistance(long id) {
        float f = routeRepository.getDistance(id);
        return new BillingDto(f, id);
    }
}

