import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) throws IOException {

        IntStream
                .range(1, 10)
                .forEach(System.out::print);
        System.out.println();

        //Int Stream with Skip
        IntStream
                .range(1, 10)
                .skip(5)
                .forEach(System.out::print);
        System.out.println();

        //Int Stream with Sum
        int val = IntStream
                .range(1, 5)
                .sum();
        System.out.println(val);

        //Stream.of, sorted and findFirst
        Stream.of("Hello", "bottle", "Africa")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);

        //Stream from Array, sort, filter and print
        String [] items = {"car", "computer", "toothpaste", "box", "pencil", "tent", "door", "toy"};
        Stream.of(items)
                .filter((x) -> x.startsWith("t"))
                .sorted()
                .forEach(x -> System.out.print(x + ", "));
               System.out.println();


        //Average of squares of an int array
       Arrays.stream(new int[] {2, 4, 6, 8, 10})
                .map((x) -> x *x)
                .average()
                .ifPresent(System.out::println);
        System.out.println();


        //Stream from a list, filter and print
        List<String> listOfItems = Arrays.asList("Computer", "Toothpaste", "Box", "Pencil", "Car", "Tent");
                listOfItems.stream()
                .map(x -> x.toLowerCase())
                .filter(x -> x.startsWith("c"))
                .sorted()
                .forEach(x -> System.out.print(x + ", "));

                //include files folder
        Stream<String> lines = Files.lines(Paths.get("C:\\Projects\\Analys\\streamsPractice\\src\\files\\wordFile.txt"));
        lines.sorted()
                .filter(l -> l.length() > 6)
                .forEach(x -> System.out.print(x + ", "));
        System.out.println();
        lines.close();

        List<String> words = Files.lines(Paths.get("C:\\Projects\\Analys\\streamsPractice\\src\\files\\wordFile.txt"))
                .filter(x -> x.contains("th"))
                .collect(Collectors.toList());
        words.forEach(x -> System.out.print(x + ", "));
        System.out.println();

        Stream<String> rows = Files.lines(Paths.get("C:\\Projects\\Analys\\streamsPractice\\src\\files\\stockDataCsv.txt"));
       int rowCount = (int) rows
               .map(x -> x.split(", "))
                .filter(x -> x.length > 3)
                .count();
        System.out.println(rowCount + " good rows.");
        rows.close();

        Stream<String> rows2 = Files.lines(Paths.get("C:\\Projects\\Analys\\streamsPractice\\src\\files\\stockDataCsv.txt"));
        rows2.map(x -> x.split(", "))
                .filter(x -> x.length > 3)
                .filter(x -> Integer.parseInt(x[1].trim()) > 15)
                .forEach(x -> System.out.println(x[0].trim() + " " + x[2].trim() + " " + x[3].trim()));
        rows2.close();
    }
}
