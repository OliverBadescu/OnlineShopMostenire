package order_details.service;

import order_details.model.OrderDetails;
import orders.service.Data;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderDetailsFileManager implements Data {

    private ArrayList<OrderDetails> orderDetails = new ArrayList<>();


    @Override
    public void saveData(){
        String filePath="C:\\mycode\\java\\mostenire\\OnlineShopMostenire\\src\\order_details\\data\\orderDetails.txt";
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
            String filePath="C:\\mycode\\java\\mostenire\\OnlineShopMostenire\\src\\order_details\\data\\orderDetails.txt";
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
