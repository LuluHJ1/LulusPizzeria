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
                    Pizza pizza = buildPizza();
                    order.addPizza(pizza);
                    break;
                case 2:
                    Drink drink = buildDrink();
                    order.addDrink(drink);
                    break;
                case 3:
                    order.addGarlicKnots(1);
                    System.out.println("Garlic knots added.");
                    break;
                case 4:
                    checkout(order);
                    ordering = false;
                    break;
                case 0:
                    System.out.println("Order canceled.");
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
    public Pizza  buildPizza() {

        System.out.println("\nSelect Pizza Size");
        System.out.println("1) Personal");
        System.out.println("2) Medium");
        System.out.println("3) Large");

        int sizeChoice = scanner.nextInt();
        Size size;

        switch (sizeChoice) {
            case 1:
                size = Size.PERSONAL;
                break;
            case 2:
                size = Size.MEDIUM;
                break;
            case 3:
                size = Size.LARGE;
                break;
            default:
                size = Size.PERSONAL;
        }
        System.out.println("Make it Stuffed Crust?");
        System.out.println("1) YES");
        System.out.println("2) NO");

        boolean stuffedCrust = scanner.nextInt() == 1;

        Pizza pizza = new Pizza(size,stuffedCrust);

        boolean adding = true;

        while(adding) {
            System.out.println("\nTOPPINGS");
            System.out.println("Meat: ");
            System.out.println("1) Pepperoni");
            System.out.println("2) Sausage");
            System.out.println("3) Ham");
            System.out.println("4) Chicken");
            System.out.println("Cheese: ");
            System.out.println("5) Mozzarella");
            System.out.println("6) Parmesan");
            System.out.println("Regular toppings: ");
            System.out.println("7 Bell Peppers)");
            System.out.println("8) Pineapple");
            System.out.println("Sauces");
            System.out.println("9) Marinera Sauce");
            System.out.println("0) Done");

            int toppingChoice = scanner.nextInt();

            switch(toppingChoice) {
                case 1:
                    pizza.addTopping(
                            new Topping(
                                    "Pepperoni",
                                    Topping.Type.MEAT,
                                    askExtra()
                            )
                    );
                    break;
                case 2:
                    pizza.addTopping(
                            new Topping(
                                    "Sausage",
                                    Topping.Type.MEAT,
                                    askExtra()
                            )
                    );
                case 3:
                    pizza.addTopping(
                            new Topping(
                                    "Ham",
                                    Topping.Type.MEAT,
                                    askExtra()
                            )
                    );
                case 4:
                    pizza.addTopping(
                            new Topping(
                                    "Chicken",
                                    Topping.Type.MEAT,
                                    askExtra()
                            )
                    );
                case 5:
                    pizza.addTopping(
                            new Topping(
                                    "Mozzarella",
                                    Topping.Type.CHEESE,
                                    askExtra()
                            )
                    );
                case 6:
                    pizza.addTopping(
                            new Topping(
                                    "Parmesan",
                                    Topping.Type.CHEESE,
                                    askExtra()
                            )
                    );
                case 7:
                    pizza.addTopping(
                            new Topping(
                                    "Bell Peppers",
                                    Topping.Type.REGULAR,
                                    askExtra()
                            )
                    );
                case 8:
                    pizza.addTopping(
                            new Topping(
                                    "Pineapple",
                                    Topping.Type.REGULAR,
                                    askExtra()
                            )
                    );
                case 9:
                    pizza.addTopping(
                            new Topping(
                                    "Marinera",
                                    Topping.Type.SAUCE,
                                    askExtra()
                            )
                    );
                case 0:
                    adding = false;
                    break;
            }
        }
        return pizza;
    }
    public boolean askExtra() {
        System.out.println("Extra topping?");
        System.out.println("1) YES");
        System.out.println("2) No");

        return scanner.nextInt() == 1;
    }
    public Drink buildDrink() {
        System.out.println("\nDrink Size");
        System.out.println("1) Small");
        System.out.println("2) Medium");
        System.out.println("3) Large");

        int choice = scanner.nextInt();

        DrinkSize size;

        switch (choice) {
            case 1:
                size = DrinkSize.SMALL;
                break;
            case 2:
                size = DrinkSize.MEDIUM;
                break;
            case 3:
                size = DrinkSize.LARGE;
                break;
            default:
                size = DrinkSize.LARGE;
        }
        scanner.nextLine();
        System.out.println("Enter flavor: ");
        String flavor = scanner.nextLine();

        return new Drink(flavor, size);

    }
    public void checkout(Order order) {
        System.out.println("\n===CHECKOUT===");
        System.out.println(order.formatReceipt());

        System.out.println("\n");
    }


}
