package products.models;

import java.util.Objects;

public class Product {

    private String type;
    private int id;
    private String name;
    private double price;
    private int stock;

    public Product(String type, int id, String name, double price, int stock) {
        this.type = type;
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Product(String text){

        String[] tokens = text.split(",");
        this.type = tokens[0];
        this.id = Integer.parseInt(tokens[1]);
        this.name = tokens[2];
        this.price = Double.parseDouble(tokens[3]);
        this.stock = Integer.parseInt(tokens[4]);

    }

    public String getType() {return this.type;}
    public void setType(String type) { this.type = type; }
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}
    public int getStock() {return stock;}
    public void setStock(int stock) {this.stock = stock;}


    
    public String descriere(){

        String text = "";

        text+= "Id: " + this.id + "\n";
        text+= "Name: " + this.name + "\n";
        text+= "Price: " + this.price + "\n";
        text+= "Stock: " + this.stock + "\n";
        return text;

    }

    @Override
    public String toString(){
        return type + "," + id +"," +name + "," +price + "," + stock;
    }

    @Override
    public boolean equals(Object o) {

        Product product =(Product) o;

        return this.id==product.id;

    }


}
