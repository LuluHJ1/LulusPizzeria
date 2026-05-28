package org.example;

import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    public static final String RESET = "\u001B[0m";
    public static final String BLUE = "\u001B[34m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";

    public void display() {

        boolean ordering = true;

        while (ordering) {
            System.out.println(BLUE + "WELCOME TO LULU'S PIZZERIA");
            System.out.println("==========================" + RESET);
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.println("Enter Number: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    case 1:
                        Order order = new Order();
                        showOrderScreen(order);
                        break;

                    case 0:
                        ordering = false;
                        System.out.println(BLUE + "Goodbye." + RESET);
                        break;

                    default:
                        System.out.println(RED + "Invalid option." + RESET);

                }
            } catch (Exception e) {
                System.out.println(RED + "Invalid input." + RESET);
                scanner.nextLine();
            }
        }
    }

    public void showOrderScreen(Order order) {
        boolean ordering = true;

        while (ordering) {

            System.out.println(BLUE + "ORDER SCREEN");
            System.out.println("==========================" + RESET);
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
                        System.out.println(GREEN + "Pizza added." + RESET);
                        break;
                    case 2:
                        Drink drink = buildDrink();
                        order.addDrink(drink);
                        System.out.println(GREEN + "Drink added." + RESET);
                        break;
                    case 3:
                        addGarlicKnots(order);
                        System.out.println(GREEN + "Garlic knots added." + RESET);
                        break;
                    case 4:
                        checkout(order);
                        ordering = false;
                        break;
                    case 0:
                        System.out.println(BLUE + "Order canceled."+ RESET);
                        ordering = false;
                        break;
                    default:
                        System.out.println(RED + "Invalid option" + RESET);
                }
            } catch (Exception e) {
                System.out.println(RED + "Please enter number." + RESET);
                scanner.nextLine();
            }
        }
    }

    public Pizza buildPizza() {

        System.out.println(BLUE + "Select Pizza Size");
        System.out.println("==========================" + RESET);
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
            System.out.println(RED + "Not valid option" + RESET);
            scanner.nextLine();
        }
        try {

            System.out.println(BLUE + "Make it Stuffed Crust?" );
            System.out.println("==========================" + RESET);
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
            System.out.println(RED + "Invalid input." + RESET);
            scanner.nextLine();
        }
        Pizza pizza = new Pizza(size, stuffedCrust);
        boolean adding = true;

        while (adding) {
            System.out.println(BLUE + "TOPPINGS: ");
            System.out.println("==========================" + RESET);
            System.out.println("1) Premium Meats");
            System.out.println("2) Premium Cheeses");
            System.out.println("3) Sauces");
            System.out.println("4) Regular Toppings");
            System.out.println("5) Sides");
            System.out.println("6) Crust");
            System.out.println("0) Done");
            System.out.println("Enter Number: ");

            try {
                int toppingChoice = scanner.nextInt();
                scanner.nextLine();

                switch (toppingChoice) {
                    case 1 -> addMeat(pizza);
                    case 2 -> addCheese(pizza);
                    case 3 -> addSauce(pizza);
                    case 4 -> addRegular(pizza);
                    case 5 -> addSide(pizza);
                    case 6 -> addCrust(pizza);
                    case 0 -> adding = false;
                    default -> System.out.println(RED + "Invalid option" + RESET);
                }
            } catch (Exception e) {
                System.out.println(RED + "Invalid input" + RESET);
                scanner.nextLine();
            }
        }
           return pizza;
         }
    public void addMeat(Pizza pizza) {

        boolean adding = true;

        while (adding) {
            System.out.println(BLUE + "MEATS");
            System.out.println("==========================" + RESET);
            System.out.println("1) Pepperoni");
            System.out.println("2) Sausage");
            System.out.println("3) Ham");
            System.out.println("4) Bacon");
            System.out.println("5) Chicken");
            System.out.println("6) Meatball");
            System.out.println("0) Done adding meats.");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> pizza.addTopping(new Topping("Pepperoni", Topping.Type.MEAT, askExtra()));
                    case 2 -> pizza.addTopping(new Topping("Sausage", Topping.Type.MEAT, askExtra()));
                    case 3 -> pizza.addTopping(new Topping("Ham", Topping.Type.MEAT, askExtra()));
                    case 4 -> pizza.addTopping(new Topping("Bacon", Topping.Type.MEAT, askExtra()));
                    case 5 -> pizza.addTopping(new Topping("Chicken", Topping.Type.MEAT, askExtra()));
                    case 6 -> pizza.addTopping(new Topping("Meatball", Topping.Type.MEAT, askExtra()));
                    case 0 -> adding = false;
                    default -> System.out.println(RED + "Invalid option" + RESET);
                }
            } catch (Exception e) {
                System.out.println(RED + "Invalid option" + RESET);
                scanner.nextLine();
            }
        }
    }
    public void addCrust(Pizza pizza) {
        System.out.println(BLUE + "CRUST OPTION");
        System.out.println("==========================" + RESET);
        System.out.println("1) Thin");
        System.out.println("2) Regular");
        System.out.println("3) Thick");
        System.out.println("4) Cauliflower");
        System.out.println("0) Back");

        try {
            int choice = scanner.nextInt();
            scanner.nextLine();

            CrustType crustType = switch (choice) {
                case 1 -> CrustType.THIN;
                case 2 -> CrustType.REGULAR;
                case 3 -> CrustType.THICK;
                case 4 -> CrustType.CAULIFLOWER;
                case 0 -> CrustType.REGULAR;
                default -> CrustType.REGULAR;
            };
            pizza.setCrustType(crustType);
        } catch (Exception e) {
            System.out.println(RED + "Not valid option. Defaulting to regular" + RESET);
            scanner.nextLine();
        }
    }
    public void addCheese (Pizza pizza) {
        System.out.println(BLUE + "CHEESE");
        System.out.println("==========================" + RESET);
        System.out.println("1) Mozzarella");
        System.out.println("2) Parmesan");
        System.out.println("3) Ricotta");
        System.out.println("4) Goat Cheese");
        System.out.println("5) Buffalo");
        System.out.println("0) None");

        try {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> pizza.addTopping(new Topping("Mozzarella", Topping.Type.CHEESE, askExtra()));
                case 2 -> pizza.addTopping(new Topping("Parmesan", Topping.Type.CHEESE, askExtra()));
                case 3 -> pizza.addTopping(new Topping("Ricotta", Topping.Type.CHEESE, askExtra()));
                case 4 -> pizza.addTopping(new Topping("Goat Cheese", Topping.Type.CHEESE, askExtra()));
                case 5 -> pizza.addTopping(new Topping("Buffalo", Topping.Type.CHEESE, askExtra()));
                case 0 -> {}
                default -> System.out.println(RED + "Invalid option" + RESET);
            }
        } catch (Exception e) {
            System.out.println(RED + "Invalid option" + RESET);
            scanner.nextLine();
        }
    }
    public void addRegular (Pizza pizza) {
        System.out.println(BLUE + "REGULAR TOPPINGS");
        System.out.println("==========================" + RESET);
        System.out.println("1) Onions");
        System.out.println("2) Mushrooms");
        System.out.println("3) Bell Peppers");
        System.out.println("4) Olives");
        System.out.println("5) Tomatoes");
        System.out.println("6) Spinach");
        System.out.println("7) Basil");
        System.out.println("8) Pineapple");
        System.out.println("9) Anchovies");
        System.out.println("0) None");

        try {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> pizza.addTopping(new Topping("Onions", Topping.Type.REGULAR, askExtra()));
                case 2 -> pizza.addTopping(new Topping("Mushrooms", Topping.Type.REGULAR, askExtra()));
                case 3 -> pizza.addTopping(new Topping("Bell Peppers", Topping.Type.REGULAR, askExtra()));
                case 4 -> pizza.addTopping(new Topping("Olives", Topping.Type.REGULAR, askExtra()));
                case 5 -> pizza.addTopping(new Topping("Tomatoes", Topping.Type.REGULAR, askExtra()));
                case 6 -> pizza.addTopping(new Topping("Spinach", Topping.Type.REGULAR, askExtra()));
                case 7 -> pizza.addTopping(new Topping("Basil", Topping.Type.REGULAR, askExtra()));
                case 8 -> pizza.addTopping(new Topping("Pineapple", Topping.Type.REGULAR, askExtra()));
                case 9 -> pizza.addTopping(new Topping("Anchovies", Topping.Type.REGULAR, askExtra()));
                case 0 -> {}
                default -> System.out.println(RED + "Invalid option" + RESET);
            }
        } catch (Exception e) {
            System.out.println(RED + "Invalid option" + RESET);
            scanner.nextLine();
        }

    }

    public void addSauce (Pizza pizza) {
        System.out.println(BLUE + "SAUCES");
        System.out.println("==========================" + RESET);
        System.out.println("1) Marinara");
        System.out.println("2) Alfredo");
        System.out.println("3) Pesto");
        System.out.println("4) BBQ");
        System.out.println("5) Buffalo");
        System.out.println("6) Olive oil");

        try {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> pizza.addTopping(new Topping("Marinara", Topping.Type.SAUCE, askExtra()));
                case 2 -> pizza.addTopping(new Topping("Alfredo", Topping.Type.SAUCE, askExtra()));
                case 3 -> pizza.addTopping(new Topping("Pesto", Topping.Type.SAUCE, askExtra()));
                case 4 -> pizza.addTopping(new Topping("BBQ", Topping.Type.SAUCE, askExtra()));
                case 5 -> pizza.addTopping(new Topping("Buffalo", Topping.Type.SAUCE, askExtra()));
                case 6 -> pizza.addTopping(new Topping("Olive Oil", Topping.Type.SAUCE, askExtra()));
                case 0 -> {}
                default -> System.out.println(RED + "Invalid option" + RESET);
            }
        } catch (Exception e) {
            System.out.println(RED + "Invalid option" + RESET);
            scanner.nextLine();
        }

    }
    public void addSide(Pizza pizza) {
        System.out.println(BLUE + "SIDES");
        System.out.println("==========================" + RESET);
        System.out.println("1) Red Pepper Flakes");
        System.out.println("2) Parmesan Packet");

        try {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> pizza.addTopping(new Topping("Red Pepper Flakes", Topping.Type.SIDE, askExtra()));
                case 2 -> pizza.addTopping(new Topping("Parmesan Packet", Topping.Type.SIDE, askExtra()));
                case 0 -> {}
                default -> System.out.println(RED + "Invalid option" + RESET);
            }
        } catch (Exception e) {
            System.out.println(RED + "Invalid option" + RESET);
            scanner.nextLine();
        }
    }

    public boolean askExtra() {

        while (true) {
            System.out.println(BLUE + "Add extra of this topping?");
            System.out.println("==========================" + RESET);
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
                    System.out.println(RED + "Invalid option." + RESET);
                }

            } catch (Exception e) {
                System.out.println(RED + "Invalid input" + RESET);
                scanner.nextLine();
            }
        }
    }

    public Drink buildDrink() {
        System.out.println(BLUE + "Select Drink Size");
        System.out.println("==========================" + RESET);
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

            System.out.println(BLUE + "Enter flavor: " + RESET);
            String flavor = scanner.nextLine();

            return new Drink(flavor, size);

        } catch (Exception e) {
            System.out.println(RED + "Invalid input. Defaulting to large." + RESET);
            scanner.nextLine();
            return new Drink("Unknown flavor", DrinkSize.LARGE);
        }
    }
        public void addGarlicKnots(Order order) {
            System.out.println(BLUE + "GARLIC KNOTS");
            System.out.println("==========================" + RESET);
            System.out.println("How many orders of garlic knots?");

            try {
                int quantity = scanner.nextInt();
                scanner.nextLine();

                if(quantity > 0) {
                    order.addGarlicKnots(quantity);
                }else {
                    System.out.println(RED + "Quantity must be positive" + RESET);
                }
            } catch (Exception e) {
                System.out.println(RED + "Invalid input." + RESET);
                scanner.nextLine();
            }
        }
            public void checkout(Order order) {

        boolean checkingOut = true;

        while (checkingOut) {
            System.out.println(BLUE + "CHECKOUT");
            System.out.println("==========================" + RESET);
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
                System.out.println(RED + "Not valid option" + RESET);
            }
        }
    }
}