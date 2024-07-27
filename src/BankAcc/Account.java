package BankAcc;

import java.io.Serializable;

public abstract class Account implements IBaseRate{
    private String accountName;
    private double balance;
    private String accountNumber;
    public double rate;
    private String SSN;
    private static int uniqueNumber = 1000;



    public Account(String accountName, double balance, String SSN) {
        this.accountName = accountName;
        this.balance = balance;
        this.SSN = SSN;
        this.accountNumber = setAccountNumber();
        setRate();
    }

    private String setAccountNumber() {
        String lastTwoOFSSN = SSN.substring(SSN.length()-2, SSN.length());
        int uniqueID = uniqueNumber++;
        int randomNumber = (int) (Math.random()*1000);
        return lastTwoOFSSN + uniqueID + String.format("%03d", randomNumber);
    }

    public void compound(){
        double newBalance = balance * (rate/100);
        System.out.println("Interest: " + newBalance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void deposit(double amount){
        balance = balance + amount;
    }
    public void withdrawal(double amount) {
        balance = balance - amount;
    }
    public abstract double transfer();

    public void showinfo(){
        System.out.println("Account Name: " + accountName + "\nAccount Number: " + accountNumber + "\nBalance: " + balance);
        if(this.accountNumber.charAt(0) == '1'){
            System.out.println("Saving Account!");
        }else {
            System.out.println("Checking Account!");
        }
    }

    public abstract void setRate();


}
