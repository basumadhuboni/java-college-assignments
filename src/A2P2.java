import java.util.Scanner;
public class A2P2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int i,n,max;
        System.out.println("enter number of elements in array:");
        n=sc.nextInt();
        int[] arr= new int[n];
        System.out.println("enter elements in array:");
        for(i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        max=arr[0];
        for(i=1;i<n;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        System.out.println("max element is :"+max);
        int max2=arr[0];
        for(i=0;i<n;i++){
            if(arr[i]<max && arr[i]>max2){
                max2=arr[i];
            }
        }
        System.out.println("second latgest element is :"+max2);
    }   
}
