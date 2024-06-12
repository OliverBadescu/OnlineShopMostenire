package reviews.service;

import reviews.model.Review;
import users.service.UserCommandService;
import users.service.UserCommandServiceImpl;
import users.service.UserCommandServiceSingleton;

public class ReviewQueryServiceSingleton {

    private static class LazzyHolder{

        private  static final ReviewQueryService INSTANCE=new ReviewQueryServiceImpl();
    }

    private ReviewQueryServiceSingleton(){

    }

    public static ReviewQueryService getInstance(){
        return  ReviewQueryServiceSingleton.LazzyHolder.INSTANCE;
    }

}
