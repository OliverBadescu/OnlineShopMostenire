package newspaper.service;

public class NewspaperQueryServiceSingleton {

    private static class LazzyHolder{

        private  static final NewspaperQueryService INSTANCE=new NewspaperQueryServiceImpl();
    }

    private NewspaperQueryServiceSingleton(){

    }

    public static NewspaperQueryService getInstance(){
        return  NewspaperQueryServiceSingleton.LazzyHolder.INSTANCE;
    }

}
