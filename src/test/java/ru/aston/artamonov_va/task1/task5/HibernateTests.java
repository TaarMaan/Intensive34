package ru.aston.artamonov_va.task1.task5;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;
import org.hibernate.cfg.Configuration;
import ru.aston.artamonov_va.task1.task5.Entity.Birthday;
import ru.aston.artamonov_va.task1.task5.Entity.OrderType;
import ru.aston.artamonov_va.task1.task5.Entity.UserOrder;
import ru.aston.artamonov_va.task1.task5.Entity.User;
import ru.aston.artamonov_va.task1.task5.Entity.Order;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
public class HibernateTests {
    private static SessionFactory sessionFactory;
    private Session session;
    private User user;

    private Order order;
    private UserOrder userOrder;

    @BeforeAll
    public static void init() {
        try {
            Configuration configuration = new Configuration();
            sessionFactory = configuration
                    .addAnnotatedClass(Order.class)
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @BeforeEach
    public void start() {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();

            List<Order> orderList = Stream.generate(
                            () -> Order
                                    .builder()
                                    .name("order_" + RandomString.make(3))
                                    .text("text_" + RandomString.make(18))
                                    .orderType(OrderType.URGENT)
                                    .user(user)
                                    .build())
                    .limit(2)
                    .toList();

            user = User
                    .builder()
                    .orders(orderList)
                    .name("Vlad")
                    .secondName("Artamonov")
                    .age(25)
                    .birthday(new Birthday(LocalDate.of(1998, 3, 18)))
                    .phoneNumber("+70000000000")
                    .email("vlad_artamonov@gmail.com")
                    .orderType(OrderType.URGENT)
                    .build();

            userOrder = new UserOrder("{\"Userinfo\":\"User test\"}");

            order = Order.builder().name("Заказ " + RandomString.make(18))
                    .orderType(OrderType.URGENT).build();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void createOrder() {
        session.saveOrUpdate(order);
    }

    @Test
    public void deleteOrder() {
        session.delete(order);
    }

    @Test
    public void createUser() {
        session.saveOrUpdate(user);
    }

    @AfterEach
    public void stop() {
        session.getTransaction().commit();
        session.close();
    }
}
