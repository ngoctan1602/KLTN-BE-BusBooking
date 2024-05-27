package com.tantan.BusBookingBEJava.repository;

import com.tantan.BusBookingBEJava.entity.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
