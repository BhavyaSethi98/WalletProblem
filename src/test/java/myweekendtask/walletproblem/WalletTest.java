package myweekendtask.walletproblem;

import myweekendtask.walletproblem.exceptions.SufficientBalanceNotInWallet;
import myweekendtask.walletproblem.exceptions.NotAValidAmountException;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.hamcrest.MatcherAssert.assertThat;


public class WalletTest {
    @Test
    void shouldReturnAmounAfterRupeeIsAddedInWallet() throws NotAValidAmountException {
        Wallet wallet = new Wallet();
        Currency twentyRupees = Currency.rupees(20);

        assertEquals(20, wallet.add(twentyRupees));
        assertEquals(20,wallet.getBalanceAmount(CurrencyType.Rupee));
    }

    @Test
    void shouldThrowExceptionIfValidAmountIsNotAdded() {
        Wallet wallet = new Wallet();
        Currency twentyRupees = Currency.rupees(-20);

        assertThrows(NotAValidAmountException.class, () -> wallet.add(twentyRupees));
    }

    @Test
    void shouldReturnAmountAfterDollarsIsAddedInWallet() throws NotAValidAmountException {
        Wallet wallet = new Wallet();
        Currency oneDollar = Currency.dollars(1);

        assertThat(wallet.add(oneDollar), is(closeTo(1, 0.15)));
        assertEquals(1,wallet.getBalanceAmount(CurrencyType.Dollar));
    }

    @Test
    void shouldBeAbleToRetrieveAmountInRupeesFromWalletIfCurrencyTypeIsInRupees() throws NotAValidAmountException, SufficientBalanceNotInWallet {
        Wallet wallet = new Wallet();
        Currency twentyRupees = Currency.rupees(20);

        wallet.add(twentyRupees);

        double retrievedAmount = wallet.retreive(twentyRupees);

        assertEquals(20, retrievedAmount);
        assertEquals(0,wallet.getBalanceAmount(CurrencyType.Rupee));
    }


    @Test
    void shouldBeAbleToRetrieveAmountInDollarsFromWalletIfCurrencyIsInDollars() throws NotAValidAmountException, SufficientBalanceNotInWallet {
        Wallet wallet = new Wallet();
        Currency oneDollar = Currency.dollars(1);
        Currency twentyRupees = Currency.rupees(20);

        wallet.add(oneDollar);
        wallet.add(twentyRupees);

        assertThat(wallet.retreive(oneDollar), is(closeTo(1, 0.15)));
        assertEquals(20,wallet.getBalanceAmount(CurrencyType.Rupee));
    }


    @Test
    void shouldThrowExceptionIfAmountIsRetreivedFromEmptyWallet() throws NotAValidAmountException {
        Wallet wallet = new Wallet();
        Currency oneDollar = Currency.dollars(1);
        Currency twentyRupees = Currency.rupees(20);

        wallet.add(twentyRupees);

        assertThrows(SufficientBalanceNotInWallet.class, () -> wallet.retreive(oneDollar));
    }

    @Test
    void shouldReturnTotalAmountIfPreferredCurrencyIsRupee() throws NotAValidAmountException {
        Wallet wallet = new Wallet();
        Currency fiftyRupees = Currency.rupees(50);
        Currency oneDollar = Currency.dollars(1);

        wallet.add(fiftyRupees);
        wallet.add(oneDollar);

        double result = wallet.getBalanceAmount(CurrencyType.Rupee);

        assertEquals(124.5, result, 0.85);
    }

    @Test
    void shouldReturnTotalAmountIfPreferredCurrencyIsDollar() throws NotAValidAmountException {

        Wallet wallet = new Wallet();
        Currency rupee1 = Currency.rupees(74.85);
        Currency rupee2 = Currency.rupees(149.7);
        Currency dollars = Currency.dollars(1.0);

        wallet.add(rupee1);
        wallet.add(rupee2);
        wallet.add(dollars);

        double result = wallet.getBalanceAmount(CurrencyType.Dollar);

        assertEquals(4, result, 0.15);
    }
}
