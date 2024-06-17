package order_details.service;

import order_details.model.OrderDetails;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderDetailsCommandServiceImpl implements OrderDetailsCommandService {

    private ArrayList<OrderDetails> orderDetails;
    private OrderDetailsFileManager orderDetailsFileManager;

    public OrderDetailsCommandServiceImpl() {
        this.orderDetails = new ArrayList<>();
        this.orderDetailsFileManager = new OrderDetailsFileManager();
        this.loadData();
    }

    @Override
    public void loadData() {
        orderDetailsFileManager.loadData();
    }

    @Override
    public void adaugare(OrderDetails order){
        this.orderDetails.add(order);
        orderDetailsFileManager.saveData();
    }

    @Override
    public void saveData(){
        orderDetailsFileManager.saveData();
    }

}
