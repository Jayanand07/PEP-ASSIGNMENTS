package Assignment.Assignment3;

public class Main {

    public static void printList(MyList<?> list) {
        System.out.print("List contents: [");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.println("Size: " + list.size());
    }

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("   CUSTOM LIST FRAMEWORK DEMONSTRATION");
        System.out.println("==========================================\n");

        System.out.println("--- Testing MyArrayList with Integers ---");
        MyList<Integer> arrayList = new MyArrayList<>();

        try {
            arrayList.add(10);
            arrayList.add(20);
            arrayList.add(30);
            System.out.println("Added: 10, 20, 30");
            printList(arrayList);

            arrayList.insert(15, 1);
            System.out.println("\nInserted 15 at index 1");
            printList(arrayList);

            System.out.println("\nElement at index 2: " + arrayList.get(2));

            arrayList.delete(0);
            System.out.println("\nDeleted element at index 0");
            printList(arrayList);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("ArrayList operations completed!\n");
        }

        System.out.println("--- Testing MyLinkedList with Strings ---");
        MyList<String> linkedList = new MyLinkedList<>();

        try {
            linkedList.add("Apple");
            linkedList.add("Banana");
            linkedList.add("Cherry");
            System.out.println("Added: Apple, Banana, Cherry");
            printList(linkedList);

            linkedList.insert("Mango", 1);
            System.out.println("\nInserted Mango at index 1");
            printList(linkedList);

            System.out.println("\nElement at index 2: " + linkedList.get(2));

            linkedList.delete(2);
            System.out.println("\nDeleted element at index 2");
            printList(linkedList);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("LinkedList operations completed!\n");
        }

        System.out.println("--- Testing Exception Handling ---");
        MyList<Double> testList = new MyArrayList<>();

        try {
            System.out.println("Trying to get from empty list...");
            testList.get(0);
        } catch (IllegalStateException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }

        try {
            testList.add(1.5);
            testList.add(2.5);
            System.out.println("\nAdded 1.5 and 2.5");
            System.out.println("Trying to access index 10...");
            testList.get(10);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }

        try {
            System.out.println("\nTrying to insert at invalid index -1...");
            testList.insert(5.0, -1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        } finally {
            System.out.println("\nException handling demonstration completed!");
        }

        System.out.println("\n==========================================");
        System.out.println("   END OF DEMONSTRATION");
        System.out.println("==========================================");
    }
}
