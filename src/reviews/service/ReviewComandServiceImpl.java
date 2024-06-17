package reviews.service;

import reviews.model.Review;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ReviewComandServiceImpl implements ReviewCommandService{


    private ArrayList<Review> reviews;
    private ReviewsFileManager reviewsFileManager;


    public ReviewComandServiceImpl() {
        this.reviews = new ArrayList<>();
        this.reviewsFileManager = new ReviewsFileManager();
        reviewsFileManager.loadData();
    }

    @Override
    public void loadData(){

        reviewsFileManager.loadData();

    }


    @Override
    public void saveData(){
        reviewsFileManager.saveData();

    }

    @Override
    public void stergeReview(Review review){
        this.reviews.remove(review);
        reviewsFileManager.saveData();
    }

    @Override
    public void adaugareReview(Review review){
        this.reviews.add(review);
        reviewsFileManager.saveData();
    }
}
