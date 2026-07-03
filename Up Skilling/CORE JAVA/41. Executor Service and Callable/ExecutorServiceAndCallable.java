import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceAndCallable {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Callable<String> task1 = () -> "Task 1 Completed";
        Callable<String> task2 = () -> "Task 2 Completed";
        Callable<String> task3 = () -> "Task 3 Completed";

        Future<String> future1 = executor.submit(task1);
        Future<String> future2 = executor.submit(task2);
        Future<String> future3 = executor.submit(task3);

        try {

            System.out.println(future1.get());
            System.out.println(future2.get());
            System.out.println(future3.get());

        } catch (InterruptedException e) {
            System.out.println("Task Interrupted.");
        } catch (ExecutionException e) {
            System.out.println("Execution Error: " + e.getMessage());
        }

        executor.shutdown();
    }
}