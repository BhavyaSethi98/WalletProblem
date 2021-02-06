package myweekendtask.walletproblem;

import myweekendtask.walletproblem.exceptions.SufficientBalanceNotInWallet;
import myweekendtask.walletproblem.exceptions.NotAValidAmountException;

public class Wallet {

    private double totalMoney;


    public Wallet() {
        this.totalMoney = 0;
    }

    public double add(Currency currency) throws NotAValidAmountException {
        if (currency.amount < 0) throw new NotAValidAmountException();

        double moneyAdded = (currency.amount * currency.type.equivalence);
        totalMoney += moneyAdded;

        return currency.amount;
    }

    public double retreive(Currency currency) throws SufficientBalanceNotInWallet {

        Double value = currency.amount * currency.type.equivalence;

        if (!checkBalance(value)) throw new SufficientBalanceNotInWallet();

        totalMoney -= value;

        return currency.amount;
    }

    private boolean checkBalance(Double value) {
        return (totalMoney - value) >= 0;
    }

    public double getBalanceAmount(CurrencyType type) {
        return type.equals(CurrencyType.Rupee) ? totalMoney : totalMoney / CurrencyType.getDollarValueInRupees();
    }

}
