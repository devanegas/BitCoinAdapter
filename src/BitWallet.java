import java.util.List;
import java.util.Vector;

public class BitWallet{
    Vector<Transaction> transactions;
    double balance;

    public BitWallet(){
        transactions = new Vector<Transaction>();
        balance = 0;
    }


    public void getTransactionRecord(){
        for(int i=0; i<transactions.size(); i++) {
            if(transactions.get(i).isValid == false){
                System.out.printf("[Cancelled] >");
            }
            System.out.printf("%d %s %.8f %s",i," --> ", transactions.get(i).getCoins(), "\n");
        }
    }

    public double getBalance() {
        double temp = 0;
        for(int i=0; i<transactions.size(); i++) {
            if(transactions.get(i).isValid)
                temp += transactions.get(i).getCoins();
        }

        balance = temp;
        return balance;
    }

    public void withdrawal(double amount) {
        double temp=0;
        boolean success = false;
        for(int i=0; i<transactions.size(); i++) {
            if(transactions.get(i).getCoins() > amount && transactions.get(i).isValid && !success){
                temp = transactions.get(i).getCoins() - amount;
                transactions.get(i).isValid = false;

                //Don't add transaction that adds zero
                if(temp !=0)
                    transactions.add(new Transaction((temp)));
                success = true;
            }
        }
        if(!success){
            if(getBalance() < amount){
                System.out.println("You don't have enough funds");
            }
            else{
                boolean enough = false;
                double sum=0;
                int numTrans = 0;
                while(!enough){
                    if(sum > amount)
                        enough = true;
                    else{
                        if(transactions.get(numTrans).isValid)
                            sum += transactions.get(numTrans).getCoins();
                        numTrans++;
                    }
                }
                for(int i =0;i<numTrans;i++){
                    transactions.get(i).isValid = false;
                }

                //Adds the transaction that fails.
                transactions.add(new Transaction((sum-amount)));
            }
        }
    }


    public void deposit(double amount) {
        transactions.add(new Transaction(amount));
    }
}
