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
    public void modifyGroceryList(int position, String newItem) {
        try {
            String toBeUpdated = groceryList.get(position);
            groceryList.set(position, formatString(newItem));
            System.out.print("Grocery item number " + (position+1) + " has been modified ");
            System.out.println("from " + toBeUpdated + " to: " + groceryList.get(position) + ".");
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println("Item number: " + (position+1) + ", you are trying to modify is not present in the list.");
        } 
    }

    // To remove an item which is already present in the grocery list.
    public void removeGroceryItem(int position) {
        try {
            String theItem = groceryList.get(position);
            groceryList.remove(position);
            System.out.println(theItem + " is removed from the list.");
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println("Item number: " + (position+1) + ", you are trying to remove is not present in the list.");
        } 
    }

    // To search for an item in the grocery list.
    public String findItem(String searchItem) {
        int position = groceryList.indexOf(formatString(searchItem));
        if(position >= 0) {
            return groceryList.get(position);
        }
        return null;
    }
}