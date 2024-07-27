package BankAcc;

public class SavingAcc extends Account{

    String safetyID;
    String safetyKey;

    public SavingAcc(String accountName, double balance, String SSN) {
        super(accountName, balance, SSN);
        setAccountNumber("1" + this.getAccountNumber());
        setSafetyDepositBox();
        

    }

    @Override
    public void setRate() {
        rate = getBaseRate() - 0.25;
    }

    private void setSafetyDepositBox() {
        this.safetyID = String.format("%03d", (int) (Math.random() * 1000));
        this.safetyKey = String.format("%04d", (int) (Math.random() * 10000));

    }

    @Override
    public double transfer() {
        return 0;
    }

}
