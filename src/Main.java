import users.derivate.Customer;
import users.service.UserService;
import view.ClientView;

public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer(5,"luca","luca123","Luca Rossi","luca@example.com","543 Cedar Road Anothercity","USA",6633111);

        ClientView clientView = new ClientView(customer);

    }
}