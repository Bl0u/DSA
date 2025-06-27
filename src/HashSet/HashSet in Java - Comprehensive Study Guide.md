# HashSet in Java - Comprehensive Study Guide

## Introduction to HashSet
HashSet is one of the concrete implementations of the Set interface in Java, backed by a hash table (actually a HashMap instance). It offers constant-time performance for basic operations (add, remove, contains, size) assuming the hash function disperses elements properly among the buckets.

## Set Implementation Classes in Java
These are the classes you actually instantiate:

- **HashSet\<E>** — backed by a hash table, no ordering
- **LinkedHashSet\<E>** — backed by a hash table with insertion-order iteration
- **TreeSet\<E>** — implements NavigableSet, keeps elements sorted
- **EnumSet\<E extends Enum\<E>>** — specialized high-performance set for enum types
- **CopyOnWriteArraySet\<E>** — from java.util.concurrent, thread-safe with copy-on-write strategy

## Performance Characteristics
Iterating over a HashSet requires time proportional to the sum of:
- The HashSet instance's size (number of elements)
- The "capacity" of the backing HashMap instance (number of buckets)

## HashSet and Null Values
**Can HashSet handle null values?**
✅ Yes, HashSet can store a single null value. Since HashSet is backed by HashMap, and HashMap allows one null key, HashSet can contain null as an element.

```java
HashSet<String> set = new HashSet<>();
set.add(null);  // This is valid
System.out.println(set.contains(null));  // Returns true
```

## The Load Factor Explained
The load factor is a measure of how full the hash table is allowed to get before it automatically increases its capacity (also known as rehashing).

**Building Intuition:**
- Think of load factor as the "fullness threshold" that triggers growth
- It controls the trade-off between space and time
- A lower load factor means more space (more empty buckets) but faster lookups (fewer collisions)
- A higher load factor means more packed buckets (less space) but potentially more collisions, which can slow down lookups

**Default values:**
- Default load factor: 0.75
- This means: when the set reaches 75% full, it will resize (rehash) to a bigger array

**Example:**
```java
HashSet<String> set = new HashSet<>(16, 0.75f);
// initial capacity: 16 buckets
// load factor: 0.75
// → the HashSet will resize (rehash) when 12 elements are inserted (16 * 0.75 = 12)
```

## HashSet Methods with Examples

### 1. `add(E e)`
Adds the specified element to this set if it is not already present.

**Return Type:** boolean  
**Return Value:** true if the set did not already contain the specified element

```java
HashSet<String> fruits = new HashSet<>();
boolean result1 = fruits.add("Apple");  // Returns true, "Apple" added
boolean result2 = fruits.add("Apple");  // Returns false, "Apple" already exists
System.out.println(fruits);  // [Apple]
System.out.println(result1); // true
System.out.println(result2); // false
```

### 2. `remove(Object o)`
Removes the specified element from this set if it is present.

**Return Type:** boolean  
**Return Value:** true if the set contained the specified element

```java
HashSet<String> fruits = new HashSet<>();
fruits.add("Apple");
fruits.add("Banana");

boolean result1 = fruits.remove("Apple");   // Returns true, "Apple" was removed
boolean result2 = fruits.remove("Orange");  // Returns false, "Orange" wasn't in the set
System.out.println(fruits);   // [Banana]
System.out.println(result1);  // true
System.out.println(result2);  // false
```

### 3. `contains(Object o)`
Returns true if this set contains the specified element.

**Return Type:** boolean  
**Return Value:** true if the set contains the specified element

```java
HashSet<String> fruits = new HashSet<>();
fruits.add("Apple");
fruits.add("Banana");

boolean result1 = fruits.contains("Apple");   // Returns true
boolean result2 = fruits.contains("Orange");  // Returns false
System.out.println(result1);  // true
System.out.println(result2);  // false
```

### 4. `size()`
Returns the number of elements in this set.

**Return Type:** int  
**Return Value:** the number of elements in this set

```java
HashSet<String> fruits = new HashSet<>();
fruits.add("Apple");
fruits.add("Banana");
fruits.add("Cherry");

int size = fruits.size();  // Returns 3
System.out.println(size);  // 3
```

### 5. `isEmpty()`
Returns true if this set contains no elements.

**Return Type:** boolean  
**Return Value:** true if this set contains no elements

```java
HashSet<String> fruits = new HashSet<>();
boolean result1 = fruits.isEmpty();  // Returns true, set is empty

fruits.add("Apple");
boolean result2 = fruits.isEmpty();  // Returns false, set has an element

System.out.println(result1);  // true
System.out.println(result2);  // false
```

### 6. `clear()`
Removes all of the elements from this set.

**Return Type:** void  
**Return Value:** none

```java
HashSet<String> fruits = new HashSet<>();
fruits.add("Apple");
fruits.add("Banana");
System.out.println(fruits);  // [Apple, Banana]

fruits.clear();
System.out.println(fruits);  // []
System.out.println(fruits.isEmpty());  // true
```

### 7. `Set.copyOf(Collection<? extends E> coll)`
A static factory method introduced in Java 10 that:

- Takes an existing collection (e.g., a List or another Set)
- Copies its elements into a new Set
- Returns an unmodifiable (immutable) set
- Throws NullPointerException if the input contains null elements

**Return Type:** Set<E>  
**Return Value:** An unmodifiable set containing the elements of the given collection

```java
List<String> fruitList = Arrays.asList("Apple", "Banana", "Cherry");
Set<String> immutableFruits = Set.copyOf(fruitList);

// immutableFruits.add("Orange");  // This would throw UnsupportedOperationException
System.out.println(immutableFruits);  // [Apple, Banana, Cherry]

// This would throw NullPointerException:
// List<String> listWithNull = Arrays.asList("Apple", null, "Cherry");
// Set<String> willFail = Set.copyOf(listWithNull);
```

### 8. `removeIf(Predicate<? super E> filter)`
Removes all elements that satisfy the given predicate.

**Return Type:** boolean  
**Return Value:** true if any elements were removed

```java
HashSet<String> fruits = new HashSet<>();
fruits.add("Apple");
fruits.add("Banana");
fruits.add("Blueberry");
fruits.add("Cherry");
System.out.println(fruits);  // [Apple, Banana, Blueberry, Cherry]

// Remove all fruits that start with 'B'
boolean removed = fruits.removeIf(fruit -> fruit.startsWith("B"));
System.out.println(removed);  // true
System.out.println(fruits);   // [Apple, Cherry]
```

**What is Predicate?**
A Predicate<E> is a functional interface with the method `boolean test(E e)`:
- if test(e) returns true → remove the element
- if test(e) returns false → keep the element

## Building Mental Models for HashSet

### Visual Model: Hash Table Buckets
Imagine HashSet as an array of linked lists (buckets):
```
[0] → null
[1] → "Apple" → null
[2] → "Cherry" → "Banana" → null
[3] → null
...
[n] → null
```

Each element's hashCode() determines which bucket it goes into, and equals() determines if it's a duplicate.

### Comparing with Other Collection Types
- **HashSet vs. ArrayList**: Use HashSet when you need fast lookups and no duplicates. Use ArrayList when order matters or you need duplicates.
- **HashSet vs. HashMap**: HashSet stores only values; HashMap stores key-value pairs.
- **HashSet vs. TreeSet**: Use HashSet for faster operations; use TreeSet when you need sorted elements.

### removeIf vs. filter
✅ Visual difference

| Method | Side Effect | Returns |
|--------|-------------|---------|
| removeIf | Modifies (removes elements) | boolean (any removed?) |
| filter | Does not modify | new Stream |

## Study Tips for HashSet

1. **Practice with real examples:**
    - Create a HashSet of integers and try all operations
    - Create a HashSet of custom objects and implement hashCode() and equals()

2. **Think about use cases:**
    - When would you use HashSet vs. other collections?
    - What real-world problems can be solved efficiently with HashSet?

3. **Understand the internals:**
    - How does hashing work?
    - What happens during a collision?
    - How does resizing affect performance?

4. **Remember the guarantees:**
    - No duplicates
    - No guaranteed order
    - Null is allowed (one maximum)
    - O(1) average time complexity for add, remove, contains

5. **Common gotchas:**
    - Objects that change after being added can "disappear"
    - Poor hashCode() implementations can lead to O(n) performance
    - The elements' iteration order can change when the set is modified

## Conclusion
HashSet provides an efficient way to store unique elements with fast operations. Understanding its internal workings and behavior with regard to load factor, null values, and hash collisions will help you use it effectively in your applications.
