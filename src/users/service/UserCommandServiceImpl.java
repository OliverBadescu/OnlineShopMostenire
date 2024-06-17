package users.service;

import reviews.model.Review;
import reviews.service.ReviewQueryServiceImpl;
import users.models.Admin;
import users.models.Customer;
import users.models.Users;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class UserCommandServiceImpl implements UserCommandService{

    private ArrayList<Users> users;
    private UsersFileManager usersFileManager;

    public UserCommandServiceImpl() {

        this.users= new ArrayList<>();
        this.usersFileManager = new UsersFileManager();
        this.loadData();
    }

    @Override
    public void loadData(){

        try{
            String filePath="C:\\mycode\\java\\mostenire\\OnlineShopMostenire\\src\\users\\data\\data.txt";
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                switch (line.split(",")[0]){

                    case "Admin":
                        Admin admin = new Admin(line);
                        this.users.add(admin);
                        break;
                    case "Customer":
                        Customer customer = new Customer(line);
                        this.users.add(customer);
                        break;
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void saveData(){
        usersFileManager.saveData();

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
