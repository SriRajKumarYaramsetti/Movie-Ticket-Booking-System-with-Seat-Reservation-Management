package com.Scalar.BookMyShow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;

    @ManyToMany
    private List<ShowSeat> showSeat;

    @ManyToOne
    private User user;

    private Date bookedAt;

    @ManyToOne
    private Show show;

    private int amount;

    @OneToMany
    private List<Payment> payments;

}
