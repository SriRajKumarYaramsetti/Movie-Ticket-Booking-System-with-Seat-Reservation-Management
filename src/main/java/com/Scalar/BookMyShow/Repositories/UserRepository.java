package com.Scalar.BookMyShow.Repositories;

import com.Scalar.BookMyShow.models.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Override
    Optional<User> findById(Long aLong);

    @Override
    List<User> findAll();


    Optional<User> findByEmail(String email);

    @Override
    User save(User user);
}
