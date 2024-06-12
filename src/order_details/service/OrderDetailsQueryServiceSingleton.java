package order_details.service;

public class OrderDetailsQueryServiceSingleton {

    private static class LazzyHolder{

        private  static final OrderDetailsQueryService INSTANCE=new OrderDetailsQueryServiceImpl();
    }

    private OrderDetailsQueryServiceSingleton(){

    }

    public static OrderDetailsQueryService getInstance(){
        return  OrderDetailsQueryServiceSingleton.LazzyHolder.INSTANCE;
    }

}
