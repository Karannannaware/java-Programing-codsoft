import java.io.*;
public class atm {

  public static void displayBalance(int balance)
  {
    System.out.println("Current Balance : " + balance);
    System.out.println("Minimum balance should be maintained in your account");
    System.out.println();
  }

  public static int amountWithdrawing(int balance,int withdrawAmount)
  {
    System.out.println("Withdrawn Status:");
    System.out.println("Withdrawing Amount : " + withdrawAmount);
    if (balance >= withdrawAmount) 
    {
      balance = balance - withdrawAmount;
      System.out.println("Please collect your money and collect the card");
      displayBalance(balance);
    }
    else {
      System.out.println("Sorry! Insufficient Balance");
      System.out.println();
      
    }
    return balance;
  }

  public static int amountDepositing(int balance,int depositAmount)
  {
    System.out.println("Deposit Status:");
    System.out.println("Depositing Amount : " + depositAmount);
    balance = balance + depositAmount;
    System.out.println("Your Money has been successfully deposited in your account");
    System.out.println("Your deposited amount will be shown on the screen");
    displayBalance(balance);
    return balance;
  }

  public static void main(String args[])
  {
    int balance = 15000;
    int withdrawAmount = 2000;
    int depositAmount = 600;
    displayBalance(balance);
    balance= amountWithdrawing(balance, withdrawAmount);
        balance = amountDepositing(balance, depositAmount);
       System.out.println("Thank you.....");
       System.out.println("Have a nice day!");
  }
}