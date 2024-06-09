package orders.service;

import order_details.model.OrderDetails;
import orders.model.Order;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderCommandServiceImpl implements OrderCommandService{


    private ArrayList<Order> orders;

    public OrderCommandServiceImpl(ArrayList<Order> orders) {
        this.orders = orders;
    }

    @Override
    public void loadData() {
        try{
            String filePath="C:\\mycode\\java\\mostenire\\OnlineShopMostenire\\src\\orders\\data\\orders.txt";
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

    @Override
    public void add(Order order){
        this.orders.add(order);
        saveData();
    }

    @Override
    public void stergeComanda(Order order){
        this.orders.remove(order);
        saveData();
    }

    @Override
    public void saveData(){
        String filePath="C:\\mycode\\java\\mostenire\\OnlineShopMostenire\\src\\orders\\data\\orders.txt";
        try (FileWriter fileWriter = new FileWriter(filePath, false);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            for (Order order : orders) {
                printWriter.println(order.toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }


}
