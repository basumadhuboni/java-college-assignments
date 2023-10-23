import java.util.Scanner;
public class A2P1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int i,n,s=0;
        System.out.println("enter number of elements in array:");
        n=sc.nextInt();
        int[] arr= new int[n];
        System.out.println("enter elements in array:");
        for(i=0;i<n;i++){
            arr[i]=sc.nextInt();
            s=s+arr[i];
        }
        System.out.print("average is: "+(s/n));
    }   
}
