package controller.comparator.comparatorOrder;

import model.order.Order;

import java.util.Comparator;

public class OrderBookComparator implements Comparator<Order> {
    @Override
    public int compare(Order o1, Order o2) {
        return o1.getBook().compareTo(o2.getBook());
    }
}
