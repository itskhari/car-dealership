package com.pluralsight;

public class LeaseContract extends Contract {

    private double expectedEndingValue, leaseFee;

    public LeaseContract(String date, String name, String email, Vehicle vehicle) {
        super(date, name, email, vehicle);
        this.expectedEndingValue = vehicle.getPrice() * 0.50;
        this.leaseFee = vehicle.getPrice() * 0.07;
    }

    // method(s)
    @Override
    public double getTotalPrice() {
        return vehicle.getPrice() + expectedEndingValue + leaseFee;
    }

    @Override
    public double getMonthlyPay() {
        double principal = getTotalPrice();
        double rate = 0.04 / 12;  // 4.0% annual / 12 months
        int months = 36;

        return (principal * rate) / (1 - Math.pow(1 + rate, -months));
    }


    // getters and setters
    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }
}
