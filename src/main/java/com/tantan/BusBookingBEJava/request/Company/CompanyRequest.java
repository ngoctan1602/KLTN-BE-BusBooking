package com.tantan.BusBookingBEJava.request.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompanyRequest {
    private String name;
    private String road;
    private long idWard;
}
