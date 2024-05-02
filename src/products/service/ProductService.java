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

}
