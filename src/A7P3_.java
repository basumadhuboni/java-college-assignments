import java.util.Arrays;
import java.util.Comparator;

interface Driver {
    void driveCar();
    void driveBike();
}

interface Singer {
    void sing();
    void riyaz();
}

class Person {
    protected int age;

    public Person(int age) {
        this.age = age;
    }

    public void eat() {
        System.out.println("Person is eating.");
    }

    public void sleep() {
        System.out.println("Person is sleeping.");
    }
}

class Employee extends Person implements Driver, Singer {
    public Employee(int age) {
        super(age);
    }

    @Override
    public void driveCar() {
        if (age < 40) {
            System.out.println("Driving car. Earns 10 points.");
        } else {
            System.out.println("Cannot drive car. Age is over 40.");
        }
    }

    @Override
    public void driveBike() {
        if (age < 40) {
            System.out.println("Driving bike. Earns 5 points.");
        } else {
            System.out.println("Cannot drive bike. Age is over 40.");
        }
    }

    @Override
    public void sing() {
        if (age < 20) {
            System.out.println("Singing. Earns 15 points.");
        } else {
            System.out.println("Cannot sing. Age is over 20.");
        }
    }
    public void riyaz(){
        System.out.println("Employee is doing riyaz.");
    }

    public int officeWork() {
        if (age < 40) {
            return 20;
        } else {
            return 0;
        }
    }

    public int calculateEIF() {
        int eif = 0;
        if (age < 40) {
            eif += 10;
            eif += 5;
        }
        if (age < 20) {
            eif += 15;
        }
        eif += officeWork();
        return eif;
    }

    @Override
    public String toString() {
        return "Employee with age " + age;
    }
}

public class A7P3_ {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];

        employees[0] = new Employee(25);
        employees[1] = new Employee(35);
        employees[2] = new Employee(45);
        employees[3] = new Employee(18);
        employees[4] = new Employee(30);

        int[] eifValues = new int[5];

        for (int i = 0; i < 5; i++) {
            eifValues[i] = employees[i].calculateEIF();
        }

        sort(employees, eifValues);

        System.out.println("Employees sorted by Employee Importance Factor (EIF):");
        for (Employee employee : employees) {
            System.out.println(employee + " with EIF: " + employee.calculateEIF());
        }
    }

    public static void sort(Employee[] employees, int[] eifValues) {
        Integer[] indices = new Integer[employees.length];
        for (int i = 0; i < employees.length; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, Comparator.comparingInt(index -> eifValues[index]));

        Employee[] sortedEmployees = new Employee[employees.length];
        int[] sortedEIFValues = new int[eifValues.length];

        for (int i = 0; i < employees.length; i++) {
            sortedEmployees[i] = employees[indices[i]];
            sortedEIFValues[i] = eifValues[indices[i]];
        }

        System.arraycopy(sortedEmployees, 0, employees, 0, employees.length);
        System.arraycopy(sortedEIFValues, 0, eifValues, 0, eifValues.length);
    }
}