package orders.service;

import orders.model.Order;

import java.util.ArrayList;

public interface OrderQueryService {

    void loadData();

    void afisare();

    int generateId();

    Order findOrderById(int id);

    ArrayList<Order> findOrdersByCustomerId(int id);

    int clientCuCeleMaiMulteComenzi();

    String toString();
}
