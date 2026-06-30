import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {

    private final List<Observer> observers;
    private final String stockName;
    private double stockPrice;

    public StockMarket(String stockName) {
        this.stockName = stockName;
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, stockPrice);
        }
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
        System.out.println("\nStock Price Updated!");
        notifyObservers();
    }
}