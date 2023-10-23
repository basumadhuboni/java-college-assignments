import java.util.Scanner;
public class A3P3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int i,n;
        System.out.println("enter number of elements in array :");
        n=sc.nextInt();
        int[] arr= new int[n];
        System.out.println("enter elements in array:");
        for(i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int[] arr1= new int[n];  // creating  anew array to store
        int last=n-1;
        int front=0;
        for(i=0;i<n;i++){
            if(arr[i]==0){
                arr1[last]=arr[i];
                last--;
            }
            else{
                arr1[front]=arr[i];
                front++;
            }
        }
        System.out.println("the new array is ");
        for(i=0;i<n;i++){
            arr[i]=arr1[i];
             System.out.print(arr[i]+" ");
        }
    }   
}
