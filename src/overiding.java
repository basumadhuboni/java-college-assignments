import java.util.ArrayList;
import java.util.Scanner;

class User {
    String name;
    int id;
    User() {

    }

    User(String n, int i) {
        this.name = n;
        this.id = i;
    }

    public void showdetails(int d, ArrayList<User> users) {
        for (User u : users) {
            if (u.id == d) {
                System.out.println(u.name + " " + u.id);
            }
        }
    }
}

class Student extends User {
    int roll;
    int sem;

    Student() {

    }

    Student(String n, int i, int r, int s) {
        super(n, i);
        this.roll = r;
        this.sem = s;
    }

    public void showdetails(int r, ArrayList<User> users) {
        for (User u : users) {
            if (u instanceof Student) {
                Student student = (Student) u;
                if (student.roll == r) {
                    System.out.println(student.name + " " + student.id + " " + student.roll + " " + student.sem);
                }
            }
        }
    }
}

public class overiding {
    public static void main(String args[]) {
        ArrayList<User> users = new ArrayList<User>();
        Scanner sc = new Scanner(System.in);
        Student o1 = new Student("fg", 1, 5, 7);
        users.add(o1);
        Student o2 = new Student("dfgh", 8, 10, 4);
        users.add(o2);
        Student o3 = new Student("dfghj", 2, 1, 3);
        users.add(o3);

        for (User u : users) {
            if (u instanceof Student) {
                Student student = (Student) u;
                int r = u.roll;
                student.showdetails(r, users);
            }
        }
    }
}