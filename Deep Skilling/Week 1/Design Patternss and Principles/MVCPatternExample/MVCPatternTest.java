public class MVCPatternTest {

    public static void main(String[] args) {

        // Create model
        Student student = new Student("John", "S101", "A");

        // Create view
        StudentView view = new StudentView();

        // Create controller
        StudentController controller = new StudentController(student, view);

        // Display initial data
        controller.updateView();

        System.out.println("\n--- Updating Student Details ---\n");

        // Update data using controller
        controller.setStudentName("David");
        controller.setStudentGrade("A+");

        // Display updated data
        controller.updateView();
    }
}