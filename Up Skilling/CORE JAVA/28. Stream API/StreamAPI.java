import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(15);
        numbers.add(20);
        numbers.add(25);
        numbers.add(30);
        numbers.add(35);

        List<Integer> evenNumbers = numbers.stream()
                                           .filter(number -> number % 2 == 0)
                                           .collect(Collectors.toList());

        System.out.println("Original List: " + numbers);
        System.out.println("Even Numbers: " + evenNumbers);
    }
}