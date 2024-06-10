package users.service;

import reviews.model.Review;
import users.models.Admin;
import users.models.Customer;
import users.models.Users;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class UserCommandServiceImpl implements UserCommandService{

    private ArrayList<Users> users;


    public UserCommandServiceImpl(ArrayList<Users> users) {
        this.users = users;
    }

    @Override
    public void saveData(){
        String filePath="C:\\mycode\\java\\mostenire\\OnlineShopMostenire\\src\\users\\data\\data.txt";
        try (FileWriter fileWriter = new FileWriter(filePath, false);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            for (Users users1 : users) {
                printWriter.println(users1.toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public void stergeCont(Customer customer) {

        this.users.remove(customer);
        saveData();
    }

    @Override
    public boolean inregistrareCustomer(Customer customer){
        for(int i =0 ; i < users.size();i++){
            if(users.get(i) instanceof Customer c){
                if(c.getUsername().equals(customer.getUsername())){
                    return false;
                }
            }
        }
        users.add(customer);
        return true;
    }

    @Override
    public boolean adaugareAdmin(Admin admin){

        for(int i= 0 ; i < users.size();i++){
            if(users.get(i) instanceof Admin a){
                if(a.getUsername().equals(admin.getUsername())){
                    return false;
                }
            }
        }
        users.add(admin);
        return true;

    }
}
