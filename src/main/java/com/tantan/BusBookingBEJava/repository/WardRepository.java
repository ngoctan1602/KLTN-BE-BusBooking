package com.tantan.BusBookingBEJava.repository;

import com.tantan.BusBookingBEJava.entity.Address.Ward;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WardRepository extends JpaRepository <Ward,Long>{
}
