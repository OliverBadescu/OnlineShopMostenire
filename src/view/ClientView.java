package view;

import appearance.command.AppearanceCommandInvoker;
import appearance.model.DarkMode;
import appearance.model.LightMode;
import appearance.service.AppearanceService;
import appearance.service.AppearanceServiceSingleton;
import newspaper.service.NewspaperCommandService;
import newspaper.service.NewspaperCommandServiceSingleton;
import newspaper.service.NewspaperQueryService;
import newspaper.service.NewspaperQueryServiceSingleton;
import order_details.model.OrderDetails;
import order_details.service.*;
import orders.model.Order;
import orders.service.*;
import products.models.Product;
import products.service.*;
import reviews.model.Review;
import reviews.service.*;
import users.models.Customer;
import users.service.*;
import utile.Cos;
import utile.ProductDto;

import java.util.ArrayList;
import java.util.Scanner;

public class ClientView {

    private Customer customer;
    private ProductCommandService productCommandService;
    private ProductQueryService productQueryService;
    private Scanner scanner;
    private Cos cos;
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
    private AppearanceService appearanceService;
    private AppearanceCommandInvoker appearanceInvoker;

    public ClientView(Customer customer){
        this.scanner = new Scanner(System.in);
        this.customer = customer;
        this.cos = new Cos(this.customer.getId(), null);
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
        this.appearanceService = AppearanceServiceSingleton.getInstance();
        this.appearanceInvoker = new AppearanceCommandInvoker();

        this.play();
    }

    private void meniu(){


        System.out.println("Apasati tasta urmatoare");
        System.out.println("Produse: ");
        System.out.println("1. Afisati produsele");
        System.out.println("2. Filtrare produse");
        System.out.println("3. Sortare produse");
        System.out.println("4. Cel mai vandut produs");

        System.out.println("\n");

        System.out.println("Cos: ");
        System.out.println("5. Adauga un produs in cos");
        System.out.println("6. Sterge un produs din cos");
        System.out.println("7. Goleste cosul");
        System.out.println("8. Afiseaza cosul");

        System.out.println("\n");

        System.out.println("Comanda:");
        System.out.println("9. Trimite comanda");
        System.out.println("10. Afiseaza comenzile");


        System.out.println("\n");

        System.out.println("Review: ");
        System.out.println("11. Adaugati un review");
        System.out.println("12. Afisati review-urile unui produs");

        System.out.println("\n");

        System.out.println("Cont: ");
        System.out.println("13. Afisati datele dvs.");
        System.out.println("14. Editati datele dvs.");
        System.out.println("15. Stergeti contul dvs.");

        System.out.println("\n");

        System.out.println("Newsletter:");
        System.out.println("16. Afisare");
        System.out.println("17. Subscribe");
        System.out.println("18. Unsubscribe");

        System.out.println("\n");

        System.out.println("Appearance:");
        System.out.println("19. Light/Dark Mode");

        System.out.println("\n");
        System.out.println("Apasati tasta 20 pentru a iesi din cont");

    }

    private void play(){

        boolean running = true;

        while(running ) {
            meniu();
            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere){
                case 1:
                    productQueryService.afisare();
                    break;
                case 2:
                    filtrare();
                    break;
                case 3:
                    sortare();
                    break;
                case 4:
                    celMaiVandutProdus();
                    break;
                case 5:
                    adaugareProdusInCos();
                    break;
                case 6:
                    stergereDinCos();
                    break;
                case 7:
                    cos.setProducts(null);
                case 8:
                    afisareCos();
                    break;
                case 9:
                    trimiteComanda();
                    break;
                case 10:
                    afisareComenzi();
                    break;
                case 11:
                    adaugareRating();
                    break;
                case 12:
                    afisareReviewuri();
                    break;
                case 13:
                    System.out.println(this.customer.descriere());
                    break;
                case 14:
                    editareDate();
                    break;
                case 15:
                    stergereCont();
                    break;
                case 16:
                    afisareNewsletter();
                    break;
                case 17:
                    abonareNewsletter();
                    break;
                case 18:
                    dezabonareNewsletter();
                    break;
                case 19:
                    toggleAppearance();
                    break;
                case 20:
                    running = false;
                    break;
                default:
                    System.out.println("Tasta incorecta");
            }
        }

    }

    private void toggleAppearance() {
        if (appearanceService.isDarkMode()) {
            appearanceInvoker.setCommand(new LightMode(appearanceService));
        } else {
            appearanceInvoker.setCommand(new DarkMode(appearanceService));
        }
        appearanceInvoker.executeCommand();
    }

    private void filtrare(){

        System.out.println("Ce doriti sa afisati: ");
        System.out.println("1. Telefoane");
        System.out.println("2. Monitoare");
        System.out.println("3. Laptopuri");
        System.out.println("4. SmartWatch-uri");

        int alegere = Integer.parseInt(scanner.nextLine());
        switch (alegere){
            case 1:
                productQueryService.afisareTelefoane();
                break;
            case 2:
                productQueryService.afisareMonitor();
                break;
            case 3:
                productQueryService.afisareLaptopuri();
                break;
            case 4:
                productQueryService.afisareSmartWatch();
                break;
            default:
                System.out.println("Tasta incorecta");
        }

    }

    private void sortare(){

        System.out.println("Cum doriti sa sortati produsele: ");
        System.out.println("1. Pret descrescator");
        System.out.println("2. Pret crescator");

        int alegere = Integer.parseInt(scanner.nextLine());
        switch (alegere){
            case 1:
                productQueryService.sortareDupaPretDescrescator();
                break;
            case 2:
                productQueryService.sortareDupaPretCrescator();
                break;
            default:
                System.out.println("Tasta incorecta");
        }
    }

    private void celMaiVandutProdus(){

        Product product = productQueryService.findProductById(orderDetailsQueryService.celMaiVandutProdus());

        System.out.println(product.descriere());


    }

    private void adaugareProdusInCos(){

        boolean running = true;
        ArrayList<ProductDto> list = new ArrayList<>();

        while(running ){
            System.out.println("Introduceti numele produsului care doriti sa il adaugati in cos: ");
            String nume = scanner.nextLine();
            Product product = productQueryService.findByName(nume);

            if(product != null){
                System.out.println("Cate bucati doriti?");
                int buc = Integer.parseInt(scanner.nextLine());
                ProductDto productDto = new ProductDto(product.getName(), buc, product.getPrice());
                System.out.println("Produsul a fost adaugat in cos");
                list.add(productDto);
            }else{
                System.out.println("Produsul nu a fost gasit");
            }

            System.out.println("Doriti sa adaugi alt produs in cos?");
            String alegere = scanner.nextLine();

            if(alegere.equals("Nu") || alegere.equals("nu")){
                running = false;
            }
        }
        cos.setProducts(list);

    }

    private void stergereDinCos(){

        ArrayList<ProductDto> list = cos.getProducts();
        boolean running = true;
        boolean found = false;
        while(running) {
            System.out.println("Introduceti numele produsului care doriti sa il stergeti: ");
            String nume = scanner.nextLine();
            Product product = productQueryService.findByName(nume);


            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getName().equals(product.getName())) {
                    list.remove(list.get(i));
                    found = true;
                    System.out.println("Produsul a fost sters");
                }
            }
            if (!found) {
                System.out.println("Produsul nu a fost gasit in cos");
            }
            System.out.println("Doriti sa stergeti alt produs din cos?");
            String alegere = scanner.nextLine();

            if(alegere.equals("Nu") || alegere.equals("nu")){
                running = false;
            }
        }
        cos.setProducts(list);
    }

    private void afisareCos(){

        ArrayList<ProductDto> list = cos.getProducts();

        if(list!=null) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).descriere());
            }
        }else{
            System.out.println("Cosul dvs. este gol");
        }




    }

    private void trimiteComanda(){

        ArrayList<ProductDto> list = cos.getProducts();
        int id = orderDetailsQueryService.generateId();
        double amount=0;

        if (list!= null){
            for(int i =0 ; i < list.size(); i++){
                amount += list.get(i).getPrice() * list.get(i).getCantitate();
            }
            afisareCos();
            System.out.println("Acesta este cosul dvs, totalul comenzii este: " + amount);
            System.out.println("Doriti sa trimiteti comanda?(y/n)");
            String alegere = scanner.nextLine();
            if(alegere.equals("y")){
                Order order = new Order(id, this.customer.getId(),amount);
                orderCommandService.add(order);
                System.out.println("Comanda a fost adaugata");

                for(int i =0 ; i < list.size(); i++){
                    OrderDetails orderDetails = new OrderDetails(orderDetailsQueryService.generateId(), id, productQueryService.findByName(list.get(i).getName()).getId(), list.get(i).getPrice(), list.get(i).getCantitate());
                    orderDetailsCommandService.adaugare(orderDetails);
                    Product product = productQueryService.findProductById(orderDetails.getProductId());
                    product.setStock(product.getStock()-orderDetails.getQuantity());
                }
                cos.setProducts(null);
                productCommandService.saveData();
            }
        }else{
            System.out.println("Cosul dvs. este gol");
        }

    }

    public void afisareComenzi(){

        ArrayList<Order> list = orderQueryService.findOrdersByCustomerId(this.customer.getId());
        ArrayList<OrderDetails> orderDetails = orderDetailsQueryService.orderList(list);
        ArrayList<ProductDto> productDtos = new ArrayList<>();

        for(int i =0 ; i < orderDetails.size(); i++){
            ProductDto productDto = new ProductDto(productQueryService.findProductById(orderDetails.get(i).getProductId()).getName(),orderDetails.get(i).getQuantity(),orderDetails.get(i).getPrice());
            productDtos.add(productDto);
        }

        for(int i =0 ; i < productDtos.size(); i++){
            System.out.println(productDtos.get(i).descriere());
        }



    }

    public void adaugareRating(){

        System.out.println("Introduceti numele produsului la care doriti sa adaugati un review: ");
        String nume = scanner.nextLine();

        Product product = productQueryService.findByName(nume);
        if(product!=null){
            System.out.println("Introduceti titlul: ");
            String title = scanner.nextLine();
            System.out.println("Introduceti descrierea: ");
            String desc = scanner.nextLine();
            System.out.println("Introduceti rating-ul(1-5): ");
            int rating = Integer.parseInt(scanner.nextLine());

            Review review = new Review(reviewQueryService.generateId(), product.getId(), title, desc, rating, 0);
            reviewCommandService.adaugareReview(review);
        }else{
            System.out.println("Produsul nu a fost gasit");
        }


    }

    public void afisareReviewuri(){

        System.out.println("Introduceti numele produsului la care doriti sa vizualizati reviewurile: ");
        System.out.println("Nume: ");
        String nume = scanner.nextLine();
        Product product = productQueryService.findByName(nume);


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

    public void editareDate(){

        System.out.println("Ce doriti sa editati? ");
        System.out.println("1. Email");
        System.out.println("2. Password");
        System.out.println("3. Full name");
        System.out.println("4. Billing adress");
        System.out.println("5. Country");
        System.out.println("6. Phone");

        int alegere = Integer.parseInt(scanner.nextLine());

        switch (alegere){
            case 1:
                System.out.println("Introduceti noul email: ");
                String email = scanner.nextLine();
                this.customer.setEmail(email);
                break;
            case 2:
                System.out.println("Introduceti noul password: ");
                String password = scanner.nextLine();
                this.customer.setPassword(password);
                break;
            case 3:
                System.out.println("Introduceti noul full name: ");
                String fullName = scanner.nextLine();
                this.customer.setFullName(fullName);
                break;
            case 4:
                System.out.println("Introduceti noul billing adress: ");
                String billingAdress = scanner.nextLine();
                this.customer.setBillingAdress(billingAdress);
                break;
            case 5:
                System.out.println("Introduceti noul country: ");
                String country = scanner.nextLine();
                this.customer.setCountry(country);
                break;
            case 6:
                System.out.println("Introduceti noul phone: ");
                int phone = Integer.parseInt(scanner.nextLine());
                this.customer.setPhone(phone);
                break;
            default:
                System.out.println("Tasta incorecta");



        }


    }

    public void stergereCont(){

        System.out.println("Sunteti siguri ca doriti sa va stergeti contul?(y/n)");
        String alegere = scanner.nextLine();

        if(alegere.equals("y")){
            userCommandService.stergeCont(this.customer);
        }


    }

    public void abonareNewsletter(){
        if(userQueryService.subscribeToNewsletter(this.customer)){
            System.out.println("V-ati abonat cu succes");
        }else{
            System.out.println("Sunteti deja abonat la acest newsletter");
        }
    }

    public void dezabonareNewsletter(){
        if(userQueryService.unsubscribeFromNewsletter(this.customer)){
            System.out.println("V-ati dezabonat cu succes");
        }else{
            System.out.println("Nu sunteti abonat la acest newsletter");
        }
    }

    public void afisareNewsletter(){

        if(this.customer.isAbonat()){
            newspaperQueryService.afisare();
        }else{
            System.out.println("Nu sunteti abonat la acest newsletter");
        }

    }
}
