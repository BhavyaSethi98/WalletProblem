package myweekendtask.walletproblem;

public class AmountNotPresentInWallet extends Exception {
    public AmountNotPresentInWallet(String amount_not_in_wallet) {
        super(amount_not_in_wallet);
    }
}
