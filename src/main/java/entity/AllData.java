package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Data")
public class AllData {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Operator operator;

    @Temporal(TemporalType.DATE)
    @Column(name = "PurchaseDate")
    private Date purchaseDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "DateOfSale")
    private Date saleDate;

    @Column(name = "Brand")
    private String brand;

    @Column(name = "Model")
    private String model;

    @Column(name = "PurchasePrice")
    private double purchasePrice;

    @Column(name = "SalePrice")
    private double salePrice;

    @Column(name = "Discount")
    private double discount;

    @Column(name = "CostPrice")
    private double costPrice;

    @Column(name = "Type")
    private String type;

    @Column(name = "Quantity")
    private int quantity;

    public AllData (){

    }

    public AllData(Date purchaseDate, Date saleDate, String brand, String model, double purchasePrice, double salePrice, double discount, double costPrice, String type, int quantity) {
        this.purchaseDate = purchaseDate;
        this.saleDate = saleDate;
        this.brand = brand;
        this.model = model;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.discount = discount;
        this.costPrice = costPrice;
        this.type = type;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date dateBuy) {
        this.purchaseDate = dateBuy;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date dateSell) {
        this.saleDate = dateSell;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double price) {
        this.purchasePrice = purchasePrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
}
