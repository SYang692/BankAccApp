package BankAcc;

public class CheckingAcc extends Account{

    String debitCardNumber;
    String PIN;

    public CheckingAcc(String accountName, double balance, String SSN) {
        super(accountName, balance, SSN);
        setAccountNumber("2" + this.getAccountNumber());
        setCheckingBox();
    }

    @Override
    public void setRate() {
        rate = getBaseRate() * 0.15;
    }

    private void setCheckingBox() {
        this.debitCardNumber = String.format("%012d", (int) (Math.random() * Math.pow(10, 12)));
        this.PIN = String.format("%03d", (int) (Math.random() * 10000));
    }

    @Override
    public double transfer() {
        return 0;
    }

}
