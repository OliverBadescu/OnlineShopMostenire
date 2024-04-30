package users.derivate;

import users.baza.Users;

public class Admin extends Users {

    public Admin(int id, String username, String password){

        super("Admin",id, username, password);


    }

    public Admin(String text){
        super(text);
    }

    public String descriereAdmin(){

        return super.descriere();

    }
}
