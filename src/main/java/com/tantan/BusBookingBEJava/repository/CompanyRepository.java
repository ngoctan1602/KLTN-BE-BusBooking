package com.tantan.BusBookingBEJava.repository;

import com.tantan.BusBookingBEJava.entity.Company.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
