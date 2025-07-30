package org.core;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamApi implements StreamImplement{
    List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Alex", "Brian", "Amanda");

    @Override
    public void filter() {
        // 1. filter(): Keep names that start with 'A'
        List<String> filtered = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("Filtered (start with A): " + filtered + "\n");
    }

    @Override
    public void upperCase() {
        // 2. map(): Convert to uppercase
        List<String> uppercased = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Uppercased: " + uppercased + "\n");
    }

    @Override
    public void sorted() {
        // 3. sorted(): Sort alphabetically
        List<String> sorted = names.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorted: " + sorted + "\n");
    }

    @Override
    public void limited() {
        // 4. limit(n): Get first 3 names
        List<String> limited = names.stream()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("Limited (first 3): " + limited + "\n");
    }

    @Override
    public void forEach() {
        // 5. forEach(): Print each name
        System.out.print("All names: ");
        names.stream()
                .forEach(name -> System.out.print(name + " " + "\n"));
        System.out.println();
    }

    @Override
    public void collect() {
        // 6. collect(): Collect names longer than 4 characters into a list
        List<String> longNames = names.stream()
                .filter(name -> name.length() > 4)
                .collect(Collectors.toList());
        System.out.println("Names longer than 4 characters: " + longNames + "\n" );
    }

    @Override
    public void count() {
        // 7. count(): Count how many names start with 'B'
        long countB = names.stream()
                .filter(name -> name.startsWith("B"))
                .count();
        System.out.println("Count of names starting with 'B': " + countB + "\n");
    }

    @Override
    public void reduce() {
        // 8. reduce(): Concatenate all names into a single string
        Optional<String> reduced = names.stream()
                .reduce((a, b) -> a + ", " + b);
        System.out.println("Reduced (all names joined): " + reduced.orElse(""));
    }
}
