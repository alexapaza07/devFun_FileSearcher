package com.jalasoft.search.model;

public class SizeCriteria {
    private double upperLimit;
    private double lowerLimit;
    private String infUnit;

    SizeCriteria(double upperLimit,double lowerLimit,String infUnit){
        this.upperLimit=upperLimit;
        this.lowerLimit=lowerLimit;
        this.infUnit=infUnit;
    }
    public double getUpperLimit(){
        return upperLimit;
    }
    public double getLowerLimit(){
        return lowerLimit;
    }
    public String  getUnitInfo(){
        return infUnit;
    }
}
