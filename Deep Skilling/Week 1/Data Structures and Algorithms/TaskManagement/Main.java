public class Main {

    public static void main(String[] args) {

        TaskLinkedList list = new TaskLinkedList();

        list.addTask(new Task(1, "Design UI", "Pending"));
        list.addTask(new Task(2, "Develop Backend", "In Progress"));
        list.addTask(new Task(3, "Testing", "Pending"));

        System.out.println("\n--- All Tasks ---");
        list.displayTasks();

        System.out.println("\n--- Search Task (2) ---");
        list.searchTask(2);

        System.out.println("\n--- Delete Task (2) ---");
        list.deleteTask(2);

        System.out.println("\n--- Tasks After Deletion ---");
        list.displayTasks();
    }
}