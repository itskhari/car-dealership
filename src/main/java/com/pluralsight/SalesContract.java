package com.pluralsight;

public class SalesContract extends Contract {
    private double salesTax, recordingFee, processingFee;
    private boolean isFinanced;

    public SalesContract(String date, String name, String email, Vehicle vehicle, double salesTax, int recordingFee, int processingFee, boolean isFinanced) {
        super(date, name, email, vehicle);
        this.salesTax = vehicle.getPrice() * 0.05;
        this.recordingFee = 100;
        this.isFinanced = isFinanced;

        if (vehicle.getPrice() < 10000) {
            this.processingFee = 295;
        } else {
            this.processingFee = 495;
        }
    }


    // method(s)
    @Override
    public double getTotalPrice() {
        return vehicle.getPrice() + salesTax + recordingFee + processingFee;
    }

    @Override
    public double getMonthlyPay() {
        double principal = getTotalPrice();
        double rate;
        int months;

        if (!isFinanced) return 0;

        if (vehicle.getPrice() >= 10000) {
            rate = 0.0425 / 12;
            months = 48;
        } else {
            rate = 0.0525 / 12;
            months = 24;
        }
        return (principal * rate) / (1 - Math.pow(1 + rate, -months));
    }
    // getters and setters
    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanced() {
        return isFinanced;
    }

    public void setFinanced(boolean financed) {
        isFinanced = financed;
    }
}




