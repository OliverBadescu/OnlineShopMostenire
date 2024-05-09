package users.service;

import users.baza.Users;
import users.derivate.Admin;
import users.derivate.Customer;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class UserService {

    private ArrayList<Users> users;

    public UserService(){

        this.users = new ArrayList<>();

        this.loadData();

    }

    private void loadData(){

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

                Users user = new Users(line);

                this.users.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void afisare(){

        for(int i = 0;i < users.size();i++){
            if(users.get(i) instanceof Admin a){
                System.out.println(a.descriereAdmin());
                System.out.println("\n");
            }
            if(users.get(i) instanceof Customer c){
                System.out.println(c.descriereCustomer());
                System.out.println("\n");
            }
        }

    }

    public void afisareClient(){
        for(int i =0 ; i < users.size();i++){
            if(users.get(i) instanceof Customer c){
                System.out.println(c.descriereCustomer());
            }
        }
    }

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

    public int generateId(){

        int id=(int) Math.round(Math.random()*1000+1);

        while (findCustomerById(id)!=null){
            id=(int) Math.round(Math.random()*1000+1);
        }

        return id;

    }

    public void stergeCont(Customer customer) {

        this.users.remove(customer);

    }

    public Customer loginCustomer(String user,String parola){

        for(int i =0; i < users.size();i++){
            if(users.get(i) instanceof Customer c){
                if(c.getUsername().equals(user) && c.getPassword().equals(parola)){
                    return c;
                }
            }
        }
        return null;

    }

    public Admin loginAdmin(String user,String parola){

        for(int i =0; i < users.size();i++){
            if(users.get(i) instanceof Admin a){
                if(a.getUsername().equals(user) && a.getPassword().equals(parola)){
                    return a;
                }
            }
        }
        return null;

    }

    public boolean inregistrareCustomer(Customer customer){
        for(int i =0 ; i < users.size();i++){
            if(users.get(i) instanceof Customer c){
                if(c.getUsername().equals(customer.getUsername())){
                    return false;
                }
            }
        }
        return true;
    }

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
