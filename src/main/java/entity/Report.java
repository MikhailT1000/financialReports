package entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Report")
public class Report {

    private int numberOfSoldCars;
    private double revenue;
    private double averageRevenue;
    private double costPrice;
    private double averageCost;
    private double margin;
    private double averageMargin;
    private int profitability;


}
