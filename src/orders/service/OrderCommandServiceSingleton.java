package orders.service;

import users.service.UserCommandService;
import users.service.UserCommandServiceImpl;
import users.service.UserCommandServiceSingleton;

public class OrderCommandServiceSingleton {

    private static class LazzyHolder{

        private  static final OrderCommandService INSTANCE=new OrderCommandServiceImpl();
    }

    private OrderCommandServiceSingleton(){

    }

    public static OrderCommandService getInstance(){
        return  OrderCommandServiceSingleton.LazzyHolder.INSTANCE;
    }

}
