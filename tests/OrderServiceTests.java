import orders.model.Order;
import orders.service.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class OrderServiceTests {

    ArrayList<Order> orders = new ArrayList<>();
    OrderQueryService orderQueryService;
    OrderCommandService orderCommandService;

    @Test

    public void GivenAvailableDataCheckIfGetsLoaded(){

        orderQueryService = new OrderQueryServiceImpl(orders);
        orderCommandService = new OrderCommandServiceImpl(orders);

        Order order = orderQueryService.findOrderById(1);

        assertEquals(1, order.getId());

    }

    @Test

    public void AfisareSiGenerare(){

        Order order = new Order(1,1,999.99);
        orders.add(order);
        orderQueryService = new OrderQueryServiceImpl(orders);
        orderCommandService = new OrderCommandServiceImpl(orders);

        orderQueryService.afisare();
        int id = orderQueryService.generateId();


    }

    @Test

    public void GivenAvailableIdCheckIfGetsFound(){

        Order order = new Order(1,1,999.99);
        orders.add(order);
        orderQueryService = new OrderQueryServiceImpl(orders);
        orderCommandService = new OrderCommandServiceImpl(orders);

        Order order1 = orderQueryService.findOrderById(1);
        Order order2 = orderQueryService.findOrderById(2);

        assertEquals(1, order1.getId());
        assertNull(order2);

    }

    @Test

    public void GivenAvailableOrderCheckIfGetsAdded(){

        Order order = new Order(1,1,999.99);
        orderQueryService = new OrderQueryServiceImpl(orders);
        orderCommandService = new OrderCommandServiceImpl(orders);

        orderCommandService.add(order);

        assertEquals(1, order.getId());

    }

    @Test

    public void GivenAvailableCustomerIdCheckIfOrdersGetFound(){


        Order order = new Order(1,1,999.99);
        Order order1 = new Order(2,1,999.99);
        orders.add(order);
        orders.add(order1);
        orderQueryService = new OrderQueryServiceImpl(orders);
        orderCommandService = new OrderCommandServiceImpl(orders);

        ArrayList<Order> orders1 = orderQueryService.findOrdersByCustomerId(1);

        assertEquals(1, orders1.get(0).getId());

    }

    @Test

    public void GivenAvailableOrderCheckIfGetsDeleted(){

        Order order = new Order(1,1,999.99);
        orders.add(order);
        orderQueryService = new OrderQueryServiceImpl(orders);
        orderCommandService = new OrderCommandServiceImpl(orders);

        orderCommandService.stergeComanda(order);

        assertNull(orderQueryService.findOrderById(1));

    }

    @Test

    public void ClientCuCeleMaiMulteComenzi(){

        Order order = new Order(1,1,999.99);
        orders.add(order);
        orderQueryService = new OrderQueryServiceImpl(orders);
        orderCommandService = new OrderCommandServiceImpl(orders);

        int id = orderQueryService.clientCuCeleMaiMulteComenzi();

        assertEquals(1, id);


    }

}
