package com.Scalar.BookMyShow.Controllers;

import com.Scalar.BookMyShow.Services.UserService;
import com.Scalar.BookMyShow.dtos.ResponseStatus;
import com.Scalar.BookMyShow.dtos.SignUpRequestDto;
import com.Scalar.BookMyShow.dtos.SignUpResponseDto;
import com.Scalar.BookMyShow.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.stereotype.Controller;

@Controller

public class UserController {

    private UserService userService;

    @Autowired

    public UserController(UserService userService){
        this.userService=userService;

    }

    public SignUpResponseDto signUp(SignUpRequestDto request){

        User user;
        SignUpResponseDto response=new SignUpResponseDto();
        try {
            user=userService.signUp(request.getEmail(), request.getPassword());
            response.setUserId(user.getId());
            response.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception e)
        {
            response.setResponseStatus(ResponseStatus.FAILURE);
        }




        return response;
    }
}
