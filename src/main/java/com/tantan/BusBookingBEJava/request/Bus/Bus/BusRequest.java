package com.tantan.BusBookingBEJava.request.Bus.Bus;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BusRequest {
    @NotNull(message = "licensePlate must not null")
    private String licensePlate;
    private long idTypeBus;
    private long idTypeSeat;
    private List<Long> listIdRoute;
}
