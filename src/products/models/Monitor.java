package products.models;

import java.util.Objects;

public class Monitor extends Product {
    private int hz;
    private double dimensiune;

    public Monitor(int id, String nume, double pret, int stock, int hz, double dimensiune) {
        super("Monitor", id, nume, pret, stock);
        this.hz = hz;
        this.dimensiune = dimensiune;
    }

    public Monitor(String text){
        super(text);
        String[] tokens = text.split(",");
        this.hz = Integer.parseInt(tokens[5]);
        this.dimensiune = Double.parseDouble(tokens[6]);
    }

    public int getHz() {return this.hz;}
    public void setHz(int hz) {this.hz = hz;}
    public double getDimensiune() {return this.dimensiune;}
    public void setDimensiune(double dimensiune) {this.dimensiune = dimensiune;}


    @Override
    public String descriere(){

        String text = super.descriere();
        text += "Hz: " + this.hz + "\n";
        text += "Dimensiune: " + this.dimensiune + "in" + "\n";
        return text;

    }

    @Override

    public String toString(){
        return super.toString() + "," + hz + "," + dimensiune;
    }

    @Override
    public boolean equals(Object o){

        return super.equals(o);
    }

}
