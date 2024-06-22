package view;

import newspaper.service.*;
import order_details.model.OrderDetails;
import order_details.service.*;
import orders.model.Order;
import orders.service.*;
import products.models.*;
import products.service.*;
import reviews.model.Review;
import reviews.service.*;
import users.models.Admin;
import users.models.Customer;
import users.service.*;
import utile.ProductDto;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminView {

    private Admin admin;
    private Scanner scanner;
    private ProductCommandService productCommandService;
    private ProductQueryService productQueryService;
    private OrderDetailsQueryService orderDetailsQueryService;
    private OrderDetailsCommandService orderDetailsCommandService;
    private OrderCommandService orderCommandService;
    private OrderQueryService orderQueryService;
    private ReviewCommandService reviewCommandService;
    private ReviewQueryService reviewQueryService;
    private UserQueryService userQueryService;
    private UserCommandService userCommandService;
    private NewspaperCommandService newspaperCommandService;
    private NewspaperQueryService newspaperQueryService;



    public AdminView(Admin admin){
        this.admin = admin;
        this.orderCommandService = OrderCommandServiceSingleton.getInstance();
        this.orderQueryService = OrderQueryServiceSingleton.getInstance();
        this.productCommandService = ProductCommandServiceSingleton.getInstance();
        this.productQueryService = ProductQueryServiceSingleton.getInstance();
        this.orderDetailsCommandService = OrderDetailsCommandServiceSingleton.getInstance();
        this.orderDetailsQueryService = OrderDetailsQueryServiceSingleton.getInstance();
        this.reviewCommandService = ReviewCommandServiceSingleton.getInstance();
        this.reviewQueryService = ReviewQueryServiceSingleton.getInstance();
        this.userCommandService = UserCommandServiceSingleton.getInstance();
        this.userQueryService = UserQueryServiceSingleton.getInstance();
        this.newspaperCommandService = NewspaperCommandServiceSingleton.getInstance();
        this.newspaperQueryService = NewspaperQueryServiceSingleton.getInstance();

        this.scanner = new Scanner(System.in);

        this.play();
    }

    private void meniu(){

        System.out.println("Apasati tasta urmatoare: ");
        System.out.println("Clienti: ");
        System.out.println("1. Afiseaza clienti");
        System.out.println("2. Sterge un client");
        System.out.println("3. Editeaza datele unui client");

        System.out.println("\n");

        System.out.println("Produse: ");
        System.out.println("4. Afiseaza produse");
        System.out.println("5. Sterge un produs");
        System.out.println("6. Adauga un produs");
        System.out.println("7. Editeaza un produs");
        System.out.println("8. Afiseaza cel mai vandut produs");
        System.out.println("9. Afiseaza cel mai fidel client");

        System.out.println("\n");

        System.out.println("Comenzi: ");
        System.out.println("10. Afiseaza toate comenzile cu detalii");
        System.out.println("11. Afiseaza comenzile");
        System.out.println("12. Sterge o comanda");

        System.out.println("\n");

        System.out.println("Review: ");
        System.out.println("13. Afiseaza rerview-urile unui produs");
        System.out.println("14. Sterge un review");

        System.out.println("\n");

        System.out.println("Promotii: ");
        System.out.println("15. Introduce promotia de craciun");
        System.out.println("16. Anuleaza promotia de craciun");
        System.out.println("17. Introduce promotia de paste");
        System.out.println("18. Anuleaza promotia de paste");

        System.out.println("\n");
        System.out.println("Admini: ");
        System.out.println("19. Adauga un admin");

        System.out.println("\n");

        System.out.println("Newspaper:");
        System.out.println("20. Actualizeaza newspaper-ul");
        System.out.println("21. Afiseaza newspaper-ul");

        System.out.println("22. Iesi din cont");

    }


    private void play(){

        boolean running = true;

        while(running ) {
            meniu();
            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere) {
                case 1:
                    userQueryService.afisareClient();
                    break;
                case 2:
                    stergeClient();
                    break;
                case 3:
                    editareDateClient();
                    break;
                case 4:
                    productQueryService.afisare();
                    break;
                case 5:
                    stergeProdus();
                    break;
                case 7:
                    editareProdus();
                    break;
                case 8:
                    celMaiVandutProdus();
                    break;
                case 9:
                    customerLoial();
                    break;
                case 10:
                    afisareComenzi();
                    break;
                case 11:
                    orderQueryService.afisare();
                    break;
                case 12:
                    stergeComanda();
                    break;
                case 13:
                    afisareReviewuri();
                    break;
                case 14:
                    stergeReview();
                    break;
                case 15:
                    promoCraciun();
                    break;
                case 16:
                    productCommandService.anularePromoCraciun();
                    break;
                case 17:
                    promoPaste();
                    break;
                case 18:
                    productCommandService.anularePromoPaste();
                    break;
                case 19:
                    adaugareAdmin();
                    break;
                case 20:
                    actualizareNewspaper();
                    break;
                case 21:
                    newspaperQueryService.afisare();
                    break;
                case 22:
                    running = false;
                    break;
                default:
                    System.out.println("Tasta incorecta");
            }
        }
    }

    private void stergeClient(){

        System.out.println("Introduceti id-ul clientului: ");
        int id = Integer.parseInt(scanner.nextLine());
        Customer client = userQueryService.findCustomerById(id);

        if(client!= null){
            userCommandService.stergeCont(client);
            System.out.println("Client a fost sters!");
        }else{
            System.out.println("Client nu a fost gasit");
        }
        userCommandService.saveData();


    }

    private void editareDateClient(){
        System.out.println("Introduceti id-ul clientului care doriti sa il editati: ");
        int id = Integer.parseInt(scanner.nextLine());
        Customer client = userQueryService.findCustomerById(id);

        if(client != null) {
            System.out.println("Ce doriti sa editati? ");
            System.out.println("1. Email");
            System.out.println("2. Password");
            System.out.println("3. Full name");
            System.out.println("4. Billing adress");
            System.out.println("5. Country");
            System.out.println("6. Phone");

            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere) {
                case 1:
                    System.out.println("Introduceti noul email: ");
                    String email = scanner.nextLine();
                    client.setEmail(email);
                    break;
                case 2:
                    System.out.println("Introduceti noul password: ");
                    String password = scanner.nextLine();
                    client.setPassword(password);
                    break;
                case 3:
                    System.out.println("Introduceti noul full name: ");
                    String fullName = scanner.nextLine();
                    client.setFullName(fullName);
                    break;
                case 4:
                    System.out.println("Introduceti noul billing adress: ");
                    String billingAdress = scanner.nextLine();
                    client.setBillingAdress(billingAdress);
                    break;
                case 5:
                    System.out.println("Introduceti noul country: ");
                    String country = scanner.nextLine();
                    client.setCountry(country);
                    break;
                case 6:
                    System.out.println("Introduceti noul phone: ");
                    int phone = Integer.parseInt(scanner.nextLine());
                    client.setPhone(phone);
                    break;
                default:
                    System.out.println("Tasta incorecta");
            }
        }else{
            System.out.println("Clientu nu a fost gasit");
        }
    }

    private void stergeProdus(){

        System.out.println("Introduceti id-ul produsului: ");
        int id = Integer.parseInt(scanner.nextLine());

        Product produs = productQueryService.findProductById(id);

        if(produs!= null){
            productCommandService.stergeProdus(produs);
            System.out.println("Produsul a fost sters!");
        }else{
            System.out.println("Produsul nu a fost gasit");
        }

    }

    private void editareProdus() {

        System.out.println("Introduceti id-ul produsului care doriti sa il editati: ");
        int id = Integer.parseInt(scanner.nextLine());
        Product produs = productQueryService.findProductById(id);

        if (produs != null) {
            if (produs instanceof Laptop l) {
                System.out.println("Ce doriti sa editati?");
                System.out.println("1. Nume");
                System.out.println("2. Pret");
                System.out.println("3. Stoc");
                System.out.println("4. Ram");
                System.out.println("5. Procesor");
                System.out.println("6. Placa video");

                int alegere = Integer.parseInt(scanner.nextLine());
                switch (alegere) {
                    case 1:
                        System.out.println("Introduceti noul nume: ");
                        String nume = scanner.nextLine();
                        l.setName(nume);
                        break;
                    case 2:
                        System.out.println("Introduceti noul pret: ");
                        double pret = Double.parseDouble(scanner.nextLine());
                        l.setPrice(pret);
                        break;
                    case 3:
                        System.out.println("Introduceti noul stoc: ");
                        int stoc = Integer.parseInt(scanner.nextLine());
                        l.setStock(stoc);
                        break;
                    case 4:
                        System.out.println("Introduceti noii rami: ");
                        int ram = Integer.parseInt(scanner.nextLine());
                        l.setRam(ram);
                        break;
                    case 5:
                        System.out.println("Introduceti noul procesor");
                        String procesor = scanner.nextLine();
                        l.setProcesor(procesor);
                        break;
                    case 6:
                        System.out.println("Introduceti noua placa video");
                        String placa = scanner.nextLine();
                        l.setPlacaVideo(placa);
                        break;
                    default:
                        System.out.println("Tasta incorecta");

                }
            } else if (produs instanceof Monitor m) {
                System.out.println("Ce doriti sa editati?");
                System.out.println("1. Nume");
                System.out.println("2. Pret");
                System.out.println("3. Stoc");
                System.out.println("4. Hz");
                System.out.println("5. Dimensiune");

                int alegere = Integer.parseInt(scanner.nextLine());
                switch (alegere) {
                    case 1:
                        System.out.println("Introduceti noul nume: ");
                        String nume = scanner.nextLine();
                        m.setName(nume);
                        break;
                    case 2:
                        System.out.println("Introduceti noul pret: ");
                        double pret = Double.parseDouble(scanner.nextLine());
                        m.setPrice(pret);
                        break;
                    case 3:
                        System.out.println("Introduceti noul stoc: ");
                        int stoc = Integer.parseInt(scanner.nextLine());
                        m.setStock(stoc);
                        break;
                    case 4:
                        System.out.println("Introduceti noii hz: ");
                        int hz = Integer.parseInt(scanner.nextLine());
                        m.setHz(hz);
                        break;
                    case 5:
                        System.out.println("Introduceti noua dimensiune: ");
                        double dimensiune = Integer.parseInt(scanner.nextLine());
                        m.setDimensiune(dimensiune);
                        break;
                    default:
                        System.out.println("Tasta incorecta");
                }
            } else if (produs instanceof SmartWatch s) {

                System.out.println("Ce doriti sa editati?");
                System.out.println("1. Nume");
                System.out.println("2. Pret");
                System.out.println("3. Stoc");
                System.out.println("4. Marime bratara");


                int alegere = Integer.parseInt(scanner.nextLine());
                switch (alegere) {
                    case 1:
                        System.out.println("Introduceti noul nume: ");
                        String nume = scanner.nextLine();
                        s.setName(nume);
                        break;
                    case 2:
                        System.out.println("Introduceti noul pret: ");
                        double pret = Double.parseDouble(scanner.nextLine());
                        s.setPrice(pret);
                        break;
                    case 3:
                        System.out.println("Introduceti noul stoc: ");
                        int stoc = Integer.parseInt(scanner.nextLine());
                        s.setStock(stoc);
                        break;
                    case 4:
                        System.out.println("Introduceti noua marime pentru bratara: ");
                        int marime = Integer.parseInt(scanner.nextLine());
                        s.setMarimeBratara(marime);
                        break;
                    default:
                        System.out.println("Tasta incorecta");

                }


            }else if(produs instanceof Telefon t){
                System.out.println("Ce doriti sa editati?");
                System.out.println("1. Nume");
                System.out.println("2. Pret");
                System.out.println("3. Stoc");
                System.out.println("4. Culoare");
                System.out.println("5. Nr camere");
                System.out.println("6. Capacitate");

                int alegere = Integer.parseInt(scanner.nextLine());
                switch (alegere) {
                    case 1:
                        System.out.println("Introduceti noul nume: ");
                        String nume = scanner.nextLine();
                        t.setName(nume);
                        break;
                    case 2:
                        System.out.println("Introduceti noul pret: ");
                        double pret = Double.parseDouble(scanner.nextLine());
                        t.setPrice(pret);
                        break;
                    case 3:
                        System.out.println("Introduceti noul stoc: ");
                        int stoc = Integer.parseInt(scanner.nextLine());
                        t.setStock(stoc);
                        break;
                    case 4:
                        System.out.println("Introduceti noua culoare: ");
                        String culoare = scanner.nextLine();
                        t.setCuloare(culoare);
                        break;
                    case 5:
                        System.out.println("Introduceti noul numar de camere: ");
                        int camere = Integer.parseInt(scanner.nextLine());
                        t.setNrCamere(camere);
                        break;
                    case 6:
                        System.out.println("Introduceti noua capacitate: ");
                        int capacitate = Integer.parseInt(scanner.nextLine());
                        t.setCapacitate(capacitate);
                        break;
                    default:
                        System.out.println("Tasta incorecta");
                }
            }
        }
    }

    private void celMaiVandutProdus(){

        Product product = productQueryService.findProductById(orderDetailsQueryService.celMaiVandutProdus());

        System.out.println(product.descriere());


    }

    private void customerLoial(){

        Customer customer = userQueryService.findCustomerById(orderQueryService.clientCuCeleMaiMulteComenzi());

        System.out.println("Clientul cu cele mai multe comenzi este: ");
        System.out.println(customer.descriere());

    }

    private void afisareComenzi(){

        ArrayList<OrderDetails> orderDetails = orderDetailsQueryService.getOrderDetails();
        ArrayList<ProductDto> productDtos = new ArrayList<>();

        for(int i =0 ; i < orderDetails.size(); i++){
            ProductDto productDto = new ProductDto(productQueryService.findProductById(orderDetails.get(i).getProductId()).getName(),orderDetails.get(i).getQuantity(),orderDetails.get(i).getPrice());
            productDtos.add(productDto);
        }
        for(int i =0 ; i < productDtos.size(); i++){
            System.out.println(productDtos.get(i).descriere());
        }
    }

    private void stergeComanda(){
        System.out.println("Introduceti id-ul comenzi: ");
        int id = Integer.parseInt(scanner.nextLine());

        Order order = orderQueryService.findOrderById(id);
        if(order != null) {
            orderCommandService.stergeComanda(order);
            System.out.println("Comanda a fost stearsa");
        }else{
            System.out.println("Comanda nu a fost gasita");
        }

    }

    private void afisareReviewuri(){

        System.out.println("Introduceti id-ul produsului la care doriti sa vizualizati reviewurile: ");
        System.out.println("Id: ");
        int id = Integer.parseInt(scanner.nextLine());
        Product product = productQueryService.findProductById(id);


        if(product!=null){
            ArrayList<Review> reviews = reviewQueryService.getReviewsProduct(product.getId());
            int nrRev= reviewQueryService.getNrReviews(reviews);
            System.out.println("Ratingul total este " + reviewQueryService.calculareRating(reviews) + " si are " + nrRev + " review-uri");
            System.out.println("\n");
            for(int i =0 ; i < reviews.size(); i++){
                System.out.println(reviews.get(i).descriere());
            }
        }else{
            System.out.println("Produsul nu a fost gasit");
        }

    }

    private void stergeReview(){

        System.out.println("Introduceti titlul review-ului: ");
        String title = scanner.nextLine();

        ArrayList<Review> reviews = reviewQueryService.getReviewsByTitle(title);

        if(!reviews.isEmpty()){
            if(reviews.size()==1){
                reviewCommandService.stergeReview(reviews.get(0));
                System.out.println("Reviewul a fost sters");
            }else{
                for(int i =0 ; i < reviews.size(); i++){
                    System.out.println(reviews.get(i).descriere() + reviews.get(i).getId());
                }

                System.out.println("Au fost gasite mai multe review-uri cu acest titlu, introduceti id-ul review-ului: ");
                int id = Integer.parseInt(scanner.nextLine());
                Review review = reviewQueryService.findReviewById(id);
                if(review!=null) {
                    reviewCommandService.stergeReview(review);
                    System.out.println("Reviewul a fost sters!");
                }else{
                    System.out.println("Reviewul nu a fost gasit");
                }
            }
        }

    }

    private void promoCraciun(){

        System.out.println("Reducerea de craciun este de 50% la toate produsele, doriti sa o aplicati?(y/n)");
        String choice = scanner.nextLine();

        if(choice.equals("y")){
            productCommandService.promoCraciun();
            System.out.println("Promotia a fost activata!");
        }
    }

    private void promoPaste(){

        System.out.println("Reducerea de paste este de 30% la toate produsele, doriti sa o aplicati?(y/n)");
        String choice = scanner.nextLine();
        if(choice.equals("y")){
            productCommandService.promoPaste();
            System.out.println("Promotia a fost activata!");
        }
    }

    private void adaugareAdmin(){

        System.out.println("Introduceti user-ul: ");
        String username = scanner.nextLine();
        System.out.println("Introduceti password: ");
        String password = scanner.nextLine();
        System.out.println("Introduceti gradul(Moderator/Viewer): ");
        String grad = scanner.nextLine();

        Admin admin = new Admin(userQueryService.generateId(), username, password, grad);

        if(userCommandService.adaugareAdmin(admin)){
            System.out.println("Adminul a fost adaugat!");
        }else{
            System.out.println("Usernamul este deja folosit");
        }
        userCommandService.saveData();
    }

    private void actualizareNewspaper(){

        System.out.println("Intruceti noua oferta: ");
        String txt = scanner.nextLine();

        newspaperCommandService.update(txt);
        newspaperQueryService.notifyUsers();

        System.out.println("Oferta a fost actualizata!");

    }
}
