public class Transaction {
    double numCoins;

    public double getCoins(){
        return numCoins;
    }

    public Transaction (double coins){
        this.numCoins += coins;
    }
}
