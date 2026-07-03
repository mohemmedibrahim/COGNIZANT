import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RecordsExample {

    public static void main(String[] args) {

        Person person1 = new Person("Alice", 22);
        Person person2 = new Person("Bob", 17);
        Person person3 = new Person("Charlie", 25);

        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);

        List<Person> people = Arrays.asList(person1, person2, person3);

        List<Person> adults = people.stream()
                                    .filter(person -> person.age() >= 18)
                                    .collect(Collectors.toList());

        System.out.println("\nPeople with age 18 or above:");

        for (Person person : adults) {
            System.out.println(person);
        }
    }
}

record Person(String name, int age) {
}