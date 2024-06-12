package products.service;

import users.service.UserCommandService;
import users.service.UserCommandServiceImpl;
import users.service.UserCommandServiceSingleton;

public class ProductCommandServiceSingleton {


    private static class LazzyHolder{

        private  static final ProductCommandService INSTANCE=new ProductCommandServiceImpl();
    }

    private ProductCommandServiceSingleton(){

    }

    public static ProductCommandService getInstance(){
        return  ProductCommandServiceSingleton.LazzyHolder.INSTANCE;
    }

}
