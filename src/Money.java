/**
 * @author Hang Xu
 */
public class Money {
    private double amount;
    private Currency currency;

    /**
     * By default, the money is U.S. Dollars
     * @param amount: double
     */
    public Money(double amount) {
        this.amount = amount;
        this.currency = Currency.USD;
    }

    /**
     * Get amount of Money using a specific Currency using default currency USD
     * @return double
     */
    public double getAmount() {
        return this.currency.exchangeRate * this.amount;
    }

    /**
     * Get amount of Money using a specific Currency
     * @param currency: Currency
     * @return double
     */
    public double getAmount(Currency currency) {
        return currency.exchangeRate * this.amount;
    }

    /**
     * Set an balance using Money object. Currently, always return true.
     * @param amount: double
     * @return boolean
     */
    public boolean setAmount(double amount) {
        this.amount = amount;
        return true;
    }

    public String getUSD() {
        return this.currency.toString() + " " + this.amount;
    }

    public String getEURO() {
        return Currency.EURO.toString() + " " + Currency.EURO.exchangeRate * this.amount;
    }

    public String getCNY() {
        return Currency.CNY.toString() +  " " + Currency.CNY.exchangeRate * this.amount;
    }

    @Override
    public String toString() {
        return this.getUSD() + "(" + this.getEURO() + ", " + this.getCNY() + ")";
    }

}
