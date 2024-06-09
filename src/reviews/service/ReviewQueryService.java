package reviews.service;

import reviews.model.Review;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public interface ReviewQueryService {

    void loadData();

    String toString();

    void afisare();

    int generateId();

    Review findReviewById(int id);

    double calculareRating(ArrayList<Review> reviews);

    ArrayList<Review> getReviewsProduct(int productId);

    int getNrReviews(ArrayList<Review> reviews);

    ArrayList<Review> getReviewsByTitle(String title);


}
