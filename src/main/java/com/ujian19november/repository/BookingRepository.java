package com.ujian19november.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujian19november.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
