package ru.aston.task1.task12.list.comparator;

import ru.aston.task1.task12.RailWayTicket;

import java.util.Comparator;

public class TicketComparator implements Comparator<RailWayTicket> {
    @Override
    public int compare(RailWayTicket o1, RailWayTicket o2) {
        return o1.getUser().getSourName().compareTo(o2.getUser().getSourName());
    }
}
