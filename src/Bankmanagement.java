import java.util.Scanner;
import java.util.ArrayList;

class BankAccount{
    int accno;
    String accname;
    double bal;
   
   BankAccount(){
      Scanner sc = new Scanner(System.in);
      System.out.println("enter account number");
      this.accno = sc.nextInt();
      System.out.println("enter account holder name");
      this.accname = sc.next();
      System.out.println("enter account balance");
      this.bal = sc.nextDouble();
   }

   public  void deposit(double balance){
      this.bal = this.bal + balance;
   }

   public void withdraw(double w){
      if(w > this.bal){
         System.out.println("you have insufficient balance!!");
      }
      else{
         this.bal = this.bal - w;
      } 
   }

   public static void display(ArrayList<BankAccount> bankacc){
      for(BankAccount b : bankacc){
         System.out.println("acc no:" + b.accno + " account holder name: " + b.accname + " balance: " + b.bal + "\n");
      }
   }
}

class SavingsAccount extends BankAccount{
   int rate;

   SavingsAccount(){
      super();
   }

   public  void interest(int rate){
      System.out.println("interest is " + ((bal * rate) / 100.0));
      this.bal = this.bal + ((this.bal * rate) / 100.0);
   }
}

class CheckingAccount extends BankAccount{
   Scanner sc2 = new Scanner(System.in);
   double overdraftlimit;

   CheckingAccount(){
      super();
      System.out.println("enter over draft limit ");
      overdraftlimit = sc2.nextDouble();
   }

   @Override
   public void withdraw(double ow){
      if(ow > (this.bal + overdraftlimit)){
         System.out.println("not allowed");
      } 
      else{
         this.bal = this.bal - ow;
      }
   }
}

public class Bankmanagement{
   public static void main(String args[]){
      int c, c1;
      ArrayList<BankAccount> account = new ArrayList<>();
      Scanner sc = new Scanner(System.in);
      char ch = 'y';
      while(ch == 'y'){
         System.out.println("1.create account 2.deposit money 3.withdraw money 4.display 5.interest 6.withdraw over draft limit");
         System.out.println("enter your choice");
         c = sc.nextInt();
         switch(c){
            case 1:
               System.out.println("1.create account savings account 2.create checking account");
               System.out.println("enter your choice");
               c1 = sc.nextInt();
               if(c1 == 1){
                  SavingsAccount obs = new SavingsAccount();
                  account.add(obs);
               }
               else{
                  CheckingAccount obc = new CheckingAccount();
                  account.add(obc);
               }
               break;
            case 2:
               System.out.println("enter the amount we want to deposit ");
               double d = sc.nextDouble();
               System.out.println("enter the account no where we want to deposit ");
               int a = sc.nextInt();
               for(BankAccount b : account){
                  if(b.accno == a){
                     b.deposit(d);
                  }
               }
               break;
            case 3:
               System.out.println("enter the amount we want to withdraw ");
               double wd = sc.nextDouble();
               System.out.println("enter the account no where we want to withdraw");
               int ac = sc.nextInt();
               for(BankAccount b : account){
                  if(b.accno == ac){
                     b.withdraw(wd);
                  }
               }
               break;
            case 4:
               BankAccount.display(account);
               break;
            case 5:
               System.out.println("enter the rate of interest");
               int r = sc.nextInt();
               for(BankAccount b : account){
                  if(b instanceof SavingsAccount){
                     ((SavingsAccount) b).interest(r);
                  }
               }
               break;
         }
         System.out.println("do you want to perform more operations");
         ch = sc.next().charAt(0);
      }
   }
}