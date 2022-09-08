package controller;

import model.order.Order;
import storage.IGenericReadWriteData;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderManager {
    private static IGenericReadWriteData readWriteData = storage.order_ReadWriteData.ReadWriteFileExcel.getInstance();
    public static List<Order> orderList = new ArrayList<>();

    public OrderManager() {
    }

    public void addNewMember(Order order) {
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

    public void removeOrderById(int index) {
        orderList = readWriteData.readData();
        orderList.remove(index);
        readWriteData.writeData(orderList);
    }

    public List<Order> displayCheckTime(Date checkTime) {
        orderList = readWriteData.readData();
        List<Order> orderCheckList = new ArrayList<>();
        boolean check = false;
        for (int i = 0 ; i < orderList.size(); i++) {
            if (orderList.get(i).getEndTime().compareTo(checkTime) < 0) {
                orderCheckList.add(orderList.get(i));
            }
        }
        return orderCheckList;
    }
}
