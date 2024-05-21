package com.tantan.BusBookingBEJava.entity.Route;

import com.tantan.BusBookingBEJava.entity.Station.BusStation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BusStop {
    @EmbeddedId
    private BusStopId busStopId;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idBusStation")
    private BusStation busStation;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idRoute")
    private Route route;
    private int indexStation;
}
