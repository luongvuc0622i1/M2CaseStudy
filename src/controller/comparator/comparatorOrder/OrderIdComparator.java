package controller.comparator.comparatorOrder;

import model.member.Member;
import model.order.Order;

import java.util.Comparator;

public class OrderIdComparator implements Comparator<Order> {
    @Override
    public int compare(Order o1, Order o2) {
        return o1.getOrderId().compareTo(o2.getOrderId());
    }
}
