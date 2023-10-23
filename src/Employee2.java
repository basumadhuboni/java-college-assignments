import java.util.ArrayList;
import java.util.Scanner;
 class Employee{
    int empid;
    String empname;
    double empsal;
    static int totale=0;
   
    /*Employee(<ArrayList>Employee emp){
        Scanner sc1=new Scanner(System.in);
        Employee obj=new Employee();
      printf("enter the employee id");
      int obj.empid=sc1.nextInt();
      printf("enter the employee name");
      String obj.empname=sc1.nextLine();
      printf("enter the employee salary");
      double obj.empsal=sc1.nextDouble();
       emp.add(obj);
    }*/
    public static void create(ArrayList<Employee> emp ){
         Scanner sc1=new Scanner(System.in);
        Employee obj=new Employee();
        System.out.println("enter the employee id");
        obj.empid=sc1.nextInt();
        System.out.println("enter the employee name");
        obj.empname=sc1.next();
        System.out.println("enter the employee salary");
        obj.empsal=sc1.nextDouble();
        emp.add(obj);
        totale++;
    }
    public static void remove(int i,ArrayList<Employee> emp){
       for(Employee e:emp){
         if(e.empid==i){
            emp.remove(e);
         }
       }
       totale--;
    }
    public static void update(int i,ArrayList<Employee> emp){
        Scanner sc2=new Scanner(System.in);
       for(Employee e:emp){
         if(e.empid==i){
            System.out.println("enter the new employee name");
            e.empname=sc2.nextLine();
            System.out.println("enter the employee salary");
            e.empsal=sc2.nextDouble();

         }
       }
    }
    public static void display(ArrayList<Employee> emp){
        for(Employee e:emp){
            System.out.println(" employee id: "+e.empid);
            System.out.println(" employee name: "+e.empname);
           System.out.println("employee salary:"+e.empsal);
         }
       
    }
    public static void total(){
        System.out.print(totale);
    }
  }
   public class Employee2{
    public static void main(String args[]){
        try (Scanner sc = new Scanner(System.in)) {
            ArrayList<Employee> emp=new ArrayList<>();
             char ch='y';
             int i;
             while(ch=='y'){
                  System.out.println("1.create employee 2.delete employee 3.update details 4.display details 5.total \n enter your choice");
                  int c=sc.nextInt();
                  switch(c){
                    case 1:
                      Employee.create(emp);
                      break;
                    case 2:
                       System.out.println("enter id of the employee to be removed");
                       i=sc.nextInt();
                      Employee.remove(i,emp);
                      break;
                    case 3:
                      System.out.println("enter id of the employee to be updated");
                       i=sc.nextInt();
                      Employee.update(i,emp);
                      break;
                    case 4:
                       Employee.display(emp);
                       break;
                    case 5:
                       Employee.total();
                       break;
                    default:
                      System.out.println("invalid input");
                  }
                  System.out.println("do you want to perform more operations?");
                  ch=sc.next().charAt(0);
             }
        }
    }
  }

