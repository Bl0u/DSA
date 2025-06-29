package ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * This class demonstrates various operations and features of Java ArrayList.
 * It includes examples of different constructors, adding elements, removing elements,
 * searching, and other ArrayList operations.
 */
public class ArrayListTest {

    public static void main(String[] args) {
        // Divider for cleaner output
        String divider = "\n" + "=".repeat(50) + "\n";

        System.out.println(divider + "SECTION 1: ARRAYLIST CONSTRUCTORS" + divider);
        demonstrateConstructors();

        System.out.println(divider + "SECTION 2: ADDING ELEMENTS" + divider);
        demonstrateAddingElements();

        System.out.println(divider + "SECTION 3: ACCESSING ELEMENTS" + divider);
        demonstrateAccessingElements();

        System.out.println(divider + "SECTION 4: SEARCHING ELEMENTS" + divider);
        demonstrateSearchingElements();

        System.out.println(divider + "SECTION 5: REMOVING ELEMENTS" + divider);
        demonstrateRemovingElements();

        System.out.println(divider + "SECTION 6: ITERATION AND FUNCTIONAL OPERATIONS" + divider);
        demonstrateFunctionalOperations();
    }

    /**
     * Demonstrates different ways to create ArrayList instances
     */
    private static void demonstrateConstructors() {
        // Default constructor
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Item 1");
        System.out.println("Default constructor: " + list1);

        // Constructor with initial capacity
        ArrayList<String> list2 = new ArrayList<>(10);
        list2.add("Item 1");
        System.out.println("Constructor with capacity: " + list2);

        // Constructor with collection
        List<String> sourceList = Arrays.asList("Apple", "Banana", "Cherry");
        ArrayList<String> list3 = new ArrayList<>(sourceList);
        System.out.println("From collection: " + list3);

        // Copy constructor
        ArrayList<String> list4 = new ArrayList<>(list3);
        System.out.println("Copy constructor: " + list4);
        System.out.println("Is copy equal to original? " + list3.equals(list4));

        // Modifying lists after copy
        list3.add("Date");
        System.out.println("Original after modification: " + list3);
        System.out.println("Copy after original was modified: " + list4);
        System.out.println("Is copy still equal to original? " + list3.equals(list4));
    }

    /**
     * Demonstrates methods for adding elements to ArrayList
     */
    private static void demonstrateAddingElements() {
        ArrayList<String> list = new ArrayList<>();

        // Adding single elements
        list.add("First");
        list.add("Second");
        list.add("Third");
        System.out.println("After adding elements: " + list);

        // Adding at specific positions
        list.add(1, "Inserted");
        System.out.println("After inserting at index 1: " + list);

        // Adding at the beginning and end (Java 21+)
        try {
            list.addFirst("Start");
            list.addLast("End");
            System.out.println("After adding to start and end: " + list);
        } catch (NoSuchMethodError e) {
            System.out.println("Note: addFirst/addLast methods require Java 21+");
            // Alternative for older Java versions
            list.add(0, "Start");
            list.add(list.size(), "End");
            System.out.println("After adding to start and end (alternative): " + list);
        }

        // Adding multiple elements
        list.addAll(Arrays.asList("Extra1", "Extra2"));
        System.out.println("After adding a collection: " + list);

        // Adding a collection at specific position
        list.addAll(2, List.of("A", "B", "C"));
        System.out.println("After adding collection at index 2: " + list);
    }

    /**
     * Demonstrates methods for accessing elements in ArrayList
     */
    private static void demonstrateAccessingElements() {
        ArrayList<String> list = new ArrayList<>(
                Arrays.asList("Apple", "Banana", "Cherry", "Date", "Elderberry")
        );
        System.out.println("List: " + list);

        // Get element at index
        System.out.println("Element at index 2: " + list.get(2));

        // Get first and last elements (Java 21+)
        try {
            System.out.println("First element: " + list.getFirst());
            System.out.println("Last element: " + list.getLast());
        } catch (NoSuchMethodError e) {
            System.out.println("Note: getFirst/getLast methods require Java 21+");
            // Alternative for older Java versions
            System.out.println("First element (alternative): " + list.get(0));
            System.out.println("Last element (alternative): " + list.get(list.size() - 1));
        }

        // Size of the list
        System.out.println("Size of list: " + list.size());

        // Check if list is empty
        System.out.println("Is list empty? " + list.isEmpty());

        // SubList - view into portion of the list
        List<String> subList = list.subList(1, 4);
        System.out.println("Sublist (index 1-3): " + subList);
    }

    /**
     * Demonstrates methods for searching elements in ArrayList
     */
    private static void demonstrateSearchingElements() {
        ArrayList<String> list = new ArrayList<>(
                Arrays.asList("Apple", "Banana", "Cherry", "Apple", "Date")
        );
        System.out.println("List: " + list);

        // Check if element exists
        System.out.println("Contains 'Cherry'? " + list.contains("Cherry"));
        System.out.println("Contains 'Fig'? " + list.contains("Fig"));

        // Find first index of element
        System.out.println("First index of 'Apple': " + list.indexOf("Apple"));

        // Find last index of element
        System.out.println("Last index of 'Apple': " + list.lastIndexOf("Apple"));

        // Element not in the list
        System.out.println("Index of 'Fig' (not in list): " + list.indexOf("Fig"));

        // Adding duplicates and searching again
        list.add("Banana");
        System.out.println("Updated list: " + list);
        System.out.println("First index of 'Banana': " + list.indexOf("Banana"));
        System.out.println("Last index of 'Banana': " + list.lastIndexOf("Banana"));
    }

    /**
     * Demonstrates methods for removing elements from ArrayList
     */
    private static void demonstrateRemovingElements() {
        // Example with strings
        ArrayList<String> stringList = new ArrayList<>(
                Arrays.asList("Apple", "Banana", "Cherry", "Date", "Elderberry", "Cherry")
        );
        System.out.println("String list: " + stringList);

        // Remove by index
        String removed = stringList.remove(1);
        System.out.println("Removed element at index 1: " + removed);
        System.out.println("List after removal: " + stringList);

        // Remove by object
        boolean wasRemoved = stringList.remove("Cherry");
        System.out.println("Was 'Cherry' removed? " + wasRemoved);
        System.out.println("List after removal: " + stringList);

        // Remove first occurrence only
        System.out.println("'Cherry' still in list? " + stringList.contains("Cherry"));

        // Example with integers
        ArrayList<Integer> intList = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5, 3)
        );
        System.out.println("\nInteger list: " + intList);

        // Remove by index vs remove by object for integers
        intList.remove(0); // Removes element at index 0
        System.out.println("After removing at index 0: " + intList);

        // To remove by value, must use Integer object
        intList.remove(Integer.valueOf(3)); // Removes first occurrence of value 3
        System.out.println("After removing value 3: " + intList);

        // RemoveFirst and RemoveLast (Java 21+)
        try {
            Integer first = intList.removeFirst();
            Integer last = intList.removeLast();
            System.out.println("Removed first element: " + first);
            System.out.println("Removed last element: " + last);
            System.out.println("List after removing first and last: " + intList);
        } catch (NoSuchMethodError e) {
            System.out.println("Note: removeFirst/removeLast methods require Java 21+");
            // Alternative for older Java versions
            Integer first = intList.remove(0);
            Integer last = intList.remove(intList.size() - 1);
            System.out.println("Removed first element (alternative): " + first);
            System.out.println("Removed last element (alternative): " + last);
            System.out.println("List after removing first and last: " + intList);
        }

        // Using removeIf (Java 8+)
        ArrayList<Integer> filterList = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        );
        System.out.println("\nFilter list: " + filterList);

        // Remove all even numbers
        filterList.removeIf(n -> n % 2 == 0);
        System.out.println("After removing even numbers: " + filterList);

        // Clear the list
        ArrayList<String> clearList = new ArrayList<>(Arrays.asList("A", "B", "C"));
        System.out.println("\nBefore clear: " + clearList);
        clearList.clear();
        System.out.println("After clear: " + clearList);
        System.out.println("Is empty? " + clearList.isEmpty());
    }

    /**
     * Demonstrates functional operations and iteration on ArrayList
     */
    private static void demonstrateFunctionalOperations() {
        ArrayList<String> list = new ArrayList<>(
                Arrays.asList("Apple", "Banana", "Cherry", "Date", "Elderberry")
        );
        System.out.println("List: " + list);

        // Using forEach with lambda
        System.out.println("\nUsing forEach with lambda:");
        list.forEach(item -> System.out.println("  - " + item));

        // Using forEach with method reference
        System.out.println("\nUsing forEach with method reference:");
        list.forEach(System.out::println);

        // Using Consumer implementation
        System.out.println("\nUsing Consumer implementation:");
        Consumer<String> printWithPrefix = item -> System.out.println("Item: " + item);
        list.forEach(printWithPrefix);

        // Using streams for transformation
        System.out.println("\nUsing streams to transform list:");
        List<String> upperCaseList = list.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println("Uppercase list: " + upperCaseList);

        // Using streams for filtering
        System.out.println("\nUsing streams to filter list:");
        List<String> filteredList = list.stream()
                .filter(s -> s.length() > 5)
                .toList();
        System.out.println("Elements with length > 5: " + filteredList);

        // Using replaceAll
        ArrayList<String> replaceList = new ArrayList<>(list);
        replaceList.replaceAll(s -> s.substring(0, 1));
        System.out.println("\nAfter replacing with first letters: " + replaceList);
    }
}