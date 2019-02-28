public class Transaction {
    double numCoins;
    boolean isValid;

    public double getCoins(){
        return numCoins;
    }

    public Transaction (double coins){
        this.numCoins += coins;
        this.isValid = true;
    }
}
