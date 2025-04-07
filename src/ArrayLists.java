import java.util.ArrayList;
import java.util.Scanner;

public class ArrayLists {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> myArrList = new ArrayList<>();
        boolean running = true;

        while (running) {
            displayListAndMenu(myArrList);
            String choice = SafeInput.getRegExString(in, "Choose a menu option", "^[AaDdIiPpQq]$").toUpperCase();

            switch (choice) {
                case "A":
                    addToList(myArrList);
                    break;
                case "D":
                    deleteFromList(myArrList);
                    break;
                case "I":
                    addAtIndex(myArrList);
                    break;
                case "P":
                    printList(myArrList);
                    break;
                case "Q":
                    boolean confirmQuit = SafeInput.getYNConfirm(in, "Are you sure you want to quit?");
                    if (confirmQuit) {
                        running = false;
                        System.out.println("Goodbye!");
                    }
                    break;
            }
        }
    }

    public static void displayListAndMenu(ArrayList<String> myArrList) {
        System.out.println("\nCurrent List:");
        if (myArrList.isEmpty()) {
            System.out.println("  [List is empty]");
        } else {
            displayNumberedList(myArrList);
        }

        System.out.println("\nMenu Options:");
        System.out.println("[A] Add");
        System.out.println("[D] Delete");
        System.out.println("[I] Insert at Index");
        System.out.println("[P] Print List");
        System.out.println("[Q] Quit");
    }

    public static void displayNumberedList(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, list.get(i));
        }
    }

    public static void addToList(ArrayList<String> myArrList) {
        Scanner in = new Scanner(System.in);
        String item = SafeInput.getNonZeroLengthString(in, "Enter item to add to list:");
        myArrList.add(item);
        System.out.println("Item added!");
    }

    public static void deleteFromList(ArrayList<String> myArrList) {
        Scanner in = new Scanner(System.in);
        if (myArrList.isEmpty()) {
            System.out.println("Nothing to delete - list is empty.");
            return;
        }
        displayNumberedList(myArrList);
        int choice = SafeInput.getRangedInt(in, "Enter item number to delete:", 1, myArrList.size());
        myArrList.remove(choice - 1);
        System.out.println("Item deleted!");
    }

    public static void addAtIndex(ArrayList<String> myArrList) {
        Scanner in = new Scanner(System.in);
        displayNumberedList(myArrList);
        int index = SafeInput.getRangedInt(in, "Enter index to insert at (1 to " + (myArrList.size() + 1) + "):", 1, myArrList.size() + 1) - 1;
        String item = SafeInput.getNonZeroLengthString(in, "Enter item to insert:");
        myArrList.add(index, item);
        System.out.println("Item inserted!");
    }

    public static void printList(ArrayList<String> myArrList) {
        if (myArrList.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("Current List:");
            displayNumberedList(myArrList);
        }
    }
}