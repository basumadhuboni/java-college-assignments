import java.util.Scanner;

class Vehicle {
    protected String make;
    protected String model;
    protected int year;

    public Vehicle(String make, String model, int year){
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public void start() {
        System.out.println("Vehicle is starting.");
    }

    public void stop() {
        System.out.println("Vehicle is stopping.");
    }

    public void displayInfo() {
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }
}

class Car extends Vehicle {
    private int numDoors;
    private boolean isConvertible;

    public Car(String make, String model, int year, int numDoors, boolean isConvertible) {
        super(make, model, year);
        this.numDoors = numDoors;
        this.isConvertible = isConvertible;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Number of Doors: " + numDoors);
        System.out.println("Convertible: " + isConvertible);
    }
}

class Motorcycle extends Vehicle {
    private int engineSize;
    private boolean hasFairing;

    public Motorcycle(String make, String model, int year, int engineSize, boolean hasFairing) {
        super(make, model, year);
        this.engineSize = engineSize;
        this.hasFairing = hasFairing;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Engine Size: " + engineSize + " cc");
        System.out.println("Has Fairing: " + hasFairing);
    }
}

public class A7P3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Create Car");
            System.out.println("2. Create Motorcycle");
            System.out.println("3. Start Vehicle");
            System.out.println("4. Stop Vehicle");
            System.out.println("5. Display Vehicle Info");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter make: ");
                    String makeCar = scanner.next();
                    System.out.print("Enter model: ");
                    String modelCar = scanner.next();
                    System.out.print("Enter year: ");
                    int yearCar = scanner.nextInt();
                    System.out.print("Enter number of doors: ");
                    int numDoors = scanner.nextInt();
                    System.out.print("Is it convertible (true/false): ");
                    boolean isConvertible = scanner.nextBoolean();

                    Car myCar = new Car(makeCar, modelCar, yearCar, numDoors, isConvertible);
                    myCar.displayInfo();
                    break;

                case 2:
                    System.out.print("Enter make: ");
                    String makeMotorcycle = scanner.next();
                    System.out.print("Enter model: ");
                    String modelMotorcycle = scanner.next();
                    System.out.print("Enter year: ");
                    int yearMotorcycle = scanner.nextInt();
                    System.out.print("Enter engine size (in cc): ");
                    int engineSize = scanner.nextInt();
                    System.out.print("Does it have a fairing (true/false): ");
                    boolean hasFairing = scanner.nextBoolean();

                    Motorcycle myMotorcycle = new Motorcycle(makeMotorcycle, modelMotorcycle, yearMotorcycle, engineSize, hasFairing);
                    myMotorcycle.displayInfo();
                    break;

                case 3:
                    System.out.println("Starting Vehicle...");
                    break;

                case 4:
                    System.out.println("Stopping Vehicle...");
                    break;

                case 5:
                    System.out.println("Displaying Vehicle Info...");
                    break;

                case 6:
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }
}