package myweekendtask.walletproblem;

import myweekendtask.walletproblem.exceptions.SufficientBalanceNotInWallet;
import myweekendtask.walletproblem.exceptions.NotAValidAmountException;

public class Wallet {

    private Currency currency = new Currency(0.0, CurrencyType.Rupee);

    public Wallet() {

    }

    public double add(Currency currency) throws NotAValidAmountException {
        this.currency = this.currency.add(currency);
        return currency.amount;
    }

    public double retreive(Currency currency) throws SufficientBalanceNotInWallet {
        this.currency = this.currency.retreive(currency);
        return currency.amount;
    }

    public double getBalanceAmount(CurrencyType type) {
        return this.currency.getBalance(type);
    }

}
