package myweekendtask.walletproblem;

public class NotAValidAmountException extends Exception {
    public NotAValidAmountException(String not_a_valid_amount) {
        super(not_a_valid_amount);
    }
}
