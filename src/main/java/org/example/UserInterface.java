package org.example;

import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);

    public void display() {

        boolean ordering = true;
        while (ordering) {
            System.out.println("WELCOME TO LULU'S PIZZERIA");
            System.out.println("==========================");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.println("Enter Number: ");

            try {
                int choice = scanner.nextInt();

                switch (choice) {

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
            } catch (Exception e) {
                System.out.println("Invalid input.");
                scanner.nextLine();
            }
        }
    }

    public void showOrderScreen(Order order) {
        boolean ordering = true;

        while (ordering) {

            System.out.println("ORDER SCREEN");
            System.out.println("==========================");
            System.out.println("1) Add Pizza");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Garlic Knots");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order"); //go back to home page
            System.out.println("Enter Number: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

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
                        addGarlicKnots(order);
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
            } catch (Exception e) {
                System.out.println("Please enter number.");
                scanner.nextLine();
            }
        }
    }

    public Pizza buildPizza() {

        System.out.println("\nSelect Pizza Size");
        System.out.println("==========================");
        System.out.println("1) Personal");
        System.out.println("2) Medium");
        System.out.println("3) Large");
        System.out.println("Enter Number: ");

        Size size = Size.PERSONAL;
        boolean stuffedCrust = false;

        try {
            int sizeChoice = scanner.nextInt();
            scanner.nextLine();

            size = switch (sizeChoice) {
                case 1 -> Size.PERSONAL;
                case 2 -> Size.MEDIUM;
                case 3 -> Size.LARGE;
                default -> Size.PERSONAL;
            };
        } catch (Exception e) {
            System.out.println("Not valid option");
            scanner.nextLine();
        }
        try {

            System.out.println("Make it Stuffed Crust?");
            System.out.println("==========================");
            System.out.println("1) YES");
            System.out.println("2) NO");
            System.out.println("Enter Number: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                stuffedCrust = true;
            } else {
                stuffedCrust = false;
            }
        } catch (Exception e) {
            System.out.println("Invalid input.");
            scanner.nextLine();
        }
        Pizza pizza = new Pizza(size, stuffedCrust);
        boolean adding = true;
        while (adding) {
            System.out.println("\nTOPPINGS: ");
            System.out.println("==========================");
            System.out.println("Meat: ");
            System.out.println("1) Pepperoni");
            System.out.println("2) Sausage");
            System.out.println("3) Ham");
            System.out.println("4) Chicken");
            System.out.println();
            System.out.println("Premium Cheeses: ");
            System.out.println("5) Mozzarella");
            System.out.println("6) Parmesan");
            System.out.println();
            System.out.println("Regular toppings (free): ");
            System.out.println("7) Bell Peppers");
            System.out.println("8) Pineapple");
            System.out.println();
            System.out.println("Sauces (free)");
            System.out.println("9) Marinara Sauce");
            System.out.println();
            System.out.println("Condiments(free)");
            System.out.println("10) Red Pepper Flakes");
            System.out.println();
            System.out.println("0) Done");
            System.out.println();
            System.out.println("Enter Number: ");

            try {
                int toppingChoice = scanner.nextInt();
                scanner.nextLine();

                switch (toppingChoice) {
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
                        break;
                    case 3:
                        pizza.addTopping(
                                new Topping(
                                        "Ham",
                                        Topping.Type.MEAT,
                                        askExtra()
                                )
                        );
                        break;
                    case 4:
                        pizza.addTopping(
                                new Topping(
                                        "Chicken",
                                        Topping.Type.MEAT,
                                        askExtra()
                                )
                        );
                        break;
                    case 5:
                        pizza.addTopping(
                                new Topping(
                                        "Mozzarella",
                                        Topping.Type.CHEESE,
                                        askExtra()
                                )
                        );
                        break;
                    case 6:
                        pizza.addTopping(
                                new Topping(
                                        "Parmesan",
                                        Topping.Type.CHEESE,
                                        askExtra()
                                )
                        );
                        break;
                    case 7:
                        pizza.addTopping(
                                new Topping(
                                        "Bell Peppers",
                                        Topping.Type.REGULAR,
                                        askExtra()
                                )
                        );
                        break;
                    case 8:
                        pizza.addTopping(
                                new Topping(
                                        "Pineapple",
                                        Topping.Type.REGULAR,
                                        askExtra()
                                )
                        );
                        break;
                    case 9:
                        pizza.addTopping(
                                new Topping(
                                        "Marinara",
                                        Topping.Type.SAUCE,
                                        askExtra()
                                )
                        );
                        break;
                    case 10:
                        pizza.addTopping(
                                new Topping(
                                        "Red Pepper Flakes",
                                        Topping.Type.SIDE,
                                        askExtra()
                                )
                        );
                        break;

                    case 0:
                        adding = false;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
                scanner.nextLine();
            }
        }
        return pizza;
    }

    public boolean askExtra() {

        while (true) {
            System.out.println("Add extra of this topping?");
            System.out.println("==========================");
            System.out.println("1) YES");
            System.out.println("2) NO");
            System.out.println("Enter Number");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1) {
                    return true;
                } else if (choice == 2) {
                    return false;
                } else {
                    System.out.println("Invalid option.");
                }

            } catch (Exception e) {
                System.out.println("Invalid input");
                scanner.nextLine();
            }
        }
    }

    public Drink buildDrink() {
        System.out.println("\nSelect Drink Size");
        System.out.println("==========================");
        System.out.println("1) Small");
        System.out.println("2) Medium");
        System.out.println("3) Large");

        try {

            int choice = scanner.nextInt();
            scanner.nextLine();

            DrinkSize size = switch (choice) {
                case 1 -> DrinkSize.SMALL;
                case 2 -> DrinkSize.MEDIUM;
                case 3 -> DrinkSize.LARGE;
                default -> DrinkSize.LARGE;
            };

            scanner.nextLine();
            System.out.println("Enter flavor: ");
            String flavor = scanner.nextLine();

            return new Drink(flavor, size);

        } catch (Exception e) {
            System.out.println("Invalid input. Defaulting to large.");
            scanner.nextLine();
            return new Drink("Unknown flavor", DrinkSize.LARGE);
        }
    }
        public void addGarlicKnots(Order order) {
            System.out.println("GARLIC KNOTS");
            System.out.println("==========================");
            System.out.println("How many orders of garlic knots?");

            try {
                int quantity = scanner.nextInt();
                scanner.nextLine();

                if(quantity > 0) {
                    order.addGarlicKnots(quantity);
                }else {
                    System.out.println("Quantity must be positive");
                }
            } catch (Exception e) {
                System.out.println("Invalid input.");
                scanner.nextLine();
            }
        }
            public void checkout(Order order) {

        boolean checkingOut = true;

        while (checkingOut) {
            System.out.println("CHECKOUT");
            System.out.println("==========================");
            System.out.println(order.formatReceipt());

            System.out.println("1) Confirm");
            System.out.println("2) Cancel");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                ReceiptManager.saveReceipt(order);

                checkingOut = false;
            } else if (choice == 2) {
                System.out.println("Order Canceled");
                checkingOut = false;
            } else {
                System.out.println("Not valid option");
            }
        }
    }
}