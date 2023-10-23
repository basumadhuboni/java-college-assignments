import java.util.Scanner;
public class A2P5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("enter the sentence");
        String s=sc.nextLine();
        int cw=1,i,l1,c=0;
        int l=s.length();
        for(i=0;i<l;i++){
           if((s.charAt(i))==' '){
            cw=cw+1;
           }
        }
        System.out.println("the number of words are "+cw);
        System.out.println("the palindrome worda are:");
        for(String word: s.split(" ")){
            c=0;
             l1=word.length();
            for(i=0;i<(l1/2);i++){
                if(word.charAt(i)!=word.charAt(l1-i-1)){
                    c=1; 
                    break;   
                }
            }
            if(c==0){
                System.out.println(word);
            }
        }
       }
}
