package orders.service;

public class OrderQueryServiceSingleton {

    private static class LazzyHolder{

        private  static final OrderQueryService INSTANCE=new OrderQueryServiceImpl();
    }

    private OrderQueryServiceSingleton(){

    }

    public static OrderQueryService getInstance(){
        return  OrderQueryServiceSingleton.LazzyHolder.INSTANCE;
    }

}
