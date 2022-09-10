package controller.comparator.comparatorOrder;

import model.order.Order;

import java.util.Comparator;

public class OrderMemberComparator implements Comparator<Order> {
    @Override
    public int compare(Order o1, Order o2) {
        return o1.getMember().compareTo(o2.getMember());
    }
}
