package BankAcc;

import utility.CSV;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class BankAccApp {
    public static void main(String[] args) {



        String file = ".\\src\\utility\\NewBankAccounts.csv";
        List<String[]> data = CSV.read(file);

        List<Account> accounts = new LinkedList<>();

        for (String[] row : data) {
            if(row[2].equals("Savings")) {
                accounts.add(new SavingAcc(row[0], Integer.parseInt(row[3]), row[1]));
            }
            else if(row[2].equals("Checking")) {
                accounts.add(new CheckingAcc(row[0], Integer.parseInt(row[3]), row[1]));
            }
        }

        for (Account acc : accounts) {acc.showinfo();}


    }
}
