package com.Scalar.BookMyShow.Repositories;

import com.Scalar.BookMyShow.models.Show;
import com.Scalar.BookMyShow.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType,Long> {
    List<ShowSeatType> findAllByShow(Show show);
}
