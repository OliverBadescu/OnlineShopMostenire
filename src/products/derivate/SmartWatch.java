package products.derivate;

import products.baza.Product;
import products.service.ProductService;

public class SmartWatch extends Product {

    private int marimeBratara;

    public SmartWatch(int id, String nume, double price, int stock, int marimeBratara){
        super("SmartWatch", id, nume, price, stock);
        this.marimeBratara = marimeBratara;
    }
    public SmartWatch(String text){

        super(text);
        String[] tokens = text.split(",");
        this.marimeBratara = Integer.parseInt(tokens[5]);
    }

    public int getMarimeBratara() {return marimeBratara;}
    public void setMarimeBratara(int marimeBratara) {this.marimeBratara = marimeBratara;}

    public String descriereSmartWatch(){
        String text = super.descriere();
        text+= "Marime bratara: " + marimeBratara + "mm" +"\n";
        return text;
    }
}
