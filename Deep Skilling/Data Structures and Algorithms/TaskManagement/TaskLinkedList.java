public class TaskLinkedList {

    // Node class
    private class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;

    // ADD Task (at end)
    public void addTask(Task task) {

        Node newNode = new Node(task);

        if (head == null) {
            head = newNode;
            System.out.println("Task added.");
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        System.out.println("Task added.");
    }

    // SEARCH Task
    public void searchTask(int id) {

        Node temp = head;

        while (temp != null) {
            if (temp.task.taskId == id) {
                System.out.println("Task Found: " + temp.task);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Task not found.");
    }

    // DISPLAY Tasks
    public void displayTasks() {

        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }
    }

    // DELETE Task
    public void deleteTask(int id) {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        // If head is to be deleted
        if (head.task.taskId == id) {
            head = head.next;
            System.out.println("Task deleted.");
            return;
        }

        Node temp = head;

        while (temp.next != null && temp.next.task.taskId != id) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Task not found.");
            return;
        }

        temp.next = temp.next.next;
        System.out.println("Task deleted.");
    }
}