import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectionInJava {

    public void greet() {
        System.out.println("Hello from Reflection!");
    }

    public static void main(String[] args) {

        try {

            Class<?> clazz = Class.forName("ReflectionInJava");

            Object object = clazz.getDeclaredConstructor().newInstance();

            Method[] methods = clazz.getDeclaredMethods();

            System.out.println("Methods in the class:");

            for (Method method : methods) {

                System.out.print("Method: " + method.getName());

                Parameter[] parameters = method.getParameters();

                System.out.print(" | Parameters: ");

                if (parameters.length == 0) {
                    System.out.print("None");
                } else {
                    for (Parameter parameter : parameters) {
                        System.out.print(parameter.getType().getSimpleName() + " ");
                    }
                }

                System.out.println();
            }

            Method method = clazz.getDeclaredMethod("greet");
            method.invoke(object);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}