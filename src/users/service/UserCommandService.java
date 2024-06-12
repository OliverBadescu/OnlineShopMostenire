package users.service;

import users.models.Admin;
import users.models.Customer;



public interface UserCommandService {

    void loadData();

    void saveData();

    void stergeCont(Customer customer);

    boolean inregistrareCustomer(Customer customer);

    boolean adaugareAdmin(Admin admin);
}
