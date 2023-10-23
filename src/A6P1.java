import java.util.ArrayList;
import java.util.Scanner;

class User {
    protected String name;
    protected String dateOfBirth;
    protected String userID;

    public User(String name, String dateOfBirth, String userID) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.userID = userID;
    }

    public void setDetails(String name, String dateOfBirth, String userID) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.userID = userID;
    }

    public void showDetails(int birthYear) {
        if (dateOfBirth.contains(Integer.toString(birthYear))) {
            System.out.println("Name: " + name);
            System.out.println("Date of Birth: " + dateOfBirth);
            System.out.println("User ID: " + userID);
        }
    }
}

class Student extends User {
    String rollNumber;
    int semester;
    double cpi;

    public Student(String name, String dateOfBirth, String userID, String rollNumber, int semester, double cpi) {
        super(name, dateOfBirth, userID);
        this.rollNumber = rollNumber;
        this.semester = semester;
        this.cpi = cpi;
    }
}

class Staff extends User {
    String employeeID;
    String sectionName;
    String designation;

    public Staff(String name, String dateOfBirth, String userID, String employeeID, String sectionName, String designation) {
        super(name, dateOfBirth, userID);
        this.employeeID = employeeID;
        this.sectionName = sectionName;
        this.designation = designation;
    }

    public boolean isDesignationSame(Staff otherStaff) {
        return this.designation.equals(otherStaff.designation);
    }
}

class Faculty extends User {
    String departmentName;
    int noOfPublications;

    public Faculty(String name, String dateOfBirth, String userID, String departmentName, int noOfPublications) {
        super(name, dateOfBirth, userID);
        this.departmentName = departmentName;
        this.noOfPublications = noOfPublications;
    }

    public boolean isDepartmentSame(Faculty otherFaculty) {
        return this.departmentName.equals(otherFaculty.departmentName);
    }
}

public class A6P1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<User>();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Create Student");
            System.out.println("2. Create Staff");
            System.out.println("3. Create Faculty");
            System.out.println("4. Display details by UserID");
            System.out.println("5. Display details by EmployeeID");
            System.out.println("6. Display details by Birth Year");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Create Student
                    System.out.print("Enter Student Name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter Date of Birth: ");
                    String studentDOB = scanner.nextLine();
                    System.out.print("Enter UserID: ");
                    String studentUserID = scanner.nextLine();
                    System.out.print("Enter Roll Number: ");
                    String rollNumber = scanner.nextLine();
                    System.out.print("Enter Semester: ");
                    int semester = scanner.nextInt();
                    System.out.print("Enter CPI: ");
                    double cpi = scanner.nextDouble();

                    Student student = new Student(studentName, studentDOB, studentUserID, rollNumber, semester, cpi);
                    users.add(student);
                    break;
                case 2:
                    // Create Staff
                    System.out.print("Enter Staff Name: ");
                    String staffName = scanner.nextLine();
                    System.out.print("Enter Date of Birth: ");
                    String staffDOB = scanner.nextLine();
                    System.out.print("Enter UserID: ");
                    String staffUserID = scanner.nextLine();
                    System.out.print("Enter EmployeeID: ");
                    String employeeID = scanner.nextLine();
                    System.out.print("Enter Section Name: ");
                    String sectionName = scanner.nextLine();
                    System.out.print("Enter Designation: ");
                    String designation = scanner.nextLine();

                    Staff staff = new Staff(staffName, staffDOB, staffUserID, employeeID, sectionName, designation);
                    users.add(staff);
                    break;
                case 3:
                    // Create Faculty
                    System.out.print("Enter Faculty Name: ");
                    String facultyName = scanner.nextLine();
                    System.out.print("Enter Date of Birth: ");
                    String facultyDOB = scanner.nextLine();
                    System.out.print("Enter UserID: ");
                    String facultyUserID = scanner.nextLine();
                    System.out.print("Enter Department Name: ");
                    String departmentName = scanner.nextLine();
                    System.out.print("Enter Number of Publications: ");
                    int publications = scanner.nextInt();

                    Faculty faculty = new Faculty(facultyName, facultyDOB, facultyUserID, departmentName, publications);
                    users.add(faculty);
                    break;
                case 4:
                    // Display details by UserID
                    System.out.print("Enter UserID to search: ");
                    String searchUserID = scanner.nextLine();
                    for (User user : users) {
                        if (user.userID.equals(searchUserID)) {
                            System.out.println("User found:");
                            System.out.println("Name: " + user.name);
                            System.out.println("Date of Birth: " + user.dateOfBirth);
                            System.out.println("UserID: " + user.userID);
                            if (user instanceof Student) {
                                System.out.println("Roll Number: " + ((Student) user).rollNumber);
                                System.out.println("Semester: " + ((Student) user).semester);
                                System.out.println("CPI: " + ((Student) user).cpi);
                            } else if (user instanceof Staff) {
                                System.out.println("EmployeeID: " + ((Staff) user).employeeID);
                                System.out.println("Section Name: " + ((Staff) user).sectionName);
                                System.out.println("Designation: " + ((Staff) user).designation);
                            } else if (user instanceof Faculty) {
                                System.out.println("Department Name: " + ((Faculty) user).departmentName);
                                System.out.println("No. of Publications: " + ((Faculty) user).noOfPublications);
                            }
                        }
                    }
                    break;
                case 5:
                    // Display details by EmployeeID
                    if (users.size() == 0) {
                        System.out.println("No users to search.");
                    } else {
                        System.out.print("Enter EmployeeID to search: ");
                        String searchEmployeeID = scanner.nextLine();
                        for (User user : users) {
                            if (user instanceof Staff && ((Staff) user).employeeID.equals(searchEmployeeID)) {
                                System.out.println("User found:");
                                System.out.println("Name: " + user.name);
                                System.out.println("Date of Birth: " + user.dateOfBirth);
                                System.out.println("UserID: " + user.userID);
                                System.out.println("EmployeeID: " + ((Staff) user).employeeID);
                                System.out.println("Section Name: " + ((Staff) user).sectionName);
                                System.out.println("Designation: " + ((Staff) user).designation);
                            }
                        }
                    }
                    break;
                case 6:
                    // Display details by Birth Year
                    System.out.print("Enter Birth Year to search: ");
                    int birthYear = scanner.nextInt();
                    for (User user : users) {
                        user.showDetails(birthYear);
                    }
                    break;
                case 7:
                    // Exit
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}