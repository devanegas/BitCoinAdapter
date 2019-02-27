import java.util.List;
import java.util.Vector;

public class BitWallet implements MoneySystem{
    Vector<Transaction> transactions;
    double balance;

    public BitWallet(){
        transactions = new Vector<Transaction>();
        balance = 0;
    }

    public double getBalance() {
        for(int i=0; i<transactions.size(); i++) {
            System.out.println(i + " --> " + transactions.get(i).getCoins());
            balance += transactions.get(i).getCoins();
        }

        return balance;
    }

    @Override
    public void withdrawal(double amount) {

    }

    @Override
    public void deposit(double amount) {
        transactions.add(new Transaction(amount));
    }
}
