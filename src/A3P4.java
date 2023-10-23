import java.util.Scanner;

public class A3P4 { 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of test cases: ");
        int numTestCases = sc.nextInt();

        int[][] testCases = new int[numTestCases][]; // creating the 2 d array
        int totalOddCount = 0;
        int totalEvenCount = 0;

        for (int i = 0; i < numTestCases; i++) {
            System.out.print("Enter the number of elements for test case " + (i + 1) + ": ");
            int numElements = sc.nextInt();
            testCases[i] = new int[numElements];
            
              // entering elements in each test case
            System.out.println("Enter the elements for test case " + (i + 1) + ": ");
            for (int j = 0; j < numElements; j++) {
                testCases[i][j] = sc.nextInt();
                if (testCases[i][j] % 2 == 0) {
                    totalEvenCount++;
                } else {
                    totalOddCount++;
                }
            }
        }

        System.out.println("Results:");
        for (int i = 0; i < numTestCases; i++) {
            int oddCount = 0;
            int evenCount = 0;

            for (int num : testCases[i]) {
                if (num % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
            }

            System.out.println("Test Case " + (i + 1) + ": Odd Count = " + oddCount + ", Even Count = " + evenCount);
        }

        System.out.println("Overall Count: Odd Count = " + totalOddCount + ", Even Count = " + totalEvenCount);

        sc.close();
    }
}