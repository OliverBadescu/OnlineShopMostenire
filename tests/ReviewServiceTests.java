import java.util.ArrayList;
import org.junit.Test;
import reviews.model.Review;
import reviews.service.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class ReviewServiceTests {

    private ArrayList<Review> reviews = new ArrayList<>();
    private ReviewCommandService reviewCommandService;
    private ReviewQueryService reviewQueryService;

    @Test

    public void GivenAvailableIdCheckIfGetsFound(){

        ArrayList<Review> reviews = new ArrayList<>();
        Review review = new Review(1,1,"test","test",5, 0);
        reviews.add(review);
        this.reviewCommandService = new ReviewComandServiceImpl(reviews);
        this.reviewQueryService = new ReviewQueryServiceImpl(reviews);

        Review review1 = reviewQueryService.findReviewById(1);
        Review review2 = reviewQueryService.findReviewById(2);

        assertEquals(1,review1.getId());
        assertEquals(null,review2);

    }


    @Test

    public void GivenAvailableDataCheckIfGetsLoaded(){

        this.reviewCommandService = new ReviewComandServiceImpl(reviews);
        this.reviewQueryService = new ReviewQueryServiceImpl(reviews);
        Review review = reviewQueryService.findReviewById(1);

        assertEquals(1, review.getId());

    }

    @Test

    public void afisareSiGenerare(){

        ArrayList<Review> reviews = new ArrayList<>();
        Review review = new Review(1,1,"test","test",5, 0);
        reviews.add(review);
        this.reviewCommandService = new ReviewComandServiceImpl(reviews);
        this.reviewQueryService = new ReviewQueryServiceImpl(reviews);

        reviewQueryService.afisare();
        int id = reviewQueryService.generateId();

    }

    @Test

    public void GivenAvailableRatingsCheckIfTotalRatingGetsCalculated(){

        ArrayList<Review> reviews = new ArrayList<>();
        Review review = new Review(1,1,"test","test",5,0);
        this.reviewCommandService = new ReviewComandServiceImpl(reviews);
        this.reviewQueryService = new ReviewQueryServiceImpl(reviews);

        double rating = reviewQueryService.calculareRating(reviews);
        assertEquals(0,rating, 0);

        reviews.add(review);

        rating = reviewQueryService.calculareRating(reviews);

        assertEquals(5,rating,0);

    }

    @Test

    public void GivenAvailableReviewCheckIfGetsAdded(){
        ArrayList<Review> reviews = new ArrayList<>();
        Review review = new Review(1,1,"test","test",5,0);
        this.reviewCommandService = new ReviewComandServiceImpl(reviews);
        this.reviewQueryService = new ReviewQueryServiceImpl(reviews);

        reviewCommandService.adaugareReview(review);

        assertEquals(1,review.getId());
    }


    @Test

    public void GivenAvailableProductIdCheckIfReviewsGetReturned(){
        ArrayList<Review> reviews = new ArrayList<>();
        Review review = new Review(1,1,"test","test",5,0);
        Review review1 = new Review(2,2,"test","test",5,0);
        reviews.add(review);
        reviews.add(review1);
        this.reviewCommandService = new ReviewComandServiceImpl(reviews);
        this.reviewQueryService = new ReviewQueryServiceImpl(reviews);

        ArrayList<Review> products = new ArrayList<>();
        products = reviewQueryService.getReviewsProduct(1);

        assertEquals(1, products.size());


    }

    @Test

    public void GivenAvailableReviewsCheckReviewsNumber(){
        ArrayList<Review> reviews = new ArrayList<>();
        Review review = new Review(1,1,"test","test",5,0);
        Review review1 = new Review(2,2,"test","test",5,0);
        reviews.add(review);
        reviews.add(review1);
        this.reviewCommandService = new ReviewComandServiceImpl(reviews);
        this.reviewQueryService = new ReviewQueryServiceImpl(reviews);

        int nr = reviewQueryService.getNrReviews(reviews);

        assertEquals(2,nr);

    }

    @Test

    public void GivenAvailableReviewTitleCheckIfGetsFound(){
        ArrayList<Review> reviews = new ArrayList<>();
        Review review = new Review(1,1,"test","test",5,0);
        Review review1 = new Review(2,2,"test1","test",5,0);
        reviews.add(review);
        reviews.add(review1);
        this.reviewCommandService = new ReviewComandServiceImpl(reviews);
        this.reviewQueryService = new ReviewQueryServiceImpl(reviews);

        ArrayList<Review> test = reviewQueryService.getReviewsByTitle("test");
        assertEquals(1, test.size());

    }

    @Test

    public void GivenAvailableReviewCheckIfGetsDeleted(){

        ArrayList<Review> reviews = new ArrayList<>();
        Review review = new Review(1,1,"test","test",5,0);
        Review review1 = new Review(2,2,"test1","test",5,0);
        reviews.add(review);
        reviews.add(review1);
        this.reviewCommandService = new ReviewComandServiceImpl(reviews);
        this.reviewQueryService = new ReviewQueryServiceImpl(reviews);

        reviewCommandService.stergeReview(review);

        assertEquals(null,reviewQueryService.findReviewById(1));

    }


}
