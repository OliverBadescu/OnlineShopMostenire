
package reviews.service;

import orders.service.Data;
import reviews.model.Review;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ReviewsFileManager implements Data {

    private ArrayList<Review> reviews = new ArrayList<>();


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
    public void loadData() {
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


}
