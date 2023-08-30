package ru.aston.artamonov_va.task1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.aston.artamonov_va.task1.dto.User;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public abstract class RailWayTicket implements Discount {
    protected BigDecimal sumTransportation;
    private User user;
    private int id;

}
