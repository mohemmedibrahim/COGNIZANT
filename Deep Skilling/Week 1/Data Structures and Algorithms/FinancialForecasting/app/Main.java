package app;

import model.FinancialData;
import service.FinancialForecast;

public class Main {

    public static void main(String[] args) {

        FinancialData data = new FinancialData(10000, 0.10, 5);

        FinancialForecast forecast = new FinancialForecast();

        double result = forecast.calculateFutureValue(
                data.getPresentValue(),
                data.getGrowthRate(),
                data.getYears());

        System.out.println("Present Value : " + data.getPresentValue());
        System.out.println("Growth Rate   : " + (data.getGrowthRate() * 100) + "%");
        System.out.println("Years         : " + data.getYears());
        System.out.println("Future Value  : " + result);
    }
}