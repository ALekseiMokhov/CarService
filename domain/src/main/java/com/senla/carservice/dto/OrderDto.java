package com.senla.carservice.dto;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDto {
    private String id;
    private String status;

    private String dateBooked;

    private String startOfExecution;
    private String finishOfExecution;
}
