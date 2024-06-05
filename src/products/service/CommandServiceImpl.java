package products.service;

import products.models.*;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CommandServiceImpl implements ProductCommandService{

    private ArrayList<Product> products;

    public CommandServiceImpl(){
        this.products = new ArrayList<>();

    }

    @Override
    public void loadData(){

            try{
                String filePath="C:\\mycode\\java\\mostenire\\OnlineShopMostenire\\src\\products\\data\\products.txt";
                File file = new File(filePath);
                Scanner sc = new Scanner(file);
                while (sc.hasNextLine()) {

                    String line = sc.nextLine();

                    switch (line.split(",")[0]){

                        case "Laptop":
                            Laptop laptop = new Laptop(line);
                            this.products.add(laptop);
                            break;
                        case "Monitor":
                            Monitor monitor = new Monitor(line);
                            this.products.add(monitor);
                            break;
                        case "SmartWatch":
                            SmartWatch smartWatch = new SmartWatch(line);
                            this.products.add(smartWatch);
                            break;
                        case "Telefon":
                            Telefon telefon = new Telefon(line);
                            this.products.add(telefon);
                            break;
                    }

                }
            }catch (Exception e){
                e.printStackTrace();
            }

    }

    @Override
    public void saveData(){
        String filePath="C:\\mycode\\java\\mostenire\\OnlineShopMostenire\\src\\products\\data\\products.txt";
        try{
            FileWriter fileWriter = new FileWriter(filePath);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (Product product : products) {
                printWriter.println(product.toString());
            }
            printWriter.close();
        }catch (Exception e){

            System.out.println(e);
        }

    }

    @Override
    public void stergeProdus(Product product){
        this.products.remove(product);
    }

    @Override
    public void adaugareProdus(Product product){this.products.add(product);}

    @Override
    public void promoCraciun(){
        for(int i =0 ; i < products.size(); i++){
            products.get(i).setPrice(products.get(i).getPrice() * 0.5);
        }
    }

    @Override
    public void promoPaste(){
        for(int i =0 ; i < products.size(); i++){
            products.get(i).setPrice(products.get(i).getPrice() * 0.3);
        }
    }

    @Override
    public void anularePromoCraciun(){

        for(int i =0 ; i < products.size(); i++){
            products.get(i).setPrice(products.get(i).getPrice() * 2);
        }

    }

    @Override
    public void anularePromoPaste(){

        for(int i =0 ; i < products.size(); i++){
            products.get(i).setPrice(products.get(i).getPrice() / 0.7);
        }

    }

}
