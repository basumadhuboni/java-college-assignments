abstract class Shape {
    abstract double RectangleArea(double length, double breadth);
    abstract double SquareArea(double side);
    abstract double CircleArea(double radius);
}

class Area extends Shape {
    @Override
    double RectangleArea(double length, double breadth) {
        return length * breadth;
    }

    @Override
    double SquareArea(double side) {
        return side * side;
    }

    @Override
    double CircleArea(double radius) {
        return Math.PI * radius * radius;
    }
}

public class A7P1_{
    public static void main(String[] args) {
        Area areaCalculator = new Area();

        double rectangleArea = areaCalculator.RectangleArea(4, 6);
        double squareArea = areaCalculator.SquareArea(5);
        double circleArea = areaCalculator.CircleArea(3);

        System.out.println("Area of the rectangle: " + rectangleArea);
        System.out.println("Area of the square: " + squareArea);
        System.out.println("Area of the circle: " + circleArea);
    }
}