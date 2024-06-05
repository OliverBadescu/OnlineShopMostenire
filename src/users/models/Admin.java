package users.models;

public class Admin extends Users {

    private String grad;
    public Admin(int id, String username, String password, String grad){

        super("Admin",id, username, password);
        this.grad = grad;


    }

    public Admin(String text){
        super(text);
        String[] tokens = text.split(",");
        this.grad = tokens[4];
    }

    @Override
    public String descriere(){

        String text = super.descriere();

        text += "Grad: " + this.grad + "\n";
        return text;

    }

    @Override

    public String toString(){
        return super.toString()+"," + grad;
    }
}
