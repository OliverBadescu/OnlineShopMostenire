package products.service;

public class ProductQueryServiceSingleton {

    private static class LazzyHolder{

        private  static final ProductQueryService INSTANCE=new ProductQueryServiceImpl();
    }

    private ProductQueryServiceSingleton(){

    }

    public static ProductQueryService getInstance(){
        return  ProductQueryServiceSingleton.LazzyHolder.INSTANCE;
    }

}
