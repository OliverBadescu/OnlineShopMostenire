package users.service;

public class UserQueryServiceSingleton {

    private static class LazzyHolder{

        private  static final UserQueryService INSTANCE=new UserQueryServiceImpl();
    }

    private UserQueryServiceSingleton(){

    }

    public static UserQueryService getInstance(){
        return  LazzyHolder.INSTANCE;
    }
}
