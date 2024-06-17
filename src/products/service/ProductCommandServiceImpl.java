package products.service;

import products.models.*;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductCommandServiceImpl implements ProductCommandService {

    private ArrayList<Product> products;
    private ProductsFileManager productsFileManager;


    public ProductCommandServiceImpl() {
        this.products = new ArrayList<>();
        this.productsFileManager = new ProductsFileManager();
        this.loadData();
    }

    @Override
    public void loadData() {
        products.clear();
        try {
            String filePath = "C:\\mycode\\java\\mostenire\\OnlineShopMostenire\\src\\products\\data\\products.txt";
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                switch (line.split(",")[0]) {
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
                    default:
                        System.out.println("Unknown product type: " + line.split(",")[0]);
                        break;
                }
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveData() {
        productsFileManager.saveData();
    }

    @Override
    public void stergeProdus(Product product) {
        boolean removed = this.products.remove(product);
        if (removed) {
            System.out.println("Product removed: " + product);
        } else {
            System.out.println("Product not found: " + product);
        }
        saveData();
    }

    @Override
    public void adaugareProdus(Product product) {
        this.products.add(product);
        saveData();
    }

    @Override
    public void promoCraciun() {
        for (Product product : products) {
            product.setPrice(product.getPrice() * 0.5);
        }
        saveData();
    }

    @Override
    public void promoPaste() {
        for (Product product : products) {
            product.setPrice(product.getPrice() * 0.3);
        }
        saveData();
    }

    @Override
    public void anularePromoCraciun() {
        for (Product product : products) {
            product.setPrice(product.getPrice() * 2);
        }
        saveData();
    }

    @Override
    public void anularePromoPaste() {
        for (Product product : products) {
            product.setPrice(product.getPrice() / 0.7);
        }
        saveData();
    }
}
