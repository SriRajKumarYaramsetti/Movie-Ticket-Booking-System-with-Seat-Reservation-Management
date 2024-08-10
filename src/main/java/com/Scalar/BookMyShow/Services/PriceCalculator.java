package com.Scalar.BookMyShow.Services;


import com.Scalar.BookMyShow.Repositories.ShowSeatTypeRepository;
import com.Scalar.BookMyShow.models.Show;
import com.Scalar.BookMyShow.models.ShowSeat;
import com.Scalar.BookMyShow.models.ShowSeatType;
import lombok.Setter;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculator {

   /* private ShowSeatTypeRepository showSeatTypeRepository;
    @Autowired
    public PriceCalculator(ShowSeatTypeRepository showSeatTypeRepository){
        this.showSeatTypeRepository=showSeatTypeRepository;
    }

    public int CalculatePrice(List<ShowSeat> seats, Show show){



        //1.Get showSeatType for that show
        List<ShowSeatType> showSeatTypes=ShowSeatTypeRepository.findAllByShow(show);


        //2.Get SeatType for all seats
        int amount=0;
        for (ShowSeat showSeat:seats){
            for (ShowSeatType showSeatType:showSeatTypes){
                if (showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())){
                    amount=amount+showSeatType.getPrice();
                    break;
                }
            }
        }

        //3.Add amount of all
        return amount;
    }*/




}
