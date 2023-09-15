package ru.aston.artamonov_va.task4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.aston.artamonov_va.task1.task4.dao.OrderDao;
import ru.aston.artamonov_va.task1.task4.domain.Order;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderDaoTest {

    static OrderDao orderDao;

    @BeforeAll
    static void init() {
        orderDao = new OrderDao();
    }

    @Test
    void findAll() {
        List<Order> list = orderDao.findAll();
        assertEquals(list.get(2).getName(), "Buy smurf acc");
    }

    @Test
    void findEntityById() {
        Order order = new Order(3, "Buy smurf acc 6.5k");
        Assertions.assertEquals(orderDao.findEntityById(order.getId()).getName(), "Buy smurf acc 6.5k");
    }

    @Test
    void delete() {
        assertTrue(orderDao.delete(2));
    }

    @Test
    void update() {
        Order order = new Order(3, "Buy smurf acc 6.5k");
        Assertions.assertEquals(orderDao.update(order).getName(), "Buy smurf acc 6.5k");
    }

    @Test
    void create() {
        Order order = new Order(1, "Buy smurf acc");
        Order order2 = new Order(2, "Buy smurf acc for brother");
        assertTrue(orderDao.create(order));
        assertTrue(orderDao.create(order2));
    }

}