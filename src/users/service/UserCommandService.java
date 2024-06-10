package users.service;

import users.models.Admin;
import users.models.Customer;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public interface UserCommandService {


    void saveData();

    void stergeCont(Customer customer);

    boolean inregistrareCustomer(Customer customer);

    boolean adaugareAdmin(Admin admin);
}
