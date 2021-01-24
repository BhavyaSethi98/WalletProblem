package myweekendtask.walletproblem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class WalletTest {
    @Test
    void shouldNotThrowExceptionForPuttingMoneyInWallet() {
        Rupee currencyValue = new Rupee(20.0);
        Wallet wallet = new Wallet();

        assertDoesNotThrow(() -> wallet.add(currencyValue));
    }

    @Test
    void shouldThrowExceptionIfValidAmountIsNotAdded() {
        Rupee currencyValue = new Rupee(-20.0);
        Wallet wallet = new Wallet();

        assertThrows(NotAValidAmountException.class, () -> wallet.add(currencyValue));
    }

    @Test
    void shouldNotThrowExceptionIfAmountIsRetreived() throws NotAValidAmountException {
        Rupee currencyValue = new Rupee(20.0);
        Wallet wallet = new Wallet();

        wallet.add(currencyValue);

        assertDoesNotThrow(() -> wallet.retreive(currencyValue));
    }

    @Test
    void shouldThrowExceptionIfAmountIsRetreivedFromEmptyWallet() throws NotAValidAmountException {
        Rupee currency1 = new Rupee(20.0);
        Rupee currency2 = new Rupee(10.0);
        Wallet wallet = new Wallet();

        wallet.add(currency2);

        assertThrows(AmountNotPresentInWallet.class, () -> wallet.retreive(currency1));
    }

    @Test
    void shouldReturnTotalAmountIfPreferredCurrencyIsRupee() throws NotAValidAmountException {
        Wallet wallet = new Wallet();
        Rupee rupee = new Rupee(50.0);
        Dollars dollars = new Dollars(1.0);

        wallet.add(rupee);
        wallet.add(dollars);
        double result = wallet.sumIn(rupee);

        assertEquals(124.5, result, 0.001);
    }

    @Test
    void shouldReturnTotalAmountIfPreferredCurrencyIsDollar() throws NotAValidAmountException {

        Wallet wallet1 = new Wallet();
        Rupee rupee1 = new Rupee(74.85);
        Rupee rupee2 = new Rupee(149.7);
        Dollars dollars = new Dollars(1.0);

        wallet1.add(rupee1);
        wallet1.add(rupee2);
        wallet1.add(dollars);
        double result = wallet1.sumIn(dollars);

        assertEquals(4, result, 0.1);
    }
}
