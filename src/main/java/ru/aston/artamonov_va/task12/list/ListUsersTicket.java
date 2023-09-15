package ru.aston.artamonov_va.task12.list;

import lombok.AllArgsConstructor;
import lombok.ToString;
import ru.aston.artamonov_va.task12.RailWayTicket;
import ru.aston.artamonov_va.task12.TicketCalculation;
import ru.aston.artamonov_va.task12.list.comparator.TicketComparator;

import java.math.BigDecimal;
import java.util.List;

@ToString
@AllArgsConstructor
public class ListUsersTicket implements TicketCalculation {
    private final List<RailWayTicket> railWayTicketList;

    //Подсчет суммы по перевозкам
    @Override
    public BigDecimal calcTransportationAmount() {
        BigDecimal TransportationAmount = new BigDecimal("0");

        for (RailWayTicket railWayTicket : railWayTicketList) {
            TransportationAmount = TransportationAmount
                    .add(railWayTicket.getSumTransportation());
        }
        return TransportationAmount;
    }

    //Вывод отсортированного списка поездок
    public List<RailWayTicket> sortList() {
        TicketComparator ticketComparator = new TicketComparator();
        railWayTicketList.sort(ticketComparator);
        return railWayTicketList;
    }

}
