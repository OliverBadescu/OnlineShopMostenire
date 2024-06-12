package orders.service;

import orders.model.Order;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderQueryServiceImpl implements OrderQueryService{

    private ArrayList<Order> orders;

    public OrderQueryServiceImpl() {
        this.orders = new ArrayList<>();
        this.loadData();
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
    public void afisare(){

        for(int i =0; i < this.orders.size(); i++){
            System.out.println(orders.get(i).descriere());
        }

    }

    @Override
    public int generateId(){

        int id=(int) Math.round(Math.random()*1000+1);

        while (findOrderById(id)!=null){
            id=(int) Math.round(Math.random()*1000+1);
        }

        return id;

    }

    @Override
    public Order findOrderById(int id){
        for (int i =0; i < orders.size();i++){
            if(orders.get(i).getId() == id){
                return orders.get(i);
            }
        }
        return null;
    }

    @Override
    public ArrayList<Order> findOrdersByCustomerId(int id){
        ArrayList<Order> order = new ArrayList<>();

        for (int i =0; i < this.orders.size(); i++){
            if(orders.get(i).getCustomerId() == id){
                order.add(orders.get(i));
            }
        }
        return order;
    }

    @Override
    public int clientCuCeleMaiMulteComenzi(){

        int[] frec = new int[100];

        for(int i = 0; i < orders.size();i++){
            frec[orders.get(i).getCustomerId()]++;
        }
        int max = 0;
        int customer = 0;

        for(int i = 0; i < frec.length; i++){
            if(frec[i] > max){
                max = frec[i];
                customer = i;
            }
        }
        return customer;
    }

    @Override
    public String toString() {

        String text="";
        int i=0;
        for(i=0;i<this.orders.size()-1;i++){
            text+=this.orders.get(i)+"\n";
        }
        return text+=this.orders.get(i);
    }


}
