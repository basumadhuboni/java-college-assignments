class area {
   int radius;
   area(){  //non parametereized constructor
     radius=3;
   } 
   area(int rad){ // parameterized constructor
      radius=rad;
   }
   public int calc(int r){ // parameterized method
    return (2*3*r*r);
   }
   public int calc2(){ // non parameterized method
      return (2*3*radius*radius);
   }
}
public class constructor{
    public static void main(String args[]) {
        area ar=new area(); // we are creating object ar for calling the non parameterized constructor
        int a=ar.calc(3);
        System.out.println("area from is:"+a);
        //non parametised method uses value assigned to the radius in the non parameterized constructor 
        int a2=ar.calc2();
        System.out.println("area from is:"+a2);
        area ar2=new area(4);// we create anoother object for calling the parameterized constructor 
        int a3=ar2.calc2();
        System.out.println("area from is:"+a3);
        int a4=ar2.calc(10);
        System.out.println("area from is:"+a4);
    }
}
