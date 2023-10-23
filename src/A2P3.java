import java.util.Scanner;
public class A2P3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a,b,c,max=0;
        System.out.println("enter the 3 numbers");
        a=sc.nextInt();
        b=sc.nextInt();
        c=sc.nextInt();
        if(a>b){
            if(a>c){
                max=a;
            }
            else{
                max=c;
            }
        }  
        else if(b>c){
            max=b;
        }
        else if(c>b){
            max=c;
        }
        System.out.println("using if else the max element is: "+max);
        max=a>b?(a>c?a:c):(b>c?b:c);
        System.out.println("using ternary the max element is: "+max);
    }   
}
