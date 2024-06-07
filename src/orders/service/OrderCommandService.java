package orders.service;

import orders.model.Order;

public interface OrderCommandService {

    void loadData();

    void saveData();

    void stergeComanda(Order order);

    void add(Order order);

}
