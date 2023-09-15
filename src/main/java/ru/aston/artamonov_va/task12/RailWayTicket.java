package ru.aston.artamonov_va.task12;

import lombok.Data;
import ru.aston.artamonov_va.task12.dto.User;
import ru.aston.artamonov_va.task12.exceptions.TicketException;

import java.math.BigDecimal;

@Data
public abstract class RailWayTicket implements Discount {
    public RailWayTicket(BigDecimal sumTransportation, User user, int id) {
        BigDecimal ticketNegativeException = new BigDecimal("0");
        if (sumTransportation.compareTo(ticketNegativeException) <= 0){
            throw new TicketException("Стоимость билета не должна быть < 0", 1);
        }
        BigDecimal ticketZeroException = new BigDecimal("0");
        if (sumTransportation.compareTo(ticketZeroException) <= 0){
            throw new TicketException("Стоимость билета не должна быть = 0", 0);
        }
        this.sumTransportation = sumTransportation;
        this.user = user;
        this.id = id;
    }

    protected BigDecimal sumTransportation;
    private User user;
    private int id;

}
