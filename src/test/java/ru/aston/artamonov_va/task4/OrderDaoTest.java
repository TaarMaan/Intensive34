package ru.aston.artamonov_va.task1.task4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.aston.task1.task4.dao.OrderDao;
import ru.aston.task1.task4.domain.Order;
import ru.aston.task1.task4.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OrderDaoTest {

    @Mock
    OrderDao orderDao;

    @InjectMocks
    OrderRepository orderRepository;

    @Test
    void findAll() {
        List<Order> list = new ArrayList<>();

        Order order1 = new Order(3, "Buy acc 6k pts");
        Order order2 = new Order(4, "Buy acc 4k pts");
        list.add(order1);
        list.add(order2);

        Mockito.when(orderDao.findAll()).thenReturn(list);
        assertEquals(orderRepository.findAll().get(3).getName(), "Buy acc 6k pts");
    }

    @Test
    void findEntityById() {
        Order order = new Order(3, "Buy smurf acc 6.5k");

        Mockito.when(orderDao.findEntityById(order.getId())).thenReturn(order);
        Order actual = orderRepository.findEntityById(order.getId());
        assertEquals(actual.getName(), "Buy smurf acc 6.5k");
    }

    @Test
    void delete() {
        Mockito.when(orderDao.delete(2)).thenReturn(true);
        assertTrue(orderRepository.delete(2));
    }

    @Test
    void update() {
        Order order = new Order(3, "Buy acc 6k pts");
        Order orderNew = new Order(3, "Buy smurf acc 6.5k");

        Mockito.when(orderDao.update(order)).thenReturn(orderNew);
        assertEquals(orderRepository.update(order).getName(), orderNew.getName());
    }

    @Test
    void create() {
        Order order = new Order(1, "Buy smurf acc");
        Order order2 = new Order(2, "Buy smurf acc for brother");

        Mockito.when(orderDao.create(order)).thenReturn(true);
        Mockito.when(orderDao.create(order2)).thenReturn(true);
        assertTrue(orderRepository.create(order));
        assertTrue(orderRepository.create(order2));
    }

}