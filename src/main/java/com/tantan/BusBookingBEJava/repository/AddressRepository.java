package com.tantan.BusBookingBEJava.repository;

import com.tantan.BusBookingBEJava.entity.Address.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
