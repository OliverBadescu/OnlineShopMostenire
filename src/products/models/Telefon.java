package products.models;

import java.util.Objects;

public class Telefon extends Product {

    private String culoare;
    private int nrCamere;
    private int capacitate;

    public Telefon(int id, String name, double price,int stock, String culoare, int nrCamera, int capacitate) {
        super("Telefon", id, name, price, stock);
        this.culoare = culoare;
        this.nrCamere = nrCamera;
        this.capacitate = capacitate;
    }

    public Telefon(String text){
        super(text);
        String[] tokens = text.split(",");
        this.culoare = tokens[5];
        this.nrCamere = Integer.parseInt(tokens[6]);
        this.capacitate = Integer.parseInt(tokens[7]);
    }

    public String getCuloare() {return this.culoare;}
    public void setCuloare(String culoare) {this.culoare = culoare;}
    public int getNrCamera() {return this.nrCamere;}
    public void setNrCamere(int nrCamere){this.nrCamere = nrCamere;}
    public int getCapacitate() {return this.capacitate;}
    public void setCapacitate(int capacitate) {this.capacitate = capacitate;}


    @Override
    public String descriere(){

        String text = super.descriere();

        text += "Culoare: " + culoare + "\n";
        text += "Nr Camera: " + nrCamere + "\n";
        text += "Capacitate: " + capacitate + "GB" + "\n";
        return text;

    }

    @Override
    public String toString(){
        return super.toString() +"," +culoare +"," +nrCamere+"," +capacitate;
    }

    @Override
    public boolean equals(Object o){

        return super.equals(o);
    }
}
