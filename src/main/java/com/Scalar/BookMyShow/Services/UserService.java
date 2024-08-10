package com.Scalar.BookMyShow.Services;

import com.Scalar.BookMyShow.Repositories.UserRepository;
import com.Scalar.BookMyShow.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service

public class UserService {
    private UserRepository userRepository;

    @Autowired

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }




    public User signUp(String email, String password){

        Optional<User> userOptional=userRepository.findByEmail(email);

        if(userOptional.isPresent()){
            throw new RuntimeException();
        }

        User user=new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setBookings(new ArrayList<>());




        User savedUser=userRepository.save(user);
        return savedUser;

    }

}
