package com.senla.carservice.dto;

import com.senla.carservice.util.calendar.Calendar;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PlaceDto {

    private String id;
    private Calendar calendar;
}
