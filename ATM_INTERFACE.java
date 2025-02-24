package internship;
import java.util.Scanner;

public class ATM_INTERFACE {
    static double balance = 0;  
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the ATM machine.");
        
        while (true) {
            System.out.println("""
                Choose from the following options: 
                1. Checking balance 
                2. Deposit
                3. Withdraw
                4. Exit""");
            System.out.print("Enter choice: ");
            int choice = ValidNumber(input);

            switch (choice) {
                case 1: CheckingBalance();break;
                case 2: Deposit(); break;
                case 3: Withdrawal();break;
                case 4: {
                    System.out.println("Adios!");
                    System.exit(0);
                }break;
                default: System.out.println("Invalid input");  
            }
            System.out.println(); 
        }
    }

//______________________________________________________________________________
    public static void CheckingBalance() {
        System.out.println("Current Balance: AED " + balance);
    }

//______________________________________________________________________________
    public static void Deposit() {
        double deposit;
        do {
            System.out.print("Enter the amount of money you want to deposit: ");
            deposit = ValidDouble(input);
            if (deposit <= 0) {
                System.out.println("The deposit amount must be greater than zero.");
            }
        } while (deposit <= 0);

        balance += deposit;
        System.out.println("Deposited amount: AED " + deposit + "\nCurrent Balance: AED " + balance);
    }

//______________________________________________________________________________
    public static void Withdrawal() {
        double withdrawal;
        do {
            System.out.print("Enter the amount of money you want to withdraw: ");
            withdrawal = ValidDouble(input);

            if (withdrawal <= 0) {
                System.out.println("Withdrawal amount must be greater than zero.");
            } else if (withdrawal > balance) {
                System.out.println("You don't have enough balance. Your current balance is AED " + balance);
            }
        } while (withdrawal <= 0 || withdrawal > balance);

        balance -= withdrawal;
        System.out.println("Withdrawal amount: AED " + withdrawal + "\nCurrent Balance: AED " + balance);
    }

//______________________________________________________________________________
    public static int ValidNumber(Scanner input) {
        String choice;
        while (true) {
            choice = input.next();
            if (choice.matches("[1-4]")) {
                return Integer.parseInt(choice);
            }
            System.out.print("You should only enter numbers from 1 to 4!\nEnter the correct input: ");
        }
    }

//______________________________________________________________________________
    public static double ValidDouble(Scanner input) {
        while (!input.hasNextDouble()) {
            System.out.print("Invalid input! Enter a valid number: ");
            input.next();
        }
        return input.nextDouble();
    }
}
