package order_details.service;

import order_details.model.OrderDetails;
import orders.model.Order;

import java.util.ArrayList;

public interface OrderDetailsQueryService {

    void loadData();

    int generateId();

    OrderDetails findOrderDetailsById(int id);

    void afisare();

    ArrayList<OrderDetails> orderList(ArrayList<Order> list);

    int celMaiVandutProdus();

    ArrayList<OrderDetails> getOrderDetails();


     String toString();

}
