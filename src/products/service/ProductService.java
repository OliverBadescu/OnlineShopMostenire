package products.service;

import products.baza.Product;
import products.derivate.Laptop;
import products.derivate.Monitor;
import products.derivate.SmartWatch;
import products.derivate.Telefon;
import users.baza.Users;
import users.derivate.Admin;
import users.derivate.Customer;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductService {

    private ArrayList<Product> products;

    public ProductService() {
        this.products = new ArrayList<>();
        this.loadData();
    }

    private void loadData() {


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

                Product product = new Product(line);

                this.products.add(product);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public void afisare(){

        for(int i =0; i < this.products.size(); i++){
            if(products.get(i) instanceof Laptop l){
                System.out.println(l.descriereLaptop());
                System.out.println("\n");
            }
            else if(products.get(i) instanceof Monitor m){
                System.out.println(m.descriereMonitor());
                System.out.println("\n");
            }
            else if(products.get(i) instanceof SmartWatch s){
                System.out.println(s.descriereSmartWatch());
                System.out.println("\n");
            }
            else if(products.get(i) instanceof Telefon t){
                System.out.println(t.descriereTelfon());
                System.out.println("\n");
            }
        }

    }

    public void afisareTelefoane(){
        for(int i =0; i < this.products.size(); i++){
            if(products.get(i) instanceof Telefon t){
                System.out.println(t.descriereTelfon());
                System.out.println("\n");
            }
        }
    }
    public void afisareLaptopuri(){
        for(int i =0; i < this.products.size(); i++){
            if(products.get(i) instanceof Laptop l){
                System.out.println(l.descriereLaptop());
                System.out.println("\n");
            }
        }
    }
    public void afisareMonitor(){
        for(int i =0; i < this.products.size(); i++){
            if(products.get(i) instanceof Monitor m){
                System.out.println(m.descriereMonitor());
                System.out.println("\n");
            }
        }
    }
    public void afisareSmartWatch(){
        for(int i =0; i < this.products.size(); i++){
            if(products.get(i) instanceof SmartWatch s){
                System.out.println(s.descriereSmartWatch());
                System.out.println("\n");
            }
        }
    }

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

    public int generateId(){

        int id=(int) Math.round(Math.random()*1000+1);

        while (findProductById(id)!=null){
            id=(int) Math.round(Math.random()*1000+1);
        }

        return id;

    }

    public Product findProductById(int id){
        for (int i =0; i < products.size();i++){
            if(products.get(i).getId() == id){
                return products.get(i);
            }
        }
        return null;
    }

    public Product findByName(String name){
        for(int i =0; i < products.size();i++){
            if(products.get(i).getName().equals(name)){
                return products.get(i);
            }
        }
        return null;
    }

}
