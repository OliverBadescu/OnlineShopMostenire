package newspaper.service;

import order_details.service.OrderDetailsCommandService;
import order_details.service.OrderDetailsCommandServiceImpl;
import order_details.service.OrderDetailsCommandServiceSingleton;

public class NewspaperCommandServiceSingleton {

    private static class LazzyHolder{

        private  static final NewspaperCommandService INSTANCE=new NewspaperCommandServiceImpl();
    }

    private NewspaperCommandServiceSingleton(){

    }

    public static NewspaperCommandService getInstance(){
        return  NewspaperCommandServiceSingleton.LazzyHolder.INSTANCE;
    }

}
