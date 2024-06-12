import order_details.model.OrderDetails;
import order_details.service.OrderDetailsCommandService;
import order_details.service.OrderDetailsCommandServiceImpl;
import order_details.service.OrderDetailsQueryService;
import order_details.service.OrderDetailsQueryServiceImpl;
import orders.model.Order;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class OrderDetailsServiceTests {


    @Test

    public void GivenAvailableDataCheckIfGetsLoaded(){

        OrderDetailsCommandService orderDetailsCommandService = new OrderDetailsCommandServiceImpl();
        OrderDetailsQueryService orderDetailsQueryService = new OrderDetailsQueryServiceImpl();

        OrderDetails orderDetails = orderDetailsQueryService.findOrderDetailsById(1);

        assertEquals(1, orderDetails.getId());
    }

    @Test

    public void AfisareSiGenerare(){

        OrderDetailsCommandService orderDetailsCommandService = new OrderDetailsCommandServiceImpl();
        OrderDetailsQueryService orderDetailsQueryService = new OrderDetailsQueryServiceImpl();

        orderDetailsQueryService.afisare();
        int id = orderDetailsQueryService.generateId();


    }

    @Test

    public void GivenAvailableIdCheckIfGetsFound(){

        OrderDetailsCommandService orderDetailsCommandService = new OrderDetailsCommandServiceImpl();
        OrderDetailsQueryService orderDetailsQueryService = new OrderDetailsQueryServiceImpl();

        OrderDetails orderDetails1 = orderDetailsQueryService.findOrderDetailsById(1);
        OrderDetails orderDetails2 = orderDetailsQueryService.findOrderDetailsById(2);

        assertEquals(1, orderDetails1.getId());
        assertEquals(null, orderDetails2);

    }

    @Test

    public void GivenAvailableOrderDetialsCheckIfGetsAdded(){

        OrderDetails orderDetails1 = new OrderDetails(1,1,1,999.99,2);
        OrderDetailsCommandService orderDetailsCommandService = new OrderDetailsCommandServiceImpl();
        OrderDetailsQueryService orderDetailsQueryService = new OrderDetailsQueryServiceImpl();

        orderDetailsCommandService.adaugare(orderDetails1);

        assertEquals(1, orderDetails1.getId());

    }



    @Test
    public void CelMaiVandutProdus(){

        ArrayList<OrderDetails> orderDetailsList = new ArrayList<>();
        OrderDetails orderDetails1 = new OrderDetails(1,1,1,999.99,2);
        orderDetailsList.add(orderDetails1);
        OrderDetailsCommandService orderDetailsCommandService = new OrderDetailsCommandServiceImpl();
        OrderDetailsQueryService orderDetailsQueryService = new OrderDetailsQueryServiceImpl();

        int id =orderDetailsQueryService.celMaiVandutProdus();

        assertEquals(1, id);

    }

    @Test

    public void getOrderDetails(){

        ArrayList<OrderDetails> list = new ArrayList<>();
        OrderDetails orderDetails1 = new OrderDetails(1,1,1,999.99,2);
        list.add(orderDetails1);
        OrderDetailsCommandService orderDetailsCommandService = new OrderDetailsCommandServiceImpl();
        OrderDetailsQueryService orderDetailsQueryService = new OrderDetailsQueryServiceImpl();

        ArrayList<OrderDetails> orderDetails2 = orderDetailsQueryService.getOrderDetails();

        assertEquals(1, orderDetails2.get(0).getId());

    }
}
