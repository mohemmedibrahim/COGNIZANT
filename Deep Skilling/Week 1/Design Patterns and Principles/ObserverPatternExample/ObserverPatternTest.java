public class ObserverPatternTest {

    public static void main(String[] args) {

        // Create Stock Market
        StockMarket stockMarket = new StockMarket("TCS");

        // Create Observers
        Observer mobileUser = new MobileApp("Alice");
        Observer webUser = new WebApp("Bob");

        // Register Observers
        stockMarket.registerObserver(mobileUser);
        stockMarket.registerObserver(webUser);

        // Change Stock Price
        stockMarket.setStockPrice(3500.50);

        // Remove one Observer
        stockMarket.deregisterObserver(webUser);

        // Change Stock Price Again
        stockMarket.setStockPrice(3605.75);
    }
}