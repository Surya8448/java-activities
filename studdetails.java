import java.util.Scanner;

class studdetails {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

       
        System.out.print("Enter student's name: ");
        String name = sc.nextLine();

    
        System.out.print("Enter marks in Subject 1: ");
        int sub1 = sc.nextInt();

        System.out.print("Enter marks in Subject 2: ");
        int sub2 = sc.nextInt();

        System.out.print("Enter marks in Subject 3: ");
        int sub3 = sc.nextInt();

      
        int total = sub1 + sub2 + sub3;

    
        double average = (double) total / 3;

       
        boolean pass = sub1 >= 35 && sub2 >= 35 && sub3 >= 35;

        boolean distinction = pass && average >= 75;

       
        boolean specialAward = pass && average >= 90
                && sub1 >= 80 && sub2 >= 80 && sub3 >= 80;

        System.out.println("\n----- STUDENT RESULT -----");
        System.out.println("Name       : " + name);
        System.out.println("Subject 1  : " + sub1);
        System.out.println("Subject 2  : " + sub2);
        System.out.println("Subject 3  : " + sub3);
        System.out.println("Total      : " + total);
        System.out.println("Average    : " + average);

        if (pass) {
            System.out.println("Result     : PASS");
        } else {
            System.out.println("Result     : FAIL");
        }

        if (distinction) {
            System.out.println("Distinction: YES");
        } else {
            System.out.println("Distinction: NO");
        }

        if (specialAward) {
            System.out.println("Special Award: YES");
        } else {
            System.out.println("Special Award: NO");
        }

        sc.close();
    }
}