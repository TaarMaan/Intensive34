package ru.aston.artamonov_va.task7;

import net.bytebuddy.utility.RandomString;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;
import org.hibernate.cfg.Configuration;

import ru.aston.artamonov_va.task1.task7.entity.*;
import ru.aston.artamonov_va.task1.task7.entity.Order;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public class HibernateTest {
    private static SessionFactory sessionFactory;
    private Session session;
    private User user;

    private Order order;

    private UserOrder userOrder;

    @BeforeAll
    public static void init(){
        try{
            Configuration configuration = new Configuration();
            sessionFactory = configuration
                    .addAnnotatedClass(Order.class)
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(UserOrder.class)
                    .buildSessionFactory();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @BeforeEach
    public void start(){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();


            List<Order> orderList = Stream.generate(
                            () -> Order
                                    .builder()
                                    .name("Order_" + RandomString.make(3))
                                    .text("Order_text" + RandomString.make(18))
                                    .orderType(OrderType.URGENT)
                                    .user(user)
                                    .build())
                    .limit(2)
                    .toList();

            user = User
                    .builder()
                    .orders(orderList)
                    .name("Vladislav")
                    .surname("Artamonov")
                    .age(25)
                    .birthday(new Birthday(LocalDate.of(1998,3,18)))
                    .phone("+70000000000")
                    .email("vlad_artamonov@gmail.com")
                    .build();

            userOrder = new UserOrder("{\"Userinfo\":\"User test\"}");

            order = Order.builder().name("Order " + RandomString.make(3))
                    .orderType(OrderType.URGENT).build();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void createOrder(){
        session.saveOrUpdate(order);
    }

    @Test
    public void deleteOrder(){
        session.delete(order);
    }

    @Test
    public void createUser(){
        session.saveOrUpdate(user);
    }

    @Test
    public void createUserOrder(){
        session.saveOrUpdate(userOrder);
    }

    @AfterEach
    public void stop(){
        session.getTransaction().commit();
        session.close();
    }
}