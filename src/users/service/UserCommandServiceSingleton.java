package users.service;

public class UserCommandServiceSingleton {

    private static class LazzyHolder{

        private  static final UserCommandService INSTANCE=new UserCommandServiceImpl();
    }

    private UserCommandServiceSingleton(){

    }

    public static UserCommandService getInstance(){
        return  UserCommandServiceSingleton.LazzyHolder.INSTANCE;
    }
}
