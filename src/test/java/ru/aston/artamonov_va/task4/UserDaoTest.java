package ru.aston.artamonov_va.task4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.aston.task1.task4.dao.UserDao;
import ru.aston.task1.task4.domain.User;
import ru.aston.task1.task4.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserDaoTest {

    @Mock
    UserDao userDao;

    @InjectMocks
    UserRepository userRepository;

    @Test
    void findAll() {
        List<User> list = new ArrayList<>();
        User user1 = new User(3, "Артем", "Арбузов", "8-996-000-00-00", "artemUser@gmail.com", 3);
        User user2 = new User(4, "Борис", "Бананов", "8-996-000-00-01", "borisUser@gmail.com", 4);
        list.add(user1);
        list.add(user2);

        Mockito.when(userDao.findAll()).thenReturn(list);
        assertEquals(userRepository.findAll().get(0).getName(), "Артем");
    }

    @Test
    void findEntityById() {
        User user = new User(1, "Кирилл", "Кокосов", "8-996-000-00-32", "kirillUser@gmail.com", 3);

        Mockito.when(userDao.findEntityById(user.getId())).thenReturn(user);
        assertEquals(userRepository.findEntityById(user.getId()).getId(), user.getId());
    }

    @Test
    void delete() {
        Mockito.when(userDao.delete(3)).thenReturn(true);
        assertTrue(userRepository.delete(3));
    }

    @Test
    void create() {
        User user = new User(2, "Владислав", "Виноградов",
                "8-996-000-00-03", "vladUser@gmail.com", 1);
        Mockito.when(userDao.create(user)).thenReturn(true);
        assertTrue(userRepository.create(user));
    }
    @Test
    void update() {
        User user = new User(5, "Мифодий", "Мангович", "8-996-000-00-72", "mifodiyUser@gmail.com", 3);
        User userNew = new User(1, "Кирилл", "Кокосов", "8-996-000-00-32", "kirillUser@gmail.com", 3);

        Mockito.when(userDao.update(user)).thenReturn(userNew);
        assertEquals(userRepository.update(user).getName(), userNew.getName());
    }

    @Test
    void joinUsersAndOrders() {
        List<String> list = new ArrayList<>();
        list.add("Клиент: Кирилл" + "Заказ: Buy smurf acc 6.5k");
        list.add("Клиент: Мифодий" + "Заказ: Buy smurf acc 6.5k");

        Mockito.when(userDao.joinUsersAndOrders()).thenReturn(list);
        assertEquals(userDao.joinUsersAndOrders().get(0), list.get(0));
    }
}