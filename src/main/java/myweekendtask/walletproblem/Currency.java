package myweekendtask.walletproblem;

public class Currency {

    final double amount;
    final CurrencyType type;


    private Currency(double magnitude, CurrencyType type) {
        this.amount = magnitude;
        this.type = type;
    }

    public static Currency rupees(double value) {
        return new Currency(value, CurrencyType.Rupee);
    }

    public static Currency dollars(double value) {
        return new Currency(value, CurrencyType.Dollar);
    }


}
