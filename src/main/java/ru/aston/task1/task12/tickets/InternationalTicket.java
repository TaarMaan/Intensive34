package ru.aston.task1.task12.tickets;


import ru.aston.task1.task12.RailWayTicket;
import ru.aston.task1.task12.dto.User;

import java.math.BigDecimal;

public class InternationalTicket extends RailWayTicket {
    private final BigDecimal percentConsumer = new BigDecimal("0.07");

    public InternationalTicket(BigDecimal sumTransportation, User user, int id) {
        super(sumTransportation, user, id);
    }

    @Override
    public BigDecimal getDiscount() {
        return sumTransportation.add(percentConsumer);
    }
}
