package HashSet;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This class demonstrates various operations and features of Java HashSet.
 * It includes examples of different constructors, adding elements, working with custom objects,
 * set operations, and stream API usage with sets.
 */
public class _HashSet {

    /**
     * A simple Person class used to demonstrate how custom objects work in HashSet.
     */
    static class Person {
        String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {
        // Divider for cleaner output
        String divider = "\n" + "=".repeat(50) + "\n";

        System.out.println(divider + "SECTION 1: HASHSET CONSTRUCTORS" + divider);
        demonstrateConstructors();

        System.out.println(divider + "SECTION 2: BASIC OPERATIONS" + divider);
        demonstrateBasicOperations();

        System.out.println(divider + "SECTION 3: WORKING WITH CUSTOM OBJECTS" + divider);
        demonstrateCustomObjects();

        System.out.println(divider + "SECTION 4: SET OPERATIONS" + divider);
        demonstrateSetOperations();

        System.out.println(divider + "SECTION 5: STREAM OPERATIONS" + divider);
        demonstrateStreamOperations();
    }

    /**
     * Demonstrates different ways to create HashSet instances
     */
    private static void demonstrateConstructors() {
        // Default constructor
        Set<String> set1 = new HashSet<>();
        System.out.println("Default constructor: " + set1);

        // Constructor with initial capacity
        Set<String> set2 = new HashSet<>(3);
        System.out.println("Constructor with capacity: " + set2);

        // Constructor with initial capacity and load factor
        Set<String> set3 = new HashSet<>(3, 0.5f);
        System.out.println("Constructor with capacity and load factor: " + set3);

        // Constructor with collection - eliminates duplicates
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Alice"); // duplicate
        Set<String> nameSet = new HashSet<>(names);
        System.out.println("From collection (removes duplicates): " + nameSet);

        // Factory methods (Java 9+)
        try {
            Set<String> immutableSet = Set.of("Alice", "Bob", "Charlie");
            System.out.println("Immutable set with Set.of(): " + immutableSet);

            List<String> moreNames = Arrays.asList("David", "Eve", "David");
            Set<String> copyOfSet = Set.copyOf(moreNames);
            System.out.println("Immutable set with Set.copyOf(): " + copyOfSet);
        } catch (UnsupportedOperationException e) {
            System.out.println("Note: Set.of() and Set.copyOf() create immutable sets");
        }
    }

    /**
     * Demonstrates basic HashSet operations
     */
    private static void demonstrateBasicOperations() {
        Set<String> set = new HashSet<>();

        // Adding elements
        System.out.println("Empty set: " + set);
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        System.out.println("After adding elements: " + set);

        // Checking if element exists
        System.out.println("Contains 'Apple'? " + set.contains("Apple"));
        System.out.println("Contains 'Dragonfruit'? " + set.contains("Dragonfruit"));

        // Removing elements
        set.remove("Banana");
        System.out.println("After removing 'Banana': " + set);

        // Size and isEmpty
        System.out.println("Size: " + set.size());
        System.out.println("Is empty? " + set.isEmpty());

        // Clear
        set.clear();
        System.out.println("After clear(): " + set);
        System.out.println("Is empty? " + set.isEmpty());
    }

    /**
     * Demonstrates how HashSet works with custom objects
     */
    private static void demonstrateCustomObjects() {
        Set<Object> set = new HashSet<>();

        // Adding different types of objects
        Person p1 = new Person("Alice");
        Person p2 = new Person("Bob");
        set.add(p1);
        set.add(p2);
        set.add("First");
        set.add(2);
        set.add(1);
        System.out.println("Original set: " + set);

        // Cloning a HashSet
        HashSet<Object> cloned = (HashSet<Object>) ((HashSet<Object>) set).clone();
        System.out.println("Cloned set: " + cloned);

        // Modifying the clone doesn't affect original
        cloned.add(3);
        System.out.println("Original after modifying clone: " + set);
        System.out.println("Modified clone: " + cloned);

        // However, modifying objects affects both sets (shallow copy)
        p1.name = "Alice (modified)";
        System.out.println("Original after modifying Person object: " + set);
        System.out.println("Clone after modifying Person object: " + cloned);
    }

    /**
     * Demonstrates common set operations
     */
    private static void demonstrateSetOperations() {
        // Create two sets
        Set<String> set1 = new HashSet<>(Arrays.asList("A", "B", "C", "D"));
        Set<String> set2 = new HashSet<>(Arrays.asList("C", "D", "E", "F"));

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);

        // Testing equality
        System.out.println("Are sets equal? " + set1.equals(set2));

        // Create a copy for demonstrations
        Set<String> workingSet = new HashSet<>(set1);

        // Retain all (intersection)
        workingSet.retainAll(set2);
        System.out.println("Intersection (set1 ∩ set2): " + workingSet);

        // Add all (union)
        workingSet = new HashSet<>(set1);
        workingSet.addAll(set2);
        System.out.println("Union (set1 ∪ set2): " + workingSet);

        // Remove all (difference)
        workingSet = new HashSet<>(set1);
        workingSet.removeAll(set2);
        System.out.println("Difference (set1 - set2): " + workingSet);

        // Contains all (subset)
        System.out.println("Is set1 a subset of set2? " + set2.containsAll(set1));

        // Handling null values
        Set<String> setWithNull = new HashSet<>();
        setWithNull.add("A");
        setWithNull.add(null);
        setWithNull.add("B");
        System.out.println("Set with null value: " + setWithNull);
        System.out.println("Contains null? " + setWithNull.contains(null));
    }

    /**
     * Demonstrates using Java streams with HashSet
     */
    private static void demonstrateStreamOperations() {
        Set<String> set = new HashSet<>(
                Arrays.asList("Apple", "Banana", "Cherry", "Date", "Apricot")
        );
        System.out.println("Original set: " + set);

        // forEach with stream
        System.out.println("Printing each element:");
        set.stream().forEach(element -> System.out.println("  - " + element));

        // Filter with streams
        Set<String> filteredSet = set.stream()
                .filter(element -> element.startsWith("A"))
                .collect(Collectors.toSet());
        System.out.println("Elements starting with 'A': " + filteredSet);

        // Map with streams
        Set<Integer> lengthSet = set.stream()
                .map(String::length)
                .collect(Collectors.toSet());
        System.out.println("Set of string lengths: " + lengthSet);

        // removeIf (Java 8+)
        Set<String> workingSet = new HashSet<>(set);
        workingSet.removeIf(element -> element.length() > 5);
        System.out.println("After removing elements with length > 5: " + workingSet);
    }
}