package com.hepeng.baselibrary.bean;

public class MemberFlowTotalBean {

    /**
     * income : 0
     * disburse : 0
     */

    private double income;
    private double disburse;

    public double getIncome() {
        if (income < 0) {
            return 0.0;
        }
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getDisburse() {
        return Math.abs(disburse);
    }

    public void setDisburse(double disburse) {
        this.disburse = disburse;
    }
}
