package users.models;

public class Users {

    private String type;
    private int id;
    private String username;
    private String password;


    public Users(String type, int id, String username, String password){
        this.type = type;
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Users(String text){
        String[] tokens =text.split(",");
        this.type = tokens[0];
        this.id = Integer.parseInt(tokens[1]);
        this.username = tokens[2];
        this.password = tokens[3];
    }

    public String getType(){return this.type;}
    public void setType(String type){this.type = type;}
    public int getId(){return this.id;}
    public void setId(int id){this.id = id;}
    public String getUsername(){return this.username;}
    public void setUsername(String username){this.username = username;}
    public String getPassword(){return this.password;}
    public void setPassword(String password){this.password = password;}

    public String descriere(){

        String text = "";
        text+= "Id: " + this.id + "\n";
        text+= "Username: " + this.username + "\n";
        text += "Password: " + this.password + "\n";
        return text;
    }

    @Override

    public String toString(){

        return type +"," + id + "," +username +"," +password;

    }
}
