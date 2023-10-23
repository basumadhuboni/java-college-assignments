import java.util.Scanner;
public class A2P4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int i,n,t,k,j;
        System.out.println("enter number of elements in array:");
        n=sc.nextInt();
        int[] arr= new int[n];
        System.out.println("enter elements in array:");
        for(i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("enter value of k:");
        k=sc.nextInt();
       for(i=0;i<n;i++){
        for(j=0;j<(n-1-i);j++){
            if(arr[j]>arr[j+1]){
                t=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=t;
            }
        }
    }
       
        for(i=(n-1);i>=(n-k);i--){
           System.out.print(arr[i]+" ");
        }
       }
}
