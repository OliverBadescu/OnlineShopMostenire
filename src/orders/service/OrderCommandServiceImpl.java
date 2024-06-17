package orders.service;

import order_details.model.OrderDetails;
import order_details.service.OrderDetailsQueryServiceImpl;
import orders.model.Order;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderCommandServiceImpl implements OrderCommandService {
    private ArrayList<Order> orders;
    private OrderFileManager orderFileManager;

    public OrderCommandServiceImpl() {
        this.orderFileManager = new OrderFileManager();
        this.orders = new ArrayList<>();
        orderFileManager.loadData();
    }

    @Override
    public void add(Order order) {
        this.orders.add(order);
        orderFileManager.saveData();
    }

    @Override
    public void stergeComanda(Order order) {
        this.orders.remove(order);
        orderFileManager.saveData();
    }

    @Override
    public void loadData() {
        orderFileManager.loadData();
    }

    @Override
    public void saveData() {
        orderFileManager.saveData();
    }

}
