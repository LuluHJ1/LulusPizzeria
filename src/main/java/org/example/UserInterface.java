package org.example;

import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    public void display() {


        boolean ordering = true;
        while(ordering) {
            System.out.println("WELCOME TO LULU'S PIZZERIA");
            System.out.println("==========================");
            System.out.println("1) New Order");
            System.out.println("0) Exit");

            int choice = scanner.nextInt();

            switch(choice) {

                case 1:
                    Order order = new Order();
                    showOrderScreen(order);
                    break;

                case 0:
                    ordering = false;
                    System.out.println("Goodbye.");
                    break;

                default:
                    System.out.println("Invalid option.");

            }
        }
    }
    public void showOrderScreen(Order order) {
        boolean ordering = true;

        while(ordering) {

            System.out.println("ORDER SCREEN");
            System.out.println("==============");
            System.out.println("1) Add Pizza");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Garlic Knots");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order"); //go back to home page

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:

            }
        }
    }
}
