import java.util.ArrayList;

public class GroceryList {
    // Creatinf an ArrayList to store our grocery items.
    private ArrayList<String> groceryList = new ArrayList<String>();


    // To format the user entered string to required format.
    // Which is first letter capital and all remaining small.
    private static String formatString(String s) {
        char[] array = s.toCharArray();
        
        for(int i=0; i<array.length; i++) {
            char ch = array[i];
            if(i==0 && ch>='a' && ch<='z') {
                array[i] = (char) (ch-32);
            }
            else if(i!=0 && ch>='A' && ch<='Z') {
                array[i] = (char) (ch+32);
            }
        } 

        return new String(array);
    }


    // To add an item to our grocery list.
    public void addGroceryItem(String item) {
        groceryList.add(formatString(item));
        System.out.println(item + " added to list.");
    }


    // To print all the items of the grocery list.
    public void printGroceryList() {
        System.out.println("You have " + groceryList.size() + " items in your grocery list.");

        for(int i=0; i<groceryList.size(); i++) {
            System.out.println((i+1) + ". " + groceryList.get(i));
        }
    }


    // To modify an item which is already present in the grocery list.
    public void modifyGroceryItem(String currentItem, String newItem) {
        int position = findItem(currentItem);

        if(position >= 0) {
            modifyGroceryItem(position, formatString(newItem));
            System.out.println(currentItem + " has been modified to: " + newItem);
        }
        else {
            System.out.println("Error: "+ currentItem + " is not present in the grocery list.");
        }
    }
    private void modifyGroceryItem(int position, String newItem) {
        groceryList.set(position, newItem);
    }


    // To remove an item which is already present in the grocery list.
    public void removeGroceryItem(String item) {
        int position = findItem(item);

        if(position >= 0) {
            removeGroceryItem(position);
            System.out.println(item + " is removed from the grocery list.");
        }
        else {
            System.out.println("Error: " + item + " is not present in the grocery list.");
        }
    }
    private void removeGroceryItem(int position) {
        groceryList.remove(position);
    }


    // To search for an item in the grocery list.
    public void searchItem(String searchItem) {
        int position = findItem(searchItem);

        if(position >= 0) {
            System.out.println("Found " + searchItem + " in our grocery list");
        }
        else {    
            System.out.println("Error: " + searchItem + " is not in the grocery list");
        }
    }

    // To search for an item in the grocery list, using this method internally only.
    private int findItem(String searchItem) {
        return groceryList.indexOf(formatString(searchItem));
    }
}