package com.Scalar.BookMyShow.Services;

import com.Scalar.BookMyShow.Exceptions.UserNotFoundException;
import com.Scalar.BookMyShow.Repositories.BookingRepository;
import com.Scalar.BookMyShow.Repositories.ShowRepository;
import com.Scalar.BookMyShow.Repositories.ShowSeatRepository;
import com.Scalar.BookMyShow.Repositories.UserRepository;
import com.Scalar.BookMyShow.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class BookingServices {


    private BookingRepository bookingRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private UserRepository userRepository;
    private PriceCalculator priceCalculator;


    @Autowired
    public BookingServices(BookingRepository bookingRepository,
                           ShowRepository showRepository,
                           ShowSeatRepository showSeatRepository,
                           UserRepository userRepository,PriceCalculator priceCalculator){
        this.bookingRepository=bookingRepository;
        this.showRepository=showRepository;
        this.userRepository=userRepository;
        this.priceCalculator=priceCalculator;
    }


    @Transactional(isolation = Isolation.SERIALIZABLE)

    public Booking bookMovie(Long userId, List<Long> seatId, Long showId) throws UserNotFoundException {


        //---------Today we will start the lock here-------
        //1.Get user with that userId

        Optional<User> userOptional=userRepository.findById(userId);
        if (userOptional.isEmpty()){
            throw new UserNotFoundException("User with that Id is not there");
        }
        User bookedBy=userOptional.get();
        //2.Get show with that showId

        Optional<Show> showOptional=ShowRepository.findById(showId);
        if (showOptional.isEmpty()){
          throw new RuntimeException();
       }
        Show bookedShow=showOptional.get();

        //------------- Take Lock---------------
        //3.Get ShowSeat with that seatIds

        List<ShowSeat> showSeats=ShowSeatRepository.findAllById(seatId);


        //4.Check if all show seats are available
        //5.If no,throw error
        for (ShowSeat showSeat:showSeats) {
            if (!showSeat.getStatus().equals(ShowSeatStatus.AVAILABLE) ||
                    (showSeat.getStatus().equals(ShowSeatStatus.BLOCKED) &&
                            Duration.between(showSeat.getBlockedAt().toInstant(), new Date().toInstant()).toMinutes() > 15)){
                throw new RuntimeException();
            }
        }

        List<ShowSeat> savedShowSeat=new ArrayList<>();
        //6.If Yes,Mark the status of show seats as LOCKED
            // 7.Save updated show seats to DB

         for (ShowSeat showSeat1:showSeats){
             showSeat1.setStatus(ShowSeatStatus.BLOCKED);
             savedShowSeat.add(ShowSeatRepository.save(showSeat1));
         }



        //--------------- End Lock----------------

        //8.Create Corresponding booking object
            Booking booking =new Booking();
         booking.setBookingStatus(BookingStatus.PENDING);
         booking.setShowSeat(savedShowSeat);
         booking.setUser(bookedBy);
         booking.setBookedAt(new Date());
         booking.setShow(bookedShow);

         booking.setPayments(new ArrayList<>());


            //Return Booking Object





        //-----------We will end the lock here--------------

        Booking savedBooking=bookingRepository.save(booking);
        return savedBooking;



    }
}


