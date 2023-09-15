package ru.aston.artamonov_va.task12.tickets;

import ru.aston.artamonov_va.task12.RailWayTicket;
import ru.aston.artamonov_va.task12.dto.User;

import java.math.BigDecimal;

public class SuburbTicket extends RailWayTicket {
    private final BigDecimal percentTicket = new BigDecimal("0.15");

    public SuburbTicket(BigDecimal sumTransportation, User user, int id) {
        super(sumTransportation, user, id);
    }

    @Override
    public BigDecimal getDiscount() {
        return sumTransportation.add(percentTicket);
    }
}
