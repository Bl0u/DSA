# Java ArrayList Guide

Current Date: 2025-06-29  
Author: Bl0u

## What is ArrayList?

ArrayList is a resizable array implementation of the List interface in Java. It provides dynamic sizing, convenient methods for manipulation, and allows storing elements in order of insertion.

## Key Features

- **Dynamic Resizing**: Automatically grows as elements are added (no need to specify size in advance)
- **Indexed Access**: Fast O(1) access to elements by position
- **Allows Null Values**: Can store null as an element
- **Maintains Insertion Order**: Elements stay in the order they were added
- **Not Thread-Safe**: Not suitable for concurrent access without external synchronization

## Common Beginner Mistakes to Avoid

1. **Removing While Iterating**: Don't use a regular for-loop to remove elements during iteration
   ```java
   // WRONG - ConcurrentModificationException
   for (String item : list) {
       if (item.startsWith("A")) {
           list.remove(item);  // Will throw exception!
       }
   }
   
   // RIGHT - Use Iterator or removeIf()
   Iterator<String> iter = list.iterator();
   while (iter.hasNext()) {
       if (iter.next().startsWith("A")) {
           iter.remove();
       }
   }
   
   // BETTER - Use removeIf (Java 8+)
   list.removeIf(item -> item.startsWith("A"));
   ```

2. **Removing Integer Values**: When removing integers, be careful with autoboxing
   ```java
   ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
   
   numbers.remove(1);      // Removes element at INDEX 1, not value 1
   System.out.println(numbers);  // Prints [1, 3, 4]
   
   // To remove by value, use Integer.valueOf()
   numbers.remove(Integer.valueOf(1));  // Removes value 1
   ```

## Edge Cases to Consider

1. **Null Elements**
    - ArrayList allows null values, but be careful with methods that might not handle null
    - Operations like `sort()` or `contains()` with custom comparators may not handle null correctly

2. **Memory Overhead**
    - ArrayList keeps empty slots when elements are removed
    - Use `trimToSize()` to reclaim memory after many removals

3. **Performance with Large Lists**
    - Insertion/removal in the middle is O(n) - slow for large lists
    - Consider LinkedList for frequent insertions/deletions in the middle
    - ArrayList is more memory-efficient than LinkedList

4. **Capacity vs Size**
    - `size()` returns the number of elements actually stored
    - The internal capacity may be larger than size
    - Each resize operation copies all elements to a new array (typically 1.5x larger)

## When to Use ArrayList

- When you need indexed access to elements
- When you're mostly adding/removing at the end of the list
- When you need a dynamic-sized collection that maintains order
- When you want a simple, easy-to-use list implementation

## When NOT to Use ArrayList

- When you need frequent insertions/deletions in the middle
- When you need concurrent thread-safe operations (use Collections.synchronizedList or CopyOnWriteArrayList)
- When you need a fixed-size list (use Arrays.asList instead)
- When you're working with primitive types (consider specialized libraries)

## Time Complexity

| Operation | Time Complexity |
|-----------|----------------|
| get(index) | O(1) |
| add(element) | O(1) |
| add(index, element) | O(n) |
| remove(index) | O(n) |
| contains(object) | O(n) |
| size() | O(1) |