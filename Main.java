import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);


    // Creating the grocery list object.
    private static GroceryList groceryList = new GroceryList();


    // To print the instructions to user.
    private static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print the choice options.");
        System.out.println("\t 1 - To print the list of grocery items.");
        System.out.println("\t 2 - To add an item to the list.");
        System.out.println("\t 3 - To modify and item in the list.");
        System.out.println("\t 4 - To remove an item from the list.");
        System.out.println("\t 5 - To search for an item in the list.");
        System.out.println("\t 6 - To quit the application.");
    }


    // To add an item to grocery list.
    public static void addItem() {
        System.out.print("Please enter the grocery item: ");
        groceryList.addGroceryItem(sc.nextLine());
    }


    // To modify an item already present in the grocery list.
    public static void modifyItem() {
        System.out.print("Enter the item you want to modify: ");
        String currentItem = sc.nextLine();

        System.out.print("Enter replacement item: ");
        String newItem = sc.nextLine();

        groceryList.modifyGroceryItem(currentItem, newItem);
    }


    // To remove an item which is already present in the grocery list.
    public static void removeItem() {
        System.out.print("Enter item you want to remove: ");
        String item = sc.nextLine();

        groceryList.removeGroceryItem(item);
    }
    

    // To search for an item in the grocery list.
    public static void searchItem() {
        System.out.print("Item to search for: ");
        String searchItem = sc.nextLine();

        groceryList.searchItem(searchItem);
    }


    public static void main(String[] args) {
        boolean quit = false;

        printInstructions();
        // Infinite loop until user wants to exit from it.
        while(!quit) {
            System.out.print("\nEnter your choice: ");
            // Restricting user to enter only integer numbers as choice.
            while (!sc.hasNextInt()) {
                sc.nextLine(); // to clear the buffer.
                System.out.println("Error: Choice you entered should be an integer number only.\n");
                System.out.print("Enter your choice again: ");
            }
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchItem();
                    break;
                case 6:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid Choice. Please choose the correct option.");
                    break;
            }
        }
    }
}