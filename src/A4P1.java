import java.util.Scanner;

class Student {
    int studentid;
    String firstname;
    String lastname;
    int age;
    String department;
    int semester;
    public int cgpa;

    Student() {
    }

    Student(int id, String fname, String lname, int age, String department, int semester, int cgpa) {
      this.studentid = id;
        this.firstname = fname;
        this.lastname = lname;
        this.age = age;
        this.department = department;
        this.semester = semester;
        this.cgpa = cgpa;
    }

    public void setdetails(int id, String fname, String lname, int age, String department, int semester, int cgpa) {
        // this key word reffers to the current instance(object) of the class 
        this.studentid = id;
        this.firstname = fname;
        this.lastname = lname;
        this.age = age;
        this.department = department;
        this.semester = semester;
        this.cgpa = cgpa;
    }

    public String getDetails(int id) {
        if (this.studentid == id) {
            return "Student ID: " + studentid + "\n" + "Name: " + firstname + " " + lastname + "\n" + "Age: " + age
                    + "\n" + "Department: " + department + "\n" + "Semester: " + semester;
        } else {
            return "Student not found.";
        }
    }

    public int getCGPA(int id) {
        if (this.studentid == id) {
            return cgpa;
        } else {
            return -1; // Indicate student not found
        }
    }

    public int findage(int id) {
        if (this.studentid == id) {
            return age;
        } else {
            return -1; // Indicate student not found
        }
    }
}

public class A4P1 {
    public static void main(String args[]) {
        int i = -1, id, a, sem, c, j, s=0;
        char choice = 'y';
        String fname, lname, dep;
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[100];

        while (choice == 'y') {
            System.out.println("1. set detail 2. get detail 3. get cgpa 4. find student by age 5. average cgpa 6.exit");
            System.out.println("Enter choice:");
            int ch = sc.nextInt();
            sc.nextLine(); // Consume the newline left by nextInt()

            if (ch == 1) {
                i++;
                System.out.println("Enter details of student " + (i + 1));
                students[i] = new Student();

                System.out.println("Enter student id");
                id = sc.nextInt();
                sc.nextLine(); // Consume the newline left by nextInt()

                System.out.println("Enter student first name");
                fname = sc.nextLine();

                System.out.println("Enter student last name");
                lname = sc.nextLine();

                System.out.println("Enter student age");
                a = sc.nextInt();
                sc.nextLine(); // Consume the newline left by nextInt()

                System.out.println("Enter student department");
                dep = sc.nextLine();

                System.out.println("Enter student semester");
                sem = sc.nextInt();
                sc.nextLine(); // Consume the newline left by nextInt()

                System.out.println("Enter student cgpa");
                c = sc.nextInt();
                students[i].setdetails(id, fname, lname, a, dep, sem, c);
            } else if (ch == 2) {
                System.out.println("Enter student id whose details we want");
                int d = sc.nextInt();
                sc.nextLine(); // Consume the newline left by nextInt()
                //d - 1 is used as an index to access the student object in the array. Since array indices are zero-based, subtracting 1 from d allows you to access the correct element.
                System.out.println(students[d - 1].getDetails(d));
            } else if (ch == 3) {
                System.out.println("Enter student id whose cgpa we want");
                int d = sc.nextInt();
                sc.nextLine(); // Consume the newline left by nextInt()
                System.out.println(students[d - 1].getCGPA(d));
            } else if (ch == 4) {
                System.out.println("Enter student id whose age we want");
                int d = sc.nextInt();
                sc.nextLine(); // Consume the newline left by nextInt()
                System.out.println(students[d - 1].findage(d));
            } else if (ch == 5) {
                for(j=0;j<=i;j++){
                   s=s+students[i].cgpa;
                }
                System.out.println("Average CGPA is: " + (s/(i+1)));
            } else if (ch == 6) {
                choice = 'n'; // Exit loop when choice is 'n'
            } else {
                System.out.println("Invalid choice. Please enter a valid option.");
            }
            
            if (choice != 'n') {
                System.out.print("Do you want to do more operations? (y/n): ");
                ch=sc.next().charAt(0);
            }
        }
    }
}
               



