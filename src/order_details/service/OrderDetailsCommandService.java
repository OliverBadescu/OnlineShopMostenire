package order_details.service;

import order_details.model.OrderDetails;

public interface OrderDetailsCommandService {

    void loadData();

    void adaugare(OrderDetails order);

    void saveData();

}
