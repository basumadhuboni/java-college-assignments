import java.util.Scanner;
import java.util.ArrayList;

class User {
    String name;
    int dob;
    int userid;

    User(String n, int d, int i) {
        name = n;
        dob = d;
        userid = i;
    }

    public void setDetails() {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("enter user name");
        this.name = sc1.next();
        System.out.println("enter date of birth");
        this.dob = sc1.nextInt();
        System.out.println("enter user id");
        this.userid = sc1.nextInt();
    }

    public void showDetails(User u) {
        System.out.println("user name:" + this.name);
        System.out.println("date of birth" + this.dob);
        System.out.println("user id" + this.userid);
    }
}

class Student extends User {
    int roll;
    int sem;
    int cpi;

    Student(String n, int d, int i, int r, int s, int c) {
        super(n, d, i);
        roll = r;
        sem = s;
        cpi = c;
    }

    public void setDetails() {
        super.setDetails();
        Scanner sc1 = new Scanner(System.in);
        System.out.println("enter roll no");
        this.roll = sc1.nextInt();
        System.out.println("enter sem");
        this.sem = sc1.nextInt();
        System.out.println("enter cpi");
        this.cpi = sc1.nextInt();
    }

    public void showDetails() {
        super.showDetails(this);
        System.out.println("roll number" + this.roll);
        System.out.println("sem" + this.sem);
        System.out.println("cpi" + this.cpi);
    }
}

class Staff extends User {
    int empid;
    char sec;
    String desg;

    Staff(String n, int d, int i, int e, char s, String de) {
        super(n, d, i);
        empid = e;
        sec = s;
        desg = de;
    }

    public void setDetails() {
        super.setDetails();
        Scanner sc1 = new Scanner(System.in);
        System.out.println("enter emp id");
        this.empid = sc1.nextInt();
        System.out.println("enter sec");
        this.sec = sc1.next().charAt(0);
        System.out.println("enter designation");
        this.desg = sc1.next();
    }

    public static void equal(Staff o1, Staff o2) {
        if (o1.desg.equals(o2.desg)) {
            System.out.print("yes");
        }
    }

    public void showDetails() {
        super.showDetails(this);
        System.out.println("empid" + this.empid);
        System.out.println("section" + this.sec);
        System.out.println("designation" + this.desg);
    }
}

class Faculty extends User {
    int empid;
    String dept;
    int nop;

    Faculty(String n, int d, int i, int e, String dp, int no) {
        super(n, d, i);
        empid = e;
        dept = dp;
        nop = no;
    }

    public void setDetails() {
        super.setDetails();
        Scanner sc1 = new Scanner(System.in);
        System.out.println("enter empid");
        this.empid = sc1.nextInt();
        System.out.println("enter department");
        this.dept = sc1.next();
        System.out.println("enter no pub");
        this.nop = sc1.nextInt();
    }

    public void showDetails() {
        super.showDetails(this);
        System.out.println("empid" + this.empid);
        System.out.println("department" + this.dept);
        System.out.println("no of publications" + this.nop);
    }

    public static void equal(Faculty o1, Faculty o2) {
        if (o1.dept.equals(o2.dept)) {
            System.out.print("yes");
        }
    }
}

public class user {
    public static void main(String[] args) {
        char ch = 'y';
        ArrayList<User> users = new ArrayList<User>();
        Scanner sc = new Scanner(System.in);
        while (ch == 'y') {
            System.out.println("1.create object 2.set details 3.display details \n enter your choice");
            int c = sc.nextInt();
            switch (c) {
                case 1:
                    System.out.println("create object of 1.student 2.staff.3.faculty \n enter your choice");
                    int c1 = sc.nextInt();
                    System.out.println("enter user name");
                    String n = sc.next();
                    System.out.println("enter date of birth");
                    int d = sc.nextInt();
                    System.out.println("enter user id");
                    int id = sc.nextInt();
                    if (c1 == 1) {
                        System.out.println("enter roll");
                        int r = sc.nextInt();
                        System.out.println("enter sem");
                        int s = sc.nextInt();
                        System.out.println("enter cpi");
                        int cp = sc.nextInt();

                        Student ob = new Student(n, d, id, r, s, cp);
                        users.add(ob);
                    } else if (c1 == 2) {
                        System.out.println("enter employee id");
                        int i = sc.nextInt();
                        System.out.println("enter section");
                        char se = sc.next().charAt(0);
                        System.out.println("enter designation");
                        String de = sc.next();

                        Staff ob = new Staff(n, d, id, i, se, de);
                        users.add(ob);
                    } else {
                        System.out.println("enter employee id");
                        int i = sc.nextInt();
                        System.out.println("enter department");
                        String dep = sc.next();
                        System.out.println("enter no of publications");
                        int np = sc.nextInt();

                        Faculty ob = new Faculty(n, d, id, i, dep, np);
                        users.add(ob);
                    }
                    break;
                case 2:
                    System.out.println("set details of object of 1.student 2.staff.3.faculty \n enter your choice");
                    int c2 = sc.nextInt();
                    if (c2 == 1) {
                        Student o = new Student("", 0, 0, 0, 0, 0);
                        o.setDetails();
                        users.add(o);
                    } else if (c2 == 2) {
                        Staff o = new Staff("", 0, 0, 0, ' ', "");
                        o.setDetails();
                        users.add(o);
                    } else {
                        Faculty o = new Faculty("", 0, 0, 0, "", 0);
                        o.setDetails();
                        users.add(o);
                    }
                    break;
                case 3:
                    System.out.println("show details based on 1.dob 2.usedid 3.empid\n enter your choice");
                    int c3 = sc.nextInt();
                    if (c3 == 1) {
                        System.out.print("enter the dob");
                        int db = sc.nextInt();
                        for (User u : users) {
                            if (u.dob == db) {
                                u.showDetails(u);
                            }
                        }
                    } else if (c3 == 2) {
                        System.out.print("enter the used id");
                        int ui = sc.nextInt();
                        for (User u : users) {
                            if (u.userid == ui) {
                                u.showDetails(u);
                            }
                        }
                    } else {
                        System.out.print("enter the empid");
                        int ei = sc.nextInt();
                        for (User u : users) {
                            if (u instanceof Staff && ((Staff) u).empid == ei) {
                                u.showDetails(u);
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("invalid input");
            }
            System.out.println("do you want to perform more operations?");
            ch = sc.next().charAt(0);
        }
    }
}