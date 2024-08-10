package com.Scalar.BookMyShow.Repositories;

import com.Scalar.BookMyShow.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface ShowRepository  extends JpaRepository<Show,Long> {

    @Override
    static Optional<Show> findById(Long aLong);
}
