package products.models;

import java.util.Objects;

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

    @Override
    public String descriere(){
        String text = super.descriere();
        text+= "Marime bratara: " + marimeBratara + "mm" +"\n";
        return text;
    }

    @Override
    public String toString(){
        return super.toString() +"," + marimeBratara;
    }

    @Override
    public boolean equals(Object o){

        return super.equals(o);
    }

}
