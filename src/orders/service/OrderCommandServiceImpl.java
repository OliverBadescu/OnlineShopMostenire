package orders.service;
import orders.model.Order;


import java.util.ArrayList;

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
