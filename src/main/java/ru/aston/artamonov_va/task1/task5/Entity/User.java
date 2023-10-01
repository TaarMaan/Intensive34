package ru.aston.artamonov_va.task1.task5.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.aston.artamonov_va.task1.task5.BirthdayConvector;

import java.util.List;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Builder
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "age")
    private int age;

    @Column(name = "birthday")
    @Convert(converter = BirthdayConvector.class)
    private Birthday birthday;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "order_type")
    @Enumerated(value = EnumType.STRING)
    private OrderType orderType;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders;
}
