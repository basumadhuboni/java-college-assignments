import java.util.Scanner;

public class A3P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 0, j = 0, k = 0, n1, n2, n3;
        System.out.println("Enter number of elements in array 1:");
        n1 = sc.nextInt();
        System.out.println("Enter number of elements in array 2:");
        n2 = sc.nextInt();
        System.out.println("Enter number of elements in array 3:");
        n3 = sc.nextInt();
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        int[] arr3 = new int[n3];
        int[] result = new int[n1 + n2 + n3];
        System.out.println("Enter elements in array 1:");
        for (i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }
        System.out.println("Enter elements in array 2:");
        for (i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }
        System.out.println("Enter elements in array 3:");
        for (i = 0; i < n3; i++) {
            arr3[i] = sc.nextInt();
        }
        int f = 0;
        i = 0;
        j = 0;
        k = 0;
        while (i < n1 && j < n2 && k < n3) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                result[f] = arr1[i];
                i++;
                j++;
                k++;
                f++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr3[k]) {
                j++;
            } else {
                k++;
            }
        }
        System.out.println("Common elements are: ");
        for (i = 0; i < f; i++) {
            System.out.print(result[i] + " ");
        }
    }
}