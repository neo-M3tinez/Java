## for the UI 

    // Method to create a new fruit and add it to the list
    // manager
    public void createFruit(ArrayList<Fruit> fl) {
        while (true) {
            System.out.print("\nEnter fruit id: ");
            String fruitId = Validate.inputString();

            // Check if ID contains only digits and is non-negative
            if (!fruitId.matches("\\d+")) {
                System.out.println("Invalid ID! ID must be a digit.");
                continue;
            }

            if (Integer.parseInt(fruitId) < 1) {
                System.out.println("Invalid ID! ID must be greater than 0.");
                continue;
            }

            // Check if the ID already exists
            if (!Validate.checkIdExist(fl, fruitId)) {
                System.out.println("Id existed");
                return;
            }

            System.out.print("Fruit name: ");
            String name = Validate.inputString();

            // Check if the name already exists in the list
            if (!Validate.checkDuplicateName(fl, name)) {
                System.out.println("Fruit name already exists. Please enter a different name.");
                continue;
            }

            System.out.print("Price: ");
            double price = Validate.inputDouble();
            System.out.print("Quantity: ");
            int quantity = Validate.inputNumberInRange(1, Integer.MAX_VALUE, "You must input a positive number!!!");
            System.out.print("Origin: ");
            String origin = Validate.inputString();

            // If the fruit with the same name, price, and origin exists, update its quantity
            if (!Validate.checkDuplicate(fl, name, origin, price)) {
                updateQuantityShop(fl, name, quantity);
                System.out.println("Updated " + name + " quantity!!!");
            } else {
                // Otherwise, create a new fruit
                fl.add(new Fruit(fruitId, name, quantity, price, origin));
            }

            if (!Validate.yesNo()) {



                // Method for allowing buyers to shop for fruits
    public void shopping(ArrayList<Fruit> fl, Hashtable<String, ArrayList<Order>> lh) {
        // Check if the fruit list is empty
        if (fl.isEmpty()) {
            System.out.println("\nThere are no fruits available for sale '_'");
            return;
        }

        // Check if there are any fruits available for sale
        boolean fruitsAvailable = false;
        for (Fruit fruit : fl) {
            if (fruit.getQuantity() > 0) {
                fruitsAvailable = true;
                break;
            }
        }

        if (!fruitsAvailable) {
            System.out.println("\nThere are no fruits available for sale '_'");
            return;
        }

        // Initialize an empty cart to store orders
        ArrayList<Order> cart = new ArrayList<>();

        // Continuously prompt the user to select fruits until they decide to stop
        while (true) {
            // Display the list of available fruits
            printFruitList(fl);

            // Prompt the user to select a fruit by its item number
            System.out.print("\nEnter item: ");
            int item = Validate.inputNumberInRange(1, fl.size(), "Out of items!!!");

            // Get the selected fruit based on the item number
            Fruit fruit = getFruitByItems(fl, item);

            
        if (fruit == null || fruit.getQuantity() == 0) {
            System.out.println("Selected fruit is not available.");
            break;
        }
            
            
            String selectedFruit = fruit.getFruitName();
            System.out.println("You selected: " + selectedFruit);

            // Prompt the user to enter the quantity of the selected fruit
            System.out.print("Enter quantity: ");
            int quantity = Validate.inputNumberInRange(1, fruit.getQuantity(), "There are " + fruit.getQuantity() + " left");

            // Update the quantity of the selected fruit in the shop's inventory
            fruit.setQuantity(fruit.getQuantity() - quantity);

            // If the selected fruit is already in the cart, update its quantity; otherwise, add it to the cart
            if (!Validate.checkItemsExist(cart, fruit.getFruitId())) {
                updateQuantityCustomer(cart, fruit.getFruitId(), quantity);
            } else {
                cart.add(new Order(fruit.getFruitId(), selectedFruit, fruit.getPrice(), quantity));
            }

            // Ask the user if they want to continue shopping
            if (!Validate.yesNo()) {
                break;
            }
        }

        // Display the order summary
        printOrderList(cart);

        // Prompt the user to enter their name
        System.out.print("\nEnter your name: ");
        String name = Validate.inputString();

        // Store the order under the customer's name in the hashtable
        lh.put(name, cart);
        System.out.println("Order added successfully!!!\n");
    }

    // Method to print the list of fruits available for purchase
    public void printFruitList(ArrayList<Fruit> fl) {
        int count = 1;
        System.out.printf("%-10s%-20s%-20s%-15s\n", "Items", "Fruit name", "Country", "Price");
        for (Fruit fruit : fl) {
            if (fruit.getQuantity() != 0) {
                System.out.printf("%-10d%-20s%-20s%.0f$\n", count++, fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice());
            }
        }
    }

    // Method to print the list of orders along with the total amount
    public void printOrderList(ArrayList<Order> lo) {
        // Initialize total amount
        double total = 0;

        // Print headers for the order list
        System.out.printf("%-15s%-15s%-15s%-15s\n", "Product", "Quantity", "Price", "Amount");

        // Iterate over each order in the list
        for (Order cart : lo) {
            // Check if the quantity is not zero (to avoid printing empty orders)
            if (cart.getQuantity() != 0) {
                // Print order details: product name, quantity, price, and total amount for the item
                System.out.printf("%-15s%-15d%.0f$%14.0f$\n", cart.getProduct(), cart.getQuantity(), cart.getPrice(), cart.getPrice() * cart.getQuantity());

                // Accumulate the total amount by multiplying price with quantity for each order
                total += cart.getPrice() * cart.getQuantity();
            }
        }
        // Print the total amount of all orders
        System.out.println("\nTotal: " + total + "$");

    }

    // Method to retrieve a fruit by its ID
    public Fruit getFruitByID(ArrayList<Fruit> fl, String id) {
        for (Fruit fruit : fl) {
            if (id.equalsIgnoreCase(fruit.getFruitId())) {
                return fruit;
            }
        }
        return null;
    }

    // Method to get a fruit by its position in the list
    public Fruit getFruitByItems(ArrayList<Fruit> lf, int item) {
        int countItemsLeft = 1;
        for (Fruit fruit : lf) {
            if (fruit.getQuantity() != 0) {
                if (countItemsLeft == item) {
                    return fruit;
                }
                countItemsLeft++;

                return;
            }
        }
    }



## validate 

    // Method to check if an ID exists in a list of fruits
    public static boolean checkIdExist(ArrayList<Fruit> lf, String id) {
        for (Fruit fruit : lf) {
            if(id.equalsIgnoreCase(fruit.getFruitId())) {
                return false;
            }
        }
        return true;
    }
    
    // Method to check if an item exists in a list of orders
    public static boolean checkItemsExist(ArrayList<Order> lo, String id) {
        for (Order order : lo) {
            if(id.equalsIgnoreCase(order.getId())) {
                return false;
            }
        }
        return true;
    }
    
    // Method to check if a fruit with the same name, origin, and price already exists in a list
    public static boolean checkDuplicate(ArrayList<Fruit> lf, String name, String origin, double price) {
        for (Fruit fruit : lf) {
            if(name.equalsIgnoreCase(fruit.getFruitName()) 
                    && origin.equalsIgnoreCase(fruit.getOrigin())
                    && price == fruit.getPrice()) {
                return false;
            }               
        }
        return true;
    }
    
    // Method to check if a fruit with the same name already exists in a list
    public static boolean checkDuplicateName(ArrayList<Fruit> lf, String name) {
        for (Fruit fruit : lf) {
            if (name.equalsIgnoreCase(fruit.getFruitName())) {
                return false;
            }
        }
        return true;
    }
