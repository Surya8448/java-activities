import java.util.Scanner;
class account_management {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student name: ");
        String username = sc.nextLine();
        System.out.print("Enter Student ID: ");
        double studentID = sc.nextInt();

        System.out.print("Account Number: ");
        int accountNumber = sc.nextInt();
        System.out.print("Enter the amount to deposit: ");
        double amount = sc.nextDouble();
        if (amount < 0) {
            System.out.println("Account creation failed. Amount cannot be negative.");
        } else {
            System.out.println("Account created successfully!");
        }
        System.out.println("1. Deposit Money");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Check Balance");
        System.out.println("4. Display account details");
        System.out.println("5. Calculate interest");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        switch(choice) {
            case 1:
                System.out.print("Enter the amount to deposit: ");
                double depositAmount = sc.nextDouble();
                if (depositAmount < 0) {
                    System.out.println("Deposit failed. Amount cannot be negative.");
                } else {
                    amount += depositAmount;
                    System.out.println("Deposit successful! New balance: " + amount);
                }
                break;
            case 2:
                System.out.print("Enter the amount to withdraw: ");
                double withdrawAmount = sc.nextDouble();
                if (withdrawAmount < 0) {
                    System.out.println("Withdrawal failed. Amount cannot be negative.");
                } else if (withdrawAmount > amount) {
                    System.out.println("Withdrawal failed. Insufficient balance.");
                } else {
                    amount -= withdrawAmount;
                    System.out.println("Withdrawal successful! New balance: " + amount);
                }
                break;
            case 3:
                System.out.println("Current balance: " + amount);
                break;
            case 4:
                System.out.println("Account Details:");
                System.out.println("Student Name: " + username);
                System.out.println("Student ID: " + studentID);
                System.out.println("Account Number: " + accountNumber);
                System.out.println("Balance: " + amount);
                break;
            case 5:
                double interestRate = 0.05;
                System.out.println("Enter number of years");
                int years=sc.nextInt();
                double interest = amount * interestRate*years;
                System.out.println("Interest earned: " + interest);
                break;
            case 6:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
