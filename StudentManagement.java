import java.util.*;

public class StudentManagement {
    private List<Student> students;

    public StudentManagement() {
        students = new ArrayList<>();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StudentManagement studentManagement = new StudentManagement();

        while (true) {
            System.out.println("Enter 1. Add a student\n2. Edit a student\n3. Search a student\n4. Display students\n5. Exit");
            int key = in.nextInt();
            in.nextLine(); 
            switch (key) {
                case 1:
                    studentManagement.addStudent();
                    break;
                case 2:
                    studentManagement.editStudent();
                    break;
                case 3:
                    studentManagement.searchStudent();
                    break;
                case 4:
                    studentManagement.displayStudents();
                    break;
                case 5:
                    System.out.println("Exiting the program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid number");
                    break;
            }
        }
    }

    public void addStudent() {
        System.out.println("Adding a new student:");

        String name = getStringInput("Enter the student's name: ");
        String rollNumber = getStringInput("Enter the student's roll number: ");
        String grade = getStringInput("Enter the student's grade: ");

        Student student = new Student(name, rollNumber, grade);
        students.add(student);

        System.out.println("Student added successfully!");
    }

    public void editStudent() {
        System.out.println("Editing a student:");

        String rollNumber = getStringInput("Enter the roll number of the student to edit: ");

        Student student = searchStudentByRollNumber(rollNumber);

        if (student != null) {
            System.out.println("Student found:");
            System.out.println(student);

            String newName = getStringInput("Enter the new name for the student: ");
            String newGrade = getStringInput("Enter the new grade for the student: ");

            student.setName(newName);
            student.setGrade(newGrade);

            System.out.println("Student information updated successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    public void searchStudent() {
        System.out.println("Searching for a student:");

        String rollNumber = getStringInput("Enter the roll number of the student to search: ");

        Student student = searchStudentByRollNumber(rollNumber);

        if (student != null) {
            System.out.println("Student found:");
            System.out.println(student);
        } else {
            System.out.println("Student not found!");
        }
    }

    public void displayStudents() {
        System.out.println("Displaying all students:");

        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    private String getStringInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private Student searchStudentByRollNumber(String rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber().equals(rollNumber)) {
                return student;
            }
        }
        return null;
    }

    class Student {
        private String name;
        private String rollNumber;
        private String grade;

        public Student(String name, String rollNumber, String grade) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRollNumber() {
            return rollNumber;
        }

        public void setRollNumber(String rollNumber) {
            this.rollNumber = rollNumber;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public String toString() {
            return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
        }
    }
}