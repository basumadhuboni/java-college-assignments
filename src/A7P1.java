public class A7P1{
    public static void main(String[] args) {
       
        if (args.length < 2) {
            if (args.length == 0) {
                System.out.println("Error: No numbers to add.");
            } else {
                System.out.println("Error: Add requires at least two numbers.");
            }
        } else {
            int sum = 0;
            for (String arg : args) {
                try {
                    int num = Integer.parseInt(arg);
                    sum += num;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Invalid input, please provide numbers only.");
                    return;
                }
            }
            System.out.println("Sum: " + sum);
        }
    }
}