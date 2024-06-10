package users.service;

import users.models.Admin;
import users.models.Customer;
import users.models.Users;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class UserQueryServiceImpl implements UserQueryService{

    private ArrayList<Users> users;

    public UserQueryServiceImpl(ArrayList<Users> users) {
        this.users = users;
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
    public String toString() {
        String text="";
        int i=0;
        for(i=0;i<this.users.size()-1;i++){
            text+=this.users.get(i)+"\n";
        }
        text+=this.users.get(i);

        return text;
    }

    @Override
    public void afisare(){

        for(int i = 0;i < users.size();i++){
            if(users.get(i) instanceof Admin a){
                System.out.println(a.descriere());
                System.out.println("\n");
            }
            if(users.get(i) instanceof Customer c){
                System.out.println(c.descriere());
                System.out.println("\n");
            }
        }

    }

    @Override
    public void afisareClient(){
        for(int i =0 ; i < users.size();i++){
            if(users.get(i) instanceof Customer c){
                System.out.println(c.descriere());
            }
        }
    }

    @Override
    public Customer findCustomerById(int id){
        for (int i =0; i < users.size();i++){
            if(users.get(i) instanceof Customer c){
                if(c.getId() == id){
                    return c;
                }
            }
        }
        return null;
    }

    @Override
    public int generateId(){

        int id=(int) Math.round(Math.random()*1000+1);

        while (findCustomerById(id)!=null){
            id=(int) Math.round(Math.random()*1000+1);
        }

        return id;

    }

    @Override
    public Customer loginCustomer(String user, String parola){

        for(int i =0; i < users.size();i++){
            if(users.get(i) instanceof Customer c){
                if(c.getUsername().equals(user) && c.getPassword().equals(parola)){
                    return c;
                }
            }
        }
        return null;

    }

    @Override
    public Admin loginAdmin(String user, String parola){

        for(int i =0; i < users.size();i++){
            if(users.get(i) instanceof Admin a){
                if(a.getUsername().equals(user) && a.getPassword().equals(parola)){
                    return a;
                }
            }
        }
        return null;

    }
}
