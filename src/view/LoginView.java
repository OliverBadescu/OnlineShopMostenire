package view;

import users.derivate.Admin;
import users.derivate.Customer;
import users.service.UserService;

import java.util.Scanner;

public class LoginView {

    private UserService userService;
    private Scanner scanner;

    public LoginView(){

        this.userService = new UserService();
        this.scanner = new Scanner(System.in);

        this.play();
    }

    private void meniu(){

        System.out.println("Apasati tasta urmatoare: ");
        System.out.println("1. Logare");
        System.out.println("2. Inregistrare");
        System.out.println("3. Iesi din aplicate");
        System.out.println("\n");
        System.out.println("4. Logare pentru admini");
    }


    private void play(){

        boolean running = true;

        while (running) {
            meniu();
            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere){
                case 1:
                    loginCustomer();
                    break;
                case 2:
                    inregistrareCustomer();
                    break;
                case 3:
                    running = false;
                    break;
                case 4:
                    loginAdmin();
                    break;
                default:
                    System.out.println("Tasta incorecta");
            }

        }

    }

    private void loginCustomer(){

        System.out.println("Introduceti numele si parola");
        System.out.println("Nume: ");
        String nume = scanner.nextLine();
        System.out.println("Parola: ");
        String parola = scanner.nextLine();

        Customer customer = userService.loginCustomer(nume,parola);

        if(customer!=null){
            ClientView clientView = new ClientView(customer);
        }else{
            System.out.println("Date incorecte");
        }

    }
    private void loginAdmin(){

        System.out.println("Introduceti numele si parola");
        System.out.println("Nume: ");
        String nume = scanner.nextLine();
        System.out.println("Parola: ");
        String parola = scanner.nextLine();

        Admin admin = userService.loginAdmin(nume,parola);

        if(admin!=null){
            AdminView adminView = new AdminView(admin);
        }else{
            System.out.println("Date incorecte");
        }

    }

    private void inregistrareCustomer(){

        System.out.println("Introduceti datele urmatoare: ");
        System.out.println("Username: ");
        String username = scanner.nextLine();
        System.out.println("Parola: ");
        String parola = scanner.nextLine();
        System.out.println("Full name: ");
        String fullName = scanner.nextLine();
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Billing Adress: ");
        String billing = scanner.nextLine();
        System.out.println("Country: ");
        String country = scanner.nextLine();
        System.out.println("Phone: ");
        int phone = Integer.parseInt(scanner.nextLine());

        Customer customer = new Customer(userService.generateId(),username,parola,fullName,email,billing,country,phone);

        if (userService.inregistrareCustomer(customer)) {
            System.out.println("V-ati inregistrat cu succes, logati-va pentru a continua");
        } else {
            System.out.println("Username-ul este deja folosit");
        }

    }



}
