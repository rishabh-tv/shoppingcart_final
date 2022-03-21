public class eWallet {
    public double balance;

    public eWallet(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }


    public double addBalance(double addamount)
    {
        balance= balance+addamount;
        return balance;
    }
    public double deductBalance(double deductAmount)
    {
        if(balance> deductAmount){
            balance=balance-deductAmount;
            return balance;
        }
        else
            System.out.println("Not Sufficient Balance");
        return balance;
    }
    public boolean hasSufficientBalance(double totalAmount){
        return getBalance()>totalAmount;
    }
}
