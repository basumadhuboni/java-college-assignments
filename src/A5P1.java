import java.util.Scanner;

class Employee {
    int empid;
    String empname;
    String emprole;
    float empsal;
    int empjoindate;
    String empmail;
    
    Employee() {
    }

    public void setDetails() {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter employee id");
        this.empid = sc1.nextInt();
        sc1.nextLine();
        System.out.println("Enter employee name");
        this.empname = sc1.nextLine();

        System.out.println("Enter employee role");
        this.emprole = sc1.nextLine();

        System.out.println("Enter employee salary");
        this.empsal = sc1.nextFloat();
        sc1.nextLine();

        System.out.println("Enter employee joining date");
        this.empjoindate = sc1.nextInt();
        sc1.nextLine();

        System.out.println("Enter emp mail");
        this.empmail = sc1.nextLine();
    }

    public String getDetails(int id) {
        if (this.empid == id) {
            return "Employee ID: " + empid + "\n" + "Name: " + empname + "\n" + "Role: " + emprole
                    + "\n" + "Salary: " + empsal + "\n" + "Joining Date: " + empjoindate + "\n" + "Mail: " + empmail;
        } else {
            return "Employee not found.";
        }
    }

    public static void updateDetails(Employee emp) {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter new employee name");
        emp.empname = sc1.nextLine();

        System.out.println("Enter new employee role");
        emp.emprole = sc1.nextLine();

        System.out.println("Enter new employee salary");
        emp.empsal = sc1.nextFloat();
        sc1.nextLine();

        System.out.println("Enter new employee joining date");
        emp.empjoindate = sc1.nextInt();
        sc1.nextLine();

        System.out.println("Enter new employee mail");
        emp.empmail = sc1.nextLine();
    }

    public static void viewInfo(Employee[] emp, int k) {
        for (int j = 0; j <= k; j++) {
            System.out.println("Employee ID: " + emp[j].empid + "\n" + "Name: " + emp[j].empname + "\n" + "Role: " + emp[j].emprole
                    + "\n" + "Salary: " + emp[j].empsal + "\n" + "Joining Date: " + emp[j].empjoindate + "\n" + "Mail: " + emp[j].empmail);
        }
    }

    public static void salary(int id, Employee[] emp, int k) {
        for (int j = 0; j <= k; j++) {
            if (emp[j].empid == id) {
                System.out.println("Salary: " + emp[j].empsal);
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void list(Employee[] emp, int k) {
        for (int j = 0; j <= k; j++) {
            System.out.println(emp[j].empname);
        }
    }

    public static void compare(Employee[] emp, int id1, int id2, int k) {
        float salary1 = -1, salary2 = -1;

        for (int j = 0; j <= k; j++) {
            if (emp[j].empid == id1) {
                salary1 = emp[j].empsal;
            }
            if (emp[j].empid == id2) {
                salary2 = emp[j].empsal;
            }
        }

        if (salary1 > salary2) {
            System.out.println("Employee with ID " + id1 + " has a greater salary.");
        } else if (salary1 < salary2) {
            System.out.println("Employee with ID " + id2 + " has a greater salary.");
        } else {
            System.out.println("Both employees have the same salary.");
        }
    }
}

public class A5P1{
    public static void main(String args[]) {
        int i = -1, d, s1, s2, c;
        char choice = 'y';
        Scanner sc = new Scanner(System.in);
        Employee[] employ = new Employee[100];

        while (choice == 'y') {
            System.out.println("1. Set detail 2. Get detail 3. Update 4. View information 5. Calculate salary 6. List of all employees 7. Add or remove employee 8. Exit 9. Compare salaries");
            System.out.println("Enter choice:");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    employ[++i] = new Employee();
                    employ[i].setDetails();
                    break;
                case 2:
                    System.out.println("Enter ID of employee whose details you want to get");
                    d = sc.nextInt();
                    sc.nextLine();
                    System.out.println(employ[i].getDetails(d));
                    break;
                case 3:
                    System.out.println("Enter ID of employee whose details you want to update");
                    d = sc.nextInt();
                    sc.nextLine();
                    Employee.updateDetails(employ[d]);
                    break;
                case 4:
                    Employee.viewInfo(employ, i);
                    break;
                case 5:
                    System.out.println("Enter ID of employee whose salary you want to get");
                    s1 = sc.nextInt();
                    sc.nextLine();
                    Employee.salary(s1, employ, i);
                    break;
                case 6:
                    Employee.list(employ, i);
                    break;
                case 7:
                    System.out.println("Enter 1 for add 2 for remove");
                    c = sc.nextInt();
                    if (c == 1) {
                        i++;
                        employ[i] = new Employee();
                        employ[i].setDetails();
                    } else if (c == 2) {
                        System.out.println("Enter ID of employee to remove:");
                        int removeId = sc.nextInt();
                        sc.nextLine();
                        if (employ[removeId] != null) {
                            employ[removeId] = null;
                            System.out.println("Employee with ID " + removeId + " removed successfully.");
                        } else {
                            System.out.println("Employee not found.");
                        }
                    }
                    break;
                case 8:
                    choice = 'n';
                    break;
                case 9:
                    System.out.println("Enter two IDs of employees whose salaries you want to compare");
                    s1 = sc.nextInt();
                    sc.nextLine();
                    s2 = sc.nextInt();
                    sc.nextLine();
                    Employee.compare(employ, s1, s2, i);
                    break;
                default:
                    System.out.println("Invalid input");
            }

            if (choice != 'n') {
                System.out.print("Do you want to do more operations? (y/n): ");
                choice = sc.next().charAt(0);
            }
        }
    }
}