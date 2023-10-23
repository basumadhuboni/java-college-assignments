interface Driver {
    void driveCar();
    void driveBike();
}

interface Singer {
    void riyaz();
    void sing();
}

class Person {
    int age;

    public Person(int age) {
        this.age = age;
    } 
    
    void eat() {
        System.out.println("Person is eating.");
    }

    void sleep() {
        System.out.println("Person is sleeping.");
    }
}

class Employee extends Person implements Driver, Singer {
    public Employee(int age) {
        super(age);
    }

    @Override
    public void driveCar() {
        int drivingPoints = (age < 40) ? 10 : 0;
        System.out.println("Employee is driving a car. Earned " + drivingPoints + " points.");
    }

    @Override
    public void driveBike() {
        int drivingPoints = (age < 40) ? 5 : 0;
        System.out.println("Employee is driving a bike. Earned " + drivingPoints + " points.");
    }

    @Override
    public void riyaz() {
        int singingPoints = (age < 20) ? 15 : 0;
        System.out.println("Employee is doing riyaz. Earned " + singingPoints + " points.");
    }

    @Override
    public void sing() {
        int singingPoints = (age < 20) ? 15 : 0;
        System.out.println("Employee is singing. Earned " + singingPoints + " points.");
    }

    void officeWork() {
        int officePoints = (age < 40) ? 20 : 10;
        System.out.println("Employee is doing office work. Earned " + officePoints + " points.");
    }
}

public class A7P2_ {
    public static void main(String[] args) {
        Employee employee1 = new Employee(35);
        employee1.driveCar();
        employee1.driveBike();
        employee1.eat();
        employee1.officeWork();

        Employee employee2 = new Employee(18);
        employee2.sing();
        employee2.riyaz();
        employee2.sleep();
        employee2.officeWork();
    }
}