package reviews.service;

import reviews.model.Review;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ReviewQueryServiceImpl implements ReviewQueryService{

    private ArrayList<Review> reviews;
    private ReviewsFileManager reviewsFileManager;


    public ReviewQueryServiceImpl() {
        this.reviews = new ArrayList<>();
        this.reviewsFileManager = new ReviewsFileManager();
        this.loadData();
    }

    @Override
    public ArrayList<Review> getReviewsProduct(int productId){

        ArrayList<Review> productReviews = new ArrayList<>();

        for(int i =0; i < this.reviews.size(); i++){
            if(this.reviews.get(i).getProductId() == productId){
                productReviews.add(this.reviews.get(i));
            }
        }
        return productReviews;
    }

    @Override
    public int getNrReviews(ArrayList<Review> reviews){
        int ct =0;

        for(int i =0; i < reviews.size(); i++){
            ct++;
        }
        return ct;
    }

    @Override
    public ArrayList<Review> getReviewsByTitle(String title){

        ArrayList<Review> reviews = new ArrayList<>();
        for(int i =0; i < this.reviews.size(); i++){
            if(this.reviews.get(i).getTitle().equals(title)){
                reviews.add(this.reviews.get(i));
            }
        }
        return reviews;
    }

    @Override
    public void afisare(){

        for(int i =0; i < this.reviews.size(); i++){
            System.out.println(reviews.get(i).descriere());
        }

    }

    @Override
    public int generateId(){

        int id=(int) Math.round(Math.random()*1000+1);

        while (findReviewById(id)!=null){
            id=(int) Math.round(Math.random()*1000+1);
        }

        return id;

    }

    @Override
    public Review findReviewById(int id){
        for (int i =0; i < reviews.size();i++){
            if(reviews.get(i).getId() == id){
                return reviews.get(i);
            }
        }
        return null;
    }

    @Override
    public double calculareRating(ArrayList<Review> reviews){

        if (reviews.isEmpty()) {
            return 0;
        }

        double ratingTotal = 0;
        int numarTotalRecenzii = 0;

        for (Review review : reviews) {
            ratingTotal += review.getRating() * (review.getNrReview() + 1);
            numarTotalRecenzii += review.getNrReview() + 1;
        }

        if (numarTotalRecenzii == 0) {
            return 0;
        }

        double ratingNou = ratingTotal / numarTotalRecenzii;

        for (Review review : reviews) {
            review.setNrReview(numarTotalRecenzii);
        }

        return ratingNou;
    }

    @Override
    public void loadData(){

        reviewsFileManager.loadData();

    }

    @Override
    public String toString() {

        String text="";
        int i=0;
        for(i=0;i<this.reviews.size()-1;i++){
            text+=this.reviews.get(i)+"\n";
        }
        text+=this.reviews.get(i);
        return text;
    }
}