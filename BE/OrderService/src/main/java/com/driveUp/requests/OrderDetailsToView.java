package com.driveUp.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class OrderDetailsToView {
    private long OrderNumber;
    private Date date;
}
