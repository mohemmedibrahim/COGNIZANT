package model;

public class FinancialData {

    private double presentValue;
    private double growthRate;
    private int years;

    public FinancialData(double presentValue, double growthRate, int years) {
        this.presentValue = presentValue;
        this.growthRate = growthRate;
        this.years = years;
    }

    public double getPresentValue() {
        return presentValue;
    }

    public double getGrowthRate() {
        return growthRate;
    }

    public int getYears() {
        return years;
    }
}