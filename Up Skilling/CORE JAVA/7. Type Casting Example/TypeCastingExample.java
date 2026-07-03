public class TypeCastingExample {

    public static void main(String[] args) {

        double doubleValue = 25.75;
        int intValue = (int) doubleValue;

        int number = 100;
        double convertedDouble = number;

        System.out.println("Original double value : " + doubleValue);
        System.out.println("After casting to int  : " + intValue);

        System.out.println();

        System.out.println("Original int value    : " + number);
        System.out.println("After casting to double: " + convertedDouble);
    }
}