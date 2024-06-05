package users.models;

public class Customer extends Users {

    private String fullName;
    private String email;
    private String billingAdress;
    private String country;
    private int phone;

    public Customer(int id, String username, String password, String fullName, String email, String billingAdress, String country, int phone){
        super("Customer", id, username,password);
        this.fullName = fullName;
        this.email = email;
        this.billingAdress = billingAdress;
        this.country = country;
        this.phone=phone;
    }

    public Customer(String text){

        super(text);
        String[] tokens = text.split(",");
        this.fullName = tokens[4];
        this.email = tokens[5];
        this.billingAdress = tokens[6];
        this.country = tokens[7];
        this.phone = Integer.parseInt(tokens[8]);

    }

    public String getFullName() {return fullName;}
    public void setFullName(String fullName) {this.fullName = fullName;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getBillingAdress() {return billingAdress;}
    public void setBillingAdress(String billingAdress) {this.billingAdress = billingAdress;}
    public String getCountry() {return country;}
    public void setCountry(String country) {this.country = country;}
    public int getPhone() {return phone;}
    public void setPhone(int phone) {this.phone = phone;}

    @Override
    public String descriere(){

        String text = super.descriere();

        text+= "Full Name: " + this.fullName + "\n";
        text+= "Email: " + this.email + "\n";
        text+= "BillingAdress: " + this.billingAdress + "\n";
        text+= "Country: " + this.country + "\n";
        text+= "Phone: " + this.phone + "\n";
        return text;

    }

    @Override

    public String toString(){
        return super.toString()+"," + fullName+","+email+","+billingAdress+","+country+","+phone;
    }
}
