package products.derivate;

import products.baza.Product;

public class Laptop extends Product {

    private int ram;
    private String procesor;
    private String placaVideo;
    private int dimensiune;

    public Laptop(int id, String name,double pret, int stock, int ram, String procesor, String placaVideo, int dimensiune) {
        super("Laptop", id, name, pret, stock);
        this.ram = ram;
        this.procesor = procesor;
        this.placaVideo = placaVideo;
        this.dimensiune = dimensiune;
    }

    public Laptop(String text){
        super(text);
        String[] tokens = text.split(",");
        this.ram = Integer.parseInt(tokens[5]);
        this.procesor = tokens[6];
        this.placaVideo = tokens[7];
        this.dimensiune = Integer.parseInt(tokens[8]);
    }

    public int getRam() {return this.ram;}
    public void setRam(int ram) {this.ram = ram;}
    public String getProcesor() {return this.procesor;}
    public void setProcesor(String procesor) {this.procesor = procesor;}
    public String getPlacaVideo() {return this.placaVideo;}
    public void setPlacaVideo(String placaVideo) {this.placaVideo = placaVideo;}
    public int getDimensiune() {return this.dimensiune;}
    public void setDimensiune(int dimensiune) {this.dimensiune = dimensiune;}

    public String descriereLaptop(){

        String text = super.descriere();
        text += "Ram: " + this.ram + "GB" + "\n";
        text += "Procesor: " + this.procesor + "\n";
        text += "Placa Video: " + this.placaVideo + "\n";
        text += "Dimensiune: " + this.dimensiune + "in" + "\n";
        return text;

    }



}
