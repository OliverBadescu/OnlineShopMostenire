
package reviews.service;

import orders.model.Order;
import orders.service.Data;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ReviewsFileManager implements Data {

    private ArrayList<Order> orders = new ArrayList<>();


    @Override
    public void saveData(){
        String filePath="C:\\mycode\\java\\mostenire\\OnlineShopMostenire\\src\\reviews\\data\\reviews.txt";
        try (FileWriter fileWriter = new FileWriter(filePath, false);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            for (Order order : orders) {
                printWriter.println(order.toString());
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

                Order order = new Order(line);

                this.orders.add(order);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
