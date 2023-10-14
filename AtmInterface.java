package ourpackage;

import java.util.Scanner;

class BankAccount{
	private double balance;
	public BankAccount(double initialBalance) {
		balance = initialBalance;
	}
	
	public double getBalance() {
		return balance;
	}
	public void deposite(double amount) {
		if(amount>0) {
			balance += amount;
			System.out.println("Deposite Successful.New balance: $"+ balance);
		}else {
			System.out.println("Invalid deposite amount.");
		}
	}
	public void withdraw(double amount) {
		if(amount>0 && amount<=balance) {
			balance -= amount;
			System.out.println("Withdrawal successfull. New balance: $"+ balance);
		}else {
			System.out.println("Invalid withdrawal amount of insufficient balance.");
		}
	}
}
class ATM{
	private BankAccount account;
	public ATM(BankAccount account) {
		this.account = account;
	}

	public void displayOptions() {
		System.out.println("Welcome to the ATM Machine");
		System.out.println("1.Check Balance");
		System.out.println("2. Deposite");
		System.out.println("3. Withdraw");
		System.out.println("4. Exit");
	}
	public void performTransaction() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			displayOptions();
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Your balance is $ "+ account.getBalance());
				break;
			case 2:
				System.out.println("Enter the deposite amount: $");
				double depositeAmount = sc.nextDouble();
				account.deposite(depositeAmount);
				break;
			case 3:
				System.out.println("Enter the withdrawal ammount: $");
				double withdrawalAmount = sc.nextDouble();
				account.withdraw(withdrawalAmount);
				break;
			case 4:
				System.out.println("Thank you for using the ATM. Goodbye!");
				sc.close();
				return;
				default:
					System.out.println("Invalid choice. Please select a valid option");
			}
				
			}
		}
	}
public class AtmInterface{
	
	public static void main(String[] args) {
		BankAccount userAccount = new BankAccount(1000.0);
		ATM atm = new ATM(userAccount);
		atm.performTransaction();
		

	}

}
