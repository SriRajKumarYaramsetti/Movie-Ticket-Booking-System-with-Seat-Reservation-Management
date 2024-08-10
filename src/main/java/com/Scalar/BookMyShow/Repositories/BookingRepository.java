package com.Scalar.BookMyShow.Repositories;

import com.Scalar.BookMyShow.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
    @Override
    Booking  save(Booking entity);
}
