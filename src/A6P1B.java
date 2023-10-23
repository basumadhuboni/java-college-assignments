import java.util.*;
import java.util.Scanner;

class Employee {
    int employeeId;
    String employeeName;
    double employeeSalary;
    static int totalEmployeeCreated = 0;

    public Employee() {
        totalEmployeeCreated++;
    }

    void setDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        this.employeeId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Employee Name: ");
        this.employeeName = scanner.nextLine();
        System.out.print("Enter Employee Salary: ");
        this.employeeSalary = scanner.nextDouble();
    }

    void getDetails(int employeeId) {
        if (this.employeeId == employeeId) {
            System.out.println("Employee ID: " + this.employeeId);
            System.out.println("Employee Name: " + this.employeeName);
            System.out.println("Employee Salary: " + this.employeeSalary);
        }
    }

    void updateDetails(int employeeId) {
        if (this.employeeId == employeeId) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter new Employee Name: ");
            this.employeeName = scanner.nextLine();
            System.out.print("Enter new Employee Salary: ");
            this.employeeSalary = scanner.nextDouble();
        }
    }

    double getSalary(int employeeId) {
        if (this.employeeId == employeeId) {
            return this.employeeSalary;
        }
        return -1; // Employee not found
    }

    boolean removeEmployee(int employeeId) {
        if (this.employeeId == employeeId) {
            totalEmployeeCreated--;
            return true;
        }
        return false; // Employee not found
    }

    static int totalEmployee() {
        return totalEmployeeCreated;
    }

    static void displayEmployeeSort(ArrayList<Employee> employees) {
        //lambda expression sorts the array list depending on the employee names
        employees.sort((e1, e2) -> e1.employeeName.compareTo(e2.employeeName));
        
        for (Employee employee : employees) {
            System.out.println("Employee ID: " + employee.employeeId);
            System.out.println("Employee Name: " + employee.employeeName);
            System.out.println("Employee Salary: " + employee.employeeSalary);
            System.out.println();
        }
    }
}

public class A6P1B {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Create New Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Update Employee Details");
            System.out.println("4. Get Employee Salary");
            System.out.println("5. Total Employees");
            System.out.println("6. Display Employees (Sorted by Name)");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    Employee employee = new Employee();
                    employee.setDetails();
                    employees.add(employee);
                    break;

                case 2:
                    System.out.print("Enter Employee ID to delete: ");
                    int idToDelete = scanner.nextInt();
                    boolean removed = false;
                    for (Employee e : employees) {
                        if (e.removeEmployee(idToDelete)) {
                            employees.remove(e);
                            removed = true;
                            break;
                        }
                    }
                    if (removed) {
                        System.out.println("Employee with ID " + idToDelete + " deleted.");
                    } else {
                        System.out.println("Employee with ID " + idToDelete + " not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Employee ID to update: ");
                    int idToUpdate = scanner.nextInt();
                    for (Employee e : employees) {
                        if (e.employeeId == idToUpdate) {
                            e.updateDetails(idToUpdate);
                            break;
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter Employee ID to get salary: ");
                    int idToGetSalary = scanner.nextInt();
                    for (Employee e : employees) {
                        double salary = e.getSalary(idToGetSalary);
                        if (salary != -1) {
                            System.out.println("Salary of Employee with ID " + idToGetSalary + " is " + salary);
                            break;
                        }
                    }
                    break;

                case 5:
                    System.out.println("Total Employees: " + Employee.totalEmployee());
                    break;

                case 6:
                    Employee.displayEmployeeSort(employees);
                    break;

                case 7:
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
