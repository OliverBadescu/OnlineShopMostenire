import org.junit.Test;
import users.models.Admin;
import users.models.Customer;
import users.service.UserService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class UserServiceTest {

    UserService userService;

    @Test

    public void GivenAvailaibleDataCheckIfGetsLoaded(){

        userService = new UserService();

        Customer customer = userService.findCustomerById(1);

        assertEquals(1, customer.getId());

    }

    @Test

    public void afisare(){

        userService= new UserService();

        userService.afisare();
        userService.afisareClient();
        int id = userService.generateId();
    }

    @Test

    public void GivenAvailaibleCustomerIdCheckIfGetsFound(){

        userService = new UserService();

        Customer customer = userService.findCustomerById(1);
        Customer none = userService.findCustomerById(10);

        assertEquals(1, customer.getId());
        assertNull(none);
    }

    @Test

    public void GivenAvailableCustomerAccountCheckIfGetsDeleted(){

        userService = new UserService();

        userService.stergeCont(userService.findCustomerById(1));

        assertNull(userService.findCustomerById(1));

    }

    @Test

    public void GivenAvailableCustomerDataCheckIfGetsLogedIn(){

        userService= new UserService();

        Customer none = userService.loginCustomer("asff", "1231");
        Customer customer = userService.loginCustomer("john","password123");

        assertEquals(1, customer.getId());
        assertNull(none);

    }

    @Test

    public void GivenAvailableAdminDataCheckIfGetsLogedIn(){

        userService= new UserService();

        Admin none = userService.loginAdmin("asff", "1231");
        Admin admin = userService.loginAdmin("admin","123");

        assertEquals(1, admin.getId());
        assertNull(none);

    }

    @Test

    public void GivenAvailableCustomerCheckIfGetsRegistred(){

        userService = new UserService();
        Customer customer1 = new Customer(6, "ahmed", "test", "name", "email","address","country", 2333);
        Customer customer2 = new Customer(7, "test", "test", "name", "email","address","country", 2333);


        userService.inregistrareCustomer(customer1);
        userService.inregistrareCustomer(customer2);


        assertNull(userService.findCustomerById(6));
        assertEquals(customer2, userService.findCustomerById(7));

    }

    @Test

    public void GivenAvailableAdminCheckIfGetsRegistred(){

        userService = new UserService();
        Admin n1 = new Admin(2, "test", "123", "t");
        Admin n2= new Admin(3, "admin", "123", "t");

        userService.adaugareAdmin(n1);
        userService.adaugareAdmin(n2);



    }

}
