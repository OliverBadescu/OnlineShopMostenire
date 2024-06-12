package order_details.service;

import order_details.model.OrderDetails;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderDetailsCommandServiceImpl implements OrderDetailsCommandService {

    private ArrayList<OrderDetails> orderDetails;

    public OrderDetailsCommandServiceImpl() {
        this.orderDetails = new ArrayList<>();
        this.loadData();
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

    @Override
    public void adaugare(OrderDetails order){
        this.orderDetails.add(order);
        saveData();
    }

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

}
