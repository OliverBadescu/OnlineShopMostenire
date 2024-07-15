package appearance.service;

import order_details.service.OrderDetailsQueryService;
import order_details.service.OrderDetailsQueryServiceImpl;
import order_details.service.OrderDetailsQueryServiceSingleton;

public class AppearanceServiceSingleton {

    private static class LazzyHolder{

        private  static final AppearanceService INSTANCE=new AppearanceServiceImpl();
    }

    private AppearanceServiceSingleton(){

    }

    public static AppearanceService getInstance(){
        return  AppearanceServiceSingleton.LazzyHolder.INSTANCE;
    }

}
