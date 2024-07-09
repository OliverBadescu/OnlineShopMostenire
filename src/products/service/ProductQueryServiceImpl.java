package products.service;

import products.models.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductQueryServiceImpl implements ProductQueryService{

    private ArrayList<Product> products;


    public ProductQueryServiceImpl(){
        this.products = new ArrayList<>();
        this.loadData();
    }



    @Override
    public void loadData() {


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
    public String toString() {
        String text="";
        int i=0;
        for(i=0;i<this.products.size()-1;i++){
            text+=this.products.get(i)+"\n";
        }
        text+=this.products.get(i);

        return text;
    }
    @Override
    public void afisare(){
        for(int i =0; i < this.products.size(); i++){
            System.out.println(products.get(i).descriere());
        }
    }
    @Override
    public void afisareTelefoane(){
        for(int i =0; i < this.products.size(); i++){
            if(products.get(i) instanceof Telefon t){
                System.out.println(t.descriere());
                System.out.println("\n");
            }
        }
    }
    @Override
    public void afisareLaptopuri(){
        for(int i =0; i < this.products.size(); i++){
            if(products.get(i) instanceof Laptop l){
                System.out.println(l.descriere());
                System.out.println("\n");
            }
        }
    }
    @Override
    public void afisareMonitor(){
        for(int i =0; i < this.products.size(); i++){
            if(products.get(i) instanceof Monitor m){
                System.out.println(m.descriere());
                System.out.println("\n");
            }
        }
    }
    @Override
    public void afisareSmartWatch(){
        for(int i =0; i < this.products.size(); i++){
            if(products.get(i) instanceof SmartWatch s){
                System.out.println(s.descriere());
                System.out.println("\n");
            }
        }
    }
    @Override
    public void sortareDupaPretCrescator(){

        boolean sortat = false;

        do {

            sortat = true;

            for (int i = 0; i < products.size()-1; i++) {

                if (products.get(i).getPrice() < products.get(i+1).getPrice()) {
                    Product temp = products.get(i);
                    products.set(i, products.get(i+1));
                    products.set(i+1, temp);
                    sortat = false;
                }

            }

        } while (!sortat);

    }
    @Override
    public void sortareDupaPretDescrescator(){

        boolean sortat = false;

        do {

            sortat = true;

            for (int i = 0; i < products.size()-1; i++) {

                if (products.get(i).getPrice() > products.get(i+1).getPrice()) {
                    Product temp = products.get(i);
                    products.set(i, products.get(i+1));
                    products.set(i+1, temp);
                    sortat = false;
                }

            }

        } while (!sortat);

    }
    @Override
    public int generateId(){

        int id=(int) Math.round(Math.random()*1000+1);

        while (findProductById(id)!=null){
            id=(int) Math.round(Math.random()*1000+1);
        }

        return id;

    }
    @Override
    public Product findProductById(int id){
        for (int i =0; i < products.size();i++){
            if(products.get(i).getId() == id){
                return products.get(i);
            }
        }
        return null;
    }
    @Override
    public Product findByName(String name){
        for(int i =0; i < products.size();i++){
            if(products.get(i).getName().equals(name)){
                return products.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean createProduct(String type){
        return switch (type) {
            case "Laptop", "Monitor", "Telefon", "SmartWatch" -> true;
            default -> false;
        };

    }


}
