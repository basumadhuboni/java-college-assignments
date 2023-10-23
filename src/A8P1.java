import java.util.*;

class Student implements Comparable<Student> { //inbuilt interface
    String name;
    int roll;
    String birthyear;

    public Student(String name, int roll, String birthyear) {
        this.name = name;
        this.roll = roll;
        this.birthyear = birthyear;
    }

    public String getFirstName() {
        return name.split(" ")[0];
    }

    public String getTitle() {
        return name.split(" ")[1];
    }

    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll: " + roll + ", Birthyear: " + birthyear;
    }
}

public class A8P1 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("John Doe", 101, "2000"));
        students.add(new Student("Jane Smith", 102, "1999"));
        students.add(new Student("James Brown", 103, "2001"));
        students.add(new Student("Emma Lee", 104, "1998"));
        students.add(new Student("Michael Johnson", 105, "2002"));

        // Sorting with respect to first name
        System.out.println("Sorting with respect to first name:");
        Collections.sort(students, Comparator.comparing(Student::getFirstName));
        printStudents(students);

        // Sorting with respect to title
        System.out.println("\nSorting with respect to title:");
        Collections.sort(students, Comparator.comparing(Student::getTitle));
        printStudents(students);

        // Sorting in reverse order of roll number
        System.out.println("\nSorting in reverse order of roll number:");
        Collections.sort(students, Comparator.comparingInt(Student::getRoll).reversed());
        printStudents(students);

        // Sorting in ascending order of birthyear
        System.out.println("\nSorting in ascending order of birthyear:");
        Collections.sort(students, Comparator.comparing(Student::getBirthyear));
        printStudents(students);
    }

    public static void printStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}