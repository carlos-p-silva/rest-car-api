package com.caps.rentcarapi.repository;

import com.caps.rentcarapi.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
