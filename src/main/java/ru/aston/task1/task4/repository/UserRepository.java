package ru.aston.task1.task4.repository;

import ru.aston.task1.task4.dao.UserDao;
import ru.aston.task1.task4.domain.User;

import java.util.List;

public class UserRepository {
    private final UserDao userDao;

    public UserRepository(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> findAll(){
        return userDao.findAll();
    }

    public User findEntityById(int id){
        return userDao.findEntityById(id);
    }

    public boolean delete(int id){
        return userDao.delete(id);
    }

    public boolean create(User user) {
        return userDao.create(user);
    }

    public User update(User user) {
        return userDao.update(user);
    }

    public List<String> joinUsersAndOrders(){
        return userDao.joinUsersAndOrders();
    }
}