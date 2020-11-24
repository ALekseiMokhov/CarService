package com.senla.carservice.entity.garage;


import com.senla.carservice.util.calendar.Calendar;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
@Table(name = "places")
public class Place {
    @Id
    @GeneratedValue
    private UUID id;

    @Embedded
    private Calendar calendar;

    public Place(Calendar calendar) {
        this.calendar = calendar;

    }
}
