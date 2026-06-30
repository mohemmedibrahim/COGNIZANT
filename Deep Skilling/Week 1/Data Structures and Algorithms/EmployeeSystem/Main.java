public class Main {

    public static void main(String[] args) {

        EmployeeManagement em = new EmployeeManagement(5);

        em.addEmployee(new Employee(101, "Arun", "Manager", 50000));
        em.addEmployee(new Employee(102, "Bala", "Developer", 40000));
        em.addEmployee(new Employee(103, "Charan", "Tester", 35000));

        System.out.println("\n--- Employee List ---");
        em.displayEmployees();

        System.out.println("\n--- Search Employee (102) ---");
        em.searchEmployee(102);

        System.out.println("\n--- Delete Employee (102) ---");
        em.deleteEmployee(102);

        System.out.println("\n--- Employee List After Deletion ---");
        em.displayEmployees();
    }
}