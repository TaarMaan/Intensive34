package ru.aston.artamonov_va.task1.task4.repository;

import ru.aston.artamonov_va.task1.task4.dao.OrderDao;
import ru.aston.artamonov_va.task1.task4.domain.Order;

import java.util.List;

public class OrderRepository {
    private final OrderDao orderDao;

    public OrderRepository(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public List<Order> findAll(){
        return orderDao.findAll();
    }

    public Order findEntityById(int id){
        return orderDao.findEntityById(id);
    }

    public boolean delete(int id){
        return orderDao.delete(id);
    }

    public boolean create(Order order) {
        return orderDao.create(order);
    }

    public Order update(Order order) {
        return orderDao.update(order);
    }
}