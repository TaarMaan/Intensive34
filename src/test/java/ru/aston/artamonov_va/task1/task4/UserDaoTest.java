package ru.aston.artamonov_va.task1.task4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.aston.artamonov_va.task1.task4.dao.UserDao;
import ru.aston.artamonov_va.task1.task4.domain.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    static UserDao userDao;

    @BeforeAll
    static void init() {
        userDao = new UserDao();
    }

    @Test
    void findAll() {
        List<User> userList = userDao.findAll();
        assertEquals(userList.get(0).getName(), "Артем");
    }

    @Test
    void findEntityById() {
        User user = new User(1, "Кирилл", "Кокосов",
                "8-996-000-00-32", "kirillUser@gmail.com", 3);
        Assertions.assertEquals(userDao.findEntityById(user.getId()).getSurname(), "Кокосов");
    }

    @Test
    void delete() {
        User user = new User(4, "Владислав", "Виноградов",
                "8-996-000-00-03", "vladUser@gmail.com", 1);
        assertTrue(userDao.delete(user.getId()));
    }

    @Test
    void create() {
        User user = new User(4, "Владислав", "Виноградов",
                "8-996-000-00-03", "vladUser@gmail.com", 1);
        assertTrue(userDao.create(user));
    }
    @Test
    void update() {
        User user = new User(1, "Кирилл", "Кокосов",
                "8-996-000-00-32", "kirillUser@gmail.com", 3);
        Assertions.assertEquals(userDao.update(user).getName(), "Кирилл");
    }

    @Test
    void joinUsersAndOrders() {
        String output = "Клиент: Кирилл" + "Заказ: Buy smurf acc 6.5k";
        assertEquals(userDao.joinUsersAndOrders().get(0), output);
    }
}