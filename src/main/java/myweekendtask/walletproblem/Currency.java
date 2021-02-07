package myweekendtask.walletproblem;

import myweekendtask.walletproblem.exceptions.NotAValidAmountException;
import myweekendtask.walletproblem.exceptions.SufficientBalanceNotInWallet;

public class Currency {

    final double amount;
    final CurrencyType type;


    Currency(double magnitude, CurrencyType type) {
        this.amount = magnitude;
        this.type = type;
    }

    public static Currency rupees(double value) {
        return new Currency(value, CurrencyType.Rupee);
    }

    public static Currency dollars(double value) {
        return new Currency(value, CurrencyType.Dollar);
    }


    public Currency add(Currency currency) throws NotAValidAmountException {
        if (currency.amount < 0) throw new NotAValidAmountException();

        return new Currency(valueInRupees(this) + valueInRupees(currency), this.type);
    }

    private double valueInRupees(Currency currency) {
        return currency.amount * currency.type.equivalence;
    }

    public Currency retreive(Currency currency) throws SufficientBalanceNotInWallet {
        if (!checkSufficientBalance(currency)) throw new SufficientBalanceNotInWallet();
        return new Currency(valueInRupees(this) - valueInRupees(currency), this.type);
    }

    private boolean checkSufficientBalance(Currency currency) {
        return this.amount >= valueInRupees(currency);
    }

    public double getBalance(CurrencyType type) {
        return type.equals(CurrencyType.Rupee) ? this.amount : this.amount / type.equivalence;
    }
}
