package order_details.service;

import order_details.model.OrderDetails;
import orders.model.Order;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderDetailsQueryServiceImpl implements OrderDetailsQueryService{

    private ArrayList<OrderDetails> orderDetails;

    public OrderDetailsQueryServiceImpl() {
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
    public int generateId(){

        int id=(int) Math.round(Math.random()*1000+1);

        while (findOrderDetailsById(id)!=null){
            id=(int) Math.round(Math.random()*1000+1);
        }

        return id;

    }

    @Override
    public OrderDetails findOrderDetailsById(int id){
        for (int i =0; i < orderDetails.size();i++){
            if(orderDetails.get(i).getId() == id){
                return orderDetails.get(i);
            }
        }
        return null;
    }

    @Override
    public void afisare(){
        for(int i =0; i<this.orderDetails.size(); i++){
            System.out.println(orderDetails.get(i).desciere());
        }
    }

    @Override
    public ArrayList<OrderDetails> orderList(ArrayList<Order> list){

        ArrayList<OrderDetails> orderList = new ArrayList<>();

        for (int i =0; i < list.size(); i++){
            for(int j =0; j < orderDetails.size(); j++){
                if(list.get(i).getId() == orderDetails.get(j).getOrderid()){
                    orderList.add(orderDetails.get(j));
                }
            }
        }
        return orderList;
    }

    @Override
    public int celMaiVandutProdus(){

        int[] produsFrec = new int[100];

        for(int i =0; i < orderDetails.size(); i++){
            produsFrec[orderDetails.get(i).getProductId()]++;
        }

        int max =0;
        int produs = 0;
        for(int i =0; i < produsFrec.length; i++){
            if(produsFrec[i] > max){
                max = produsFrec[i];
                produs = i;
            }
        }
        return produs;

    }

    @Override
    public ArrayList<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    @Override
    public String toString() {

        String text="";
        int i=0;
        for(i=0;i<this.orderDetails.size()-1;i++){
            text+=this.orderDetails.get(i)+"\n";
        }
        return  text+=this.orderDetails.get(i);
    }

}
