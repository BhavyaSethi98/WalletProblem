package myweekendtask.walletproblem;

public enum CurrencyType {
    Rupee(1)
    , Dollar(74.85);

    public double equivalence;

    CurrencyType(double value) {
        this.equivalence = value;
    }

}
