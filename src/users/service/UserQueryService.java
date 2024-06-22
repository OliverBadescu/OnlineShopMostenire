package users.service;

import users.models.Admin;
import users.models.Customer;
import users.models.Users;

import java.io.File;
import java.util.Scanner;

public interface UserQueryService {

    void loadData();

    String toString();

    void afisare();

    void afisareClient();

    Customer findCustomerById(int id);

    int generateId();

    Customer loginCustomer(String user,String parola);

    Admin loginAdmin(String user,String parola);

    boolean subscribeToNewsletter(Customer u);

    boolean unsubscribeFromNewsletter(Customer u);


}
