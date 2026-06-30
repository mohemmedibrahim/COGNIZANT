public class EmployeeManagement {

    private final Employee[] employees;
    private int count;

    public EmployeeManagement(int size) {
        employees = new Employee[size];
        count = 0;
    }

    public void addEmployee(Employee emp) {

        if (count < employees.length) {
            employees[count++] = emp;
            System.out.println("Employee added successfully.");
        } else {
            System.out.println("Array is full!");
        }
    }

    public void searchEmployee(int id) {

        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                System.out.println("Employee Found: " + employees[i]);
                return;
            }
        }

        System.out.println("Employee not found.");
    }

    public void displayEmployees() {

        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public void deleteEmployee(int id) {

        int index = -1;

        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Employee not found.");
            return;
        }

        for (int i = index; i < count - 1; i++) {
            employees[i] = employees[i + 1];
        }

        employees[--count] = null;

        System.out.println("Employee deleted successfully.");
    }
}