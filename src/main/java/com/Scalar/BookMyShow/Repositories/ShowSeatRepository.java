package com.Scalar.BookMyShow.Repositories;

import com.Scalar.BookMyShow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat,Long> {

    @Override
    static List<ShowSeat> findAllById(Iterable<Long> longs);

    @Override
    static ShowSeat save(ShowSeat entity); //Update if showseat has an id or else insert the showseat
}
