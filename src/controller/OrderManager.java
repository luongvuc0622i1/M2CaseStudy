package controller;

import controller.comparator.comparatorBook.BookIdComparator;
import controller.comparator.comparatorOrder.OrderBookComparator;
import controller.comparator.comparatorOrder.OrderIdComparator;
import controller.comparator.comparatorOrder.OrderMemberComparator;
import model.book.Book;
import model.order.Order;
import storage.IGenericReadWriteData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class OrderManager {
    private static IGenericReadWriteData readWriteData = storage.order_ReadWriteData.ReadWriteFileExcel.getInstance();
    public static List<Order> orderList = new ArrayList<>();

    public OrderManager() {
    }

    public void addNewOrder(Order order) {
        orderList = readWriteData.readData();
        orderList.add(order);
        readWriteData.writeData(orderList);
    }

    public void copyOrderList(String pathIn, String pathOut) {
        orderList = readWriteData.readData(pathIn);
        readWriteData.writeData(orderList, pathOut);
    }

    public void editOrderById(int index, Order order) {
        orderList = readWriteData.readData();
        orderList.set(index, order);
        readWriteData.writeData(orderList);
    }

    public void removeOrderByOrderId(String orderId) {
        orderList = readWriteData.readData();
        int index = -1;
        for (int i = 0; i < orderList.size(); i++) {
            if (orderId.equals(orderList.get(i).getOrderId())) {
                index = i;
            }
        }
        orderList.remove(index);
        readWriteData.writeData(orderList);
    }

    public void sortById() {
        orderList = readWriteData.readData();
        System.out.println("Sắp xếp theo thuộc tính id:");
        Collections.sort(orderList, new OrderIdComparator());
        for (Order order : orderList) {
            System.out.println(order);
        }
    }

    public void sortByBook() {
        orderList = readWriteData.readData();
        System.out.println("Sắp xếp theo thuộc tính book:");
        Collections.sort(orderList, new OrderBookComparator());
        for (Order order : orderList) {
            System.out.println(order);
        }
    }

    public void sortByMember() {
        orderList = readWriteData.readData();
        System.out.println("Sắp xếp theo thuộc tính member:");
        Collections.sort(orderList, new OrderMemberComparator());
        for (Order order : orderList) {
            System.out.println(order);
        }
    }

    public List<Order> displayCheckTime(Date checkTime) {
        orderList = readWriteData.readData();
        List<Order> orderCheckList = new ArrayList<>();
        for (int i = 0 ; i < orderList.size(); i++) {
            if (orderList.get(i).getEndTime().compareTo(checkTime) < 0) {
                orderCheckList.add(orderList.get(i));
            }
        }
        return orderCheckList;
    }

    public void display() {
        orderList = readWriteData.readData();
        if(orderList.isEmpty()){
            System.out.println("Chưa có phiếu mượn nào!");
        } else {
            for (Order order : orderList) {
                System.out.println(order);
            }
        }
    }
}
