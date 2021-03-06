package com.driveUp.controller;

import com.driveUp.service.DriverNotificationService;
import lombok.RequiredArgsConstructor;
import com.driveUp.dto.ApprovedOrderDto;
import com.driveUp.dto.CreatedOrderDtoWithDrivers;
import com.driveUp.model.PhoneNotification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/com/driveUp/driver")
@RequiredArgsConstructor
public class DriverNotificationController {

    private final DriverNotificationService driverNotificationService;

    @PostMapping("/order_created")
    public ResponseEntity<List<PhoneNotification>> saveMessageOrderRegistered(@RequestBody CreatedOrderDtoWithDrivers
                                                                                      orderDtoWithDrivers) {
        List<PhoneNotification> listOfNotification = driverNotificationService.
                sayToDriversOrderCreated(orderDtoWithDrivers);
        return new ResponseEntity<>(listOfNotification, HttpStatus.OK);
    }

    @PostMapping("/order_confirmed")
    public ResponseEntity<PhoneNotification> saveMessageOrderConfirmed(@RequestBody ApprovedOrderDto createdOrderDto) {
        PhoneNotification phoneNotification = driverNotificationService.sayOrderConfirmed(createdOrderDto);
        return new ResponseEntity<>(phoneNotification, HttpStatus.OK);
    }

    @PostMapping("/trip_finished")
    public ResponseEntity<PhoneNotification> saveMessageTripFinished(@RequestBody ApprovedOrderDto approvedOrderDto) {
        PhoneNotification phoneNotification = driverNotificationService.sayTripFinished(approvedOrderDto);
        return new ResponseEntity<>(phoneNotification, HttpStatus.OK);
    }
}
