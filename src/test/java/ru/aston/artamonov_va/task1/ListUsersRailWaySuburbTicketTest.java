package ru.aston.artamonov_va.task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.aston.artamonov_va.task1.dto.User;
import ru.aston.artamonov_va.task1.list.ListUsersTicket;
import ru.aston.artamonov_va.task1.tickets.InternationalTicket;
import ru.aston.artamonov_va.task1.tickets.SuburbTicket;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListUsersRailWaySuburbTicketTest {
    private ListUsersTicket listUsersTicket;

    @BeforeEach
    void initListUsersTransportation() {
        User user1 = new User(20, "Ананасов", "Артур");
        User user2 = new User(25, "Огурцов", "Олег");
        User user3 = new User(30, "Яблонев", "Ян");
        User user4 = new User(35, "Грушева", "Галина");
        User user5 = new User(40, "Малина", "Мария");

        List<RailWayTicket> list = new ArrayList<>();
        list.add(new SuburbTicket(BigDecimal.valueOf(20), user1, 1));
        list.add(new InternationalTicket(BigDecimal.valueOf(10), user2, 2));
        list.add(new SuburbTicket(BigDecimal.valueOf(5), user3, 3));
        list.add(new SuburbTicket(BigDecimal.valueOf(5), user4, 4));
        list.add(new InternationalTicket(BigDecimal.valueOf(5), user5, 5));
        listUsersTicket = new ListUsersTicket(list);
    }

    @Test
    void calcTransportationAmount() {
        assertEquals(BigDecimal.valueOf(45), listUsersTicket.calcTransportationAmount());
    }

    @Test
    void sortList() {
        assertEquals(listUsersTicket.sortList().get(1).getUser().getSourName(), "Грушева");
    }
}
