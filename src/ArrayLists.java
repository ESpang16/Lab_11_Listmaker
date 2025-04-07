import java.util.ArrayList;
import java.util.Scanner;
public class ArrayLists {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> myArrlist = new ArrayList<>();
        boolean quit = false;
        do {
            displayList(myArrlist);
            String choice = getMenuChoice(in);
            switch (choice) {
                case "A":
                    addItem(myArrlist, in);
                    break;
                case "I":
                    insertItem(myArrlist, in);
                    break;
                case "D":
                    deleteItem(myArrlist, in);
                    break;
                case "P":
                    displayList(myArrlist);
                    break;
                case "Q":
                    if (SafeInput.getYNConfirm(in, "Are you sure you want to quit?")) {
                        quit = true;
                        System.out.println("Goodbye!");
                    }
                    break;
            }
        } while (!quit);
    }

    public static void displayList(ArrayList<String> list) {
        System.out.println("\n=== Current List ===");
        if (list.isEmpty()) {
            System.out.println("[List is empty]");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, list.get(i));
            }
        }
    }

    public static String getMenuChoice(Scanner in) {
        System.out.println("\n=== Menu ===");
        System.out.println("A - Add\nI - Insert\nD - Delete\nP - Print\nQ - Quit");
        return SafeInput.getRegExString(in, "Enter your choice", "[AaIiDdPpQq]").toUpperCase();
    }

    public static void addItem(ArrayList<String> list, Scanner in) {
        String item = SafeInput.getNonZeroLengthString(in, "Enter item to add");
        list.add(item);
        System.out.println("Item added!");
    }

    public static void insertItem(ArrayList<String> list, Scanner in) {
        int index = list.isEmpty() ? 0 : SafeInput.getRangedInt(in, "Enter position to insert at", 1, list.size() + 1) - 1;
        String item = SafeInput.getNonZeroLengthString(in, "Enter item to insert");
        list.add(index, item);
        System.out.println("Item inserted!");
    }

    public static void deleteItem(ArrayList<String> list, Scanner in) {
        if (list.isEmpty()) {
            System.out.println("List is empty. Nothing to delete.");
        } else {
            int index = SafeInput.getRangedInt(in, "Enter number of item to delete", 1, list.size()) - 1;
            String removed = list.remove(index);
            System.out.println("Removed: " + removed);
        }
    }
}
