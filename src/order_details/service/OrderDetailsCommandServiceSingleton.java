package order_details.service;

public class OrderDetailsCommandServiceSingleton {

    private static class LazzyHolder{

        private  static final OrderDetailsCommandService INSTANCE=new OrderDetailsCommandServiceImpl();
    }

    private OrderDetailsCommandServiceSingleton(){

    }

    public static OrderDetailsCommandService getInstance(){
        return  OrderDetailsCommandServiceSingleton.LazzyHolder.INSTANCE;
    }

}
