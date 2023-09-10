package ru.aston.artamonov_va.task1.task12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.aston.artamonov_va.task1.task12.dto.User;
import ru.aston.artamonov_va.task1.task12.exceptions.TicketException;
import ru.aston.artamonov_va.task1.task12.list.ListUsersTicket;
import ru.aston.artamonov_va.task1.task12.tickets.InternationalTicket;
import ru.aston.artamonov_va.task1.task12.tickets.SuburbTicket;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ListUsersRailWaySuburbTicketTest {
    ListUsersTicket listUsersTicket;

    List<RailWayTicket> testList;
    List<RailWayTicket> testCollectionsList;
    TreeSet<Integer> testSet;
    Map<Integer, User> testMap;

    @BeforeEach
    void initListUsersTransportation() {
        User user1 = new User(20, "Ананасов", "Артур");
        User user2 = new User(25, "Огурцов", "Олег");
        User user3 = new User(30, "Яблонев", "Ян");
        User user4 = new User(35, "Грушева", "Галина");
        User user5 = new User(40, "Малина", "Мария");

        User testUser1 = new User(45, "Банана", "Бао");
        User testUser2 = new User(50, "Арбузов", "Артем");

        testList = new ArrayList<>();
        testCollectionsList = new ArrayList<>();
        testList.add(new SuburbTicket(BigDecimal.valueOf(20), user1, 1));
        testList.add(new InternationalTicket(BigDecimal.valueOf(10), user2, 2));
        testList.add(new SuburbTicket(BigDecimal.valueOf(5), user3, 3));
        testList.add(new SuburbTicket(BigDecimal.valueOf(5), user4, 4));
        testList.add(new InternationalTicket(BigDecimal.valueOf(5), user5, 5));

        testCollectionsList.add(new SuburbTicket(BigDecimal.valueOf(20), testUser1, 1));
        testCollectionsList.add(new InternationalTicket(BigDecimal.valueOf(10), testUser2, 2));

        listUsersTicket = new ListUsersTicket(testList);

        testSet = new TreeSet<>();
        testSet.add(20);
        testSet.add(10);
        testSet.add(5);

        testMap = new HashMap<>();
        testMap.put(1, user1);
        testMap.put(2, user2);
        testMap.put(3, user3);
        testMap.put(4, user4);
        testMap.put(5, user5);
    }

    @Test
    void calcTransportationAmount() {
        assertEquals(BigDecimal.valueOf(45), listUsersTicket.calcTransportationAmount());
    }

    @Test
    void sortList() {
        assertEquals(listUsersTicket.sortList().get(1).getUser().getSourName(), "Грушева");
    }

    @Test
    void testTicketException() {
        assertThrows(TicketException.class, () -> {
            User user = new User(40, "Малина", "Мария");
            RailWayTicket rwt = new InternationalTicket(BigDecimal.ZERO, user, 5);
        });
    }

    @Test
    void testArrayListEquals() {
        assertNotEquals(testList, testCollectionsList);
        testList.clear();
    }

    @Test
    void testTreeSetPollLastMethod() {
        assertEquals(testSet.pollLast(), 20);
    }

    @Test
    void testHashMapContainsMethod() {
        testMap.remove(3);
        assertNull(testMap.get(3));
    }
}
