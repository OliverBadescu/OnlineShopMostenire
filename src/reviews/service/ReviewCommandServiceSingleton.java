package reviews.service;

public class ReviewCommandServiceSingleton {

    private static class LazzyHolder{

        private  static final ReviewCommandService INSTANCE=new ReviewComandServiceImpl();
    }

    private ReviewCommandServiceSingleton(){

    }

    public static ReviewCommandService getInstance(){
        return  ReviewCommandServiceSingleton.LazzyHolder.INSTANCE;
    }

}
