public class BitcoinAdapter implements MoneySystem {
    BitWallet bwallet = new BitWallet();
    double rate = 3801.27;

    public BitcoinAdapter(BitWallet bwallet){
        this.bwallet = bwallet;
    }
    public double getBalance() {
        return rate*bwallet.getBalance();
    }

    @Override
    public void withdrawal(double amountInDollars) {
        bwallet.withdrawal(amountInDollars/rate);
    }

    @Override
    public void deposit(double amountInDollars) {
        bwallet.deposit(amountInDollars/rate);
    }
}
