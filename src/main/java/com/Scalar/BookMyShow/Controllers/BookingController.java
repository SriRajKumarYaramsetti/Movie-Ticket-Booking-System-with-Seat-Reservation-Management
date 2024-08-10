package com.Scalar.BookMyShow.Controllers;

import com.Scalar.BookMyShow.Services.BookingServices;
import com.Scalar.BookMyShow.dtos.BookMovieRequestDto;
import com.Scalar.BookMyShow.dtos.BookMovieResponseDto;
import com.Scalar.BookMyShow.dtos.ResponseStatus;
import com.Scalar.BookMyShow.models.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller

public class BookingController {


    private BookingServices bookingServices;


    @Autowired
    public BookingController(BookingServices bookingServices){
        this.bookingServices=bookingServices;
    }


    public BookMovieResponseDto bookMovie(BookMovieRequestDto request){

        BookMovieResponseDto response=new BookMovieResponseDto();
        try {
            Booking booking = bookingServices.bookMovie(request.getUserId(),
                    request.getShowSeatIds(),
                    request.getShowId());


            response.setResponseStatus(ResponseStatus.SUCCESS);
            response.setBookingId(booking.getId());
            response.setAmount(booking.getAmount());
        }catch (Exception e){
            response.setResponseStatus(ResponseStatus.FAILURE);
            System.out.println("Error");
        }

        return response;
    }
}
