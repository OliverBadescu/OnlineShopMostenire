package users.service;

import users.baza.Users;
import users.derivate.Admin;
import users.derivate.Customer;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class UserSerivce {

    private ArrayList<Users> users;

    public UserSerivce(){

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

}
