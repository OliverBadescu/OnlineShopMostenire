package newspaper.model;

public class Newspaper {

    private int id;
    public String oferte;

    public Newspaper(String oferte,int id) {
        this.oferte = oferte;
        this.id = id;
    }

    public Newspaper(String text){

        String[] tokens = text.split(",");
        this.id = Integer.parseInt(tokens[0]);
        this.oferte = tokens[1];

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getOferte() {
        return oferte;
    }
    public void setOferte(String oferte) {
        this.oferte = oferte;
    }

    public String descriere(){

        String txt = "";

        txt += "Ofertele sunt: " + this.oferte + "\n";

        return txt;

    }

    @Override
    public String toString(){
        return id + "," + oferte;
    }
}
