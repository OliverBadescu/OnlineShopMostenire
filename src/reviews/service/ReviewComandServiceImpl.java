package reviews.service;

import reviews.model.Review;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ReviewComandServiceImpl implements ReviewCommandService{


    private ArrayList<Review> reviews;


    public ReviewComandServiceImpl() {
        this.reviews = new ArrayList<>();
        this.loadData();
    }

    @Override
    public void loadData(){

        try{
            String filePath="C:\\mycode\\java\\mostenire\\OnlineShopMostenire\\src\\reviews\\data\\reviews.txt";
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                Review review = new Review(line);

                this.reviews.add(review);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

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
