import org.junit.Test;
import users.models.Admin;
import users.models.Customer;
import users.models.Users;
import users.service.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class UserServiceTest {

    UserQueryService userQueryService;
    UserCommandService userCommandService;
    private ArrayList<Users> users = new ArrayList<>();

    @Test

    public void GivenAvailaibleDataCheckIfGetsLoaded(){

        this.userCommandService = new UserCommandServiceImpl();
        this.userQueryService = new UserQueryServiceImpl();

        Customer customer = userQueryService.findCustomerById(1);

        assertEquals(1, customer.getId());

    }

    @Test

    public void afisare(){

        this.userCommandService = new UserCommandServiceImpl();
        this.userQueryService = new UserQueryServiceImpl();

        userQueryService.afisare();
        userQueryService.afisareClient();
        int id = userQueryService.generateId();
    }

    @Test

    public void GivenAvailaibleCustomerIdCheckIfGetsFound(){

        this.userCommandService = new UserCommandServiceImpl();
        this.userQueryService = new UserQueryServiceImpl();

        Customer customer = userQueryService.findCustomerById(1);
        Customer none = userQueryService.findCustomerById(10);

        assertEquals(1, customer.getId());
        assertNull(none);
    }

    @Test

    public void GivenAvailableCustomerAccountCheckIfGetsDeleted(){

        this.userCommandService = new UserCommandServiceImpl();
        this.userQueryService = new UserQueryServiceImpl();

        userCommandService.stergeCont(userQueryService.findCustomerById(1));

        assertNull(userQueryService.findCustomerById(1));

    }

    @Test

    public void GivenAvailableCustomerDataCheckIfGetsLogedIn(){

        this.userCommandService = new UserCommandServiceImpl();
        this.userQueryService = new UserQueryServiceImpl();

        Customer none = userQueryService.loginCustomer("asff", "1231");
        Customer customer = userQueryService.loginCustomer("john","password123");

        assertEquals(1, customer.getId());
        assertNull(none);

    }

    @Test

    public void GivenAvailableAdminDataCheckIfGetsLogedIn(){

        this.userCommandService = new UserCommandServiceImpl();
        this.userQueryService = new UserQueryServiceImpl();

        Admin none = userQueryService.loginAdmin("asff", "1231");
        Admin admin = userQueryService.loginAdmin("admin","123");

        assertEquals(1, admin.getId());
        assertNull(none);

    }

    @Test

    public void GivenAvailableCustomerCheckIfGetsRegistred(){

        this.userCommandService = new UserCommandServiceImpl();
        this.userQueryService = new UserQueryServiceImpl();
        Customer customer1 = new Customer(6, "ahmed", "test", "name", "email","address","country", 2333,false);
        Customer customer2 = new Customer(7, "test", "test", "name", "email","address","country", 2333,false);


        userCommandService.inregistrareCustomer(customer1);
        userCommandService.inregistrareCustomer(customer2);


        assertNull(userQueryService.findCustomerById(6));
        assertEquals(customer2, userQueryService.findCustomerById(7));

    }

    @Test

    public void GivenAvailableAdminCheckIfGetsRegistred(){

        this.userCommandService = new UserCommandServiceImpl();
        this.userQueryService = new UserQueryServiceImpl();
        Admin n1 = new Admin(2, "test", "123", "t");
        Admin n2= new Admin(3, "admin", "123", "t");

        userCommandService.adaugareAdmin(n1);
        userCommandService.adaugareAdmin(n2);



    }

}
