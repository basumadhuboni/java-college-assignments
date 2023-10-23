import java.util.Scanner;

public class A3P1 {
    public static int[] mergeArray(int[] arr1, int[] arr2) {
        int l=arr1.length + arr2.length;
        int[] merged = new int[l];
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            merged[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            merged[k++] = arr2[j++];
        }

        return merged;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, n1, n2;
        System.out.println("Enter number of elements in array 1:");
        n1 = sc.nextInt();
        System.out.println("Enter number of elements in array 2:");
        n2 = sc.nextInt();
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        int l = n1 + n2;
        int[] mergedArray = new int[l];
        System.out.println("Enter elements in array 1:");
        for (i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }
        System.out.println("Enter elements in array 2:");
        for (i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }
        mergedArray = mergeArray(arr1, arr2);
        System.out.println("The sorted array is:");
        for (i = 0; i < l; i++) {
            System.out.print(mergedArray[i] + " ");
        }
    }
}