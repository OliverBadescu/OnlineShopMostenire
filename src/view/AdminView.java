package view;

import order_details.service.OrderDetailsService;
import orders.service.OrderService;
import products.service.ProductService;
import reviews.service.ReviewService;
import users.derivate.Admin;
import users.service.UserService;

import java.util.Scanner;

public class AdminView {

    private Admin admin;
    private OrderService orderService;
    private OrderDetailsService orderDetailsService;
    private ProductService productService;
    private ReviewService reviewService;
    private Scanner scanner;
    private UserService userService;


    public AdminView(Admin admin){
        this.admin = admin;
        this.userService = new UserService();
        this.orderService = new OrderService();
        this.orderDetailsService = new OrderDetailsService();
        this.productService = new ProductService();
        this.reviewService = new ReviewService();
        this.scanner = new Scanner(System.in);

        this.play();
    }

    private void meniu(){

    }
    private void play(){

        boolean running = true;

        while(running ) {
            meniu();
            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere) {

            }
        }
    }
}
