package orders.service;

import order_details.model.OrderDetails;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderFileManager implements Data {

    private ArrayList<OrderDetails> orderDetails = new ArrayList<>();


    @Override
    public void saveData(){
        String filePath="C:\\mycode\\java\\mostenire\\OnlineShopMostenire\\src\\orders\\data\\orders.txt";
        try (FileWriter fileWriter = new FileWriter(filePath, false);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            for (OrderDetails order : orderDetails) {
                printWriter.println(order.toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public void loadData() {
        try{
            String filePath="C:\\mycode\\java\\mostenire\\OnlineShopMostenire\\src\\orders\\data\\orders.txt";
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                OrderDetails order = new OrderDetails(line);

                this.orderDetails.add(order);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
