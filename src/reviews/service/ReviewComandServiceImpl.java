package reviews.service;

import orders.model.Order;
import reviews.model.Review;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ReviewComandServiceImpl implements ReviewCommandService{


    private ArrayList<Review> reviews;

    public ReviewComandServiceImpl(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public void saveData(){
        String filePath="C:\\mycode\\java\\mostenire\\OnlineShopMostenire\\src\\reviews\\data\\reviews.txt";
        try (FileWriter fileWriter = new FileWriter(filePath, false);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            for (Review review : reviews) {
                printWriter.println(review.toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public void stergeReview(Review review){
        this.reviews.remove(review);
        saveData();
    }

    @Override
    public void adaugareReview(Review review){
        this.reviews.add(review);
        saveData();
    }
}
