package com.tantan.BusBookingBEJava.request.Address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressRequest {
    @NotNull(message = "The road not null")
    private String road;
    private long idWard;
}
