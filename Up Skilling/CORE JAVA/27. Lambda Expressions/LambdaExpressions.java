import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaExpressions {

    public static void main(String[] args) {

        List<String> fruits = new ArrayList<>();

        fruits.add("Orange");
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");

        Collections.sort(fruits, (a, b) -> a.compareTo(b));

        System.out.println("Sorted List:");

        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}