public class Main {

    public static void main(String[] args) {
        BitWallet b = new BitWallet();
        b.deposit(12.5);
        b.deposit(10.5);
        b.deposit(18.5);
        double balance = b.getBalance();

        System.out.printf(String.valueOf(balance));
    }

}
