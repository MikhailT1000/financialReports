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

//    @Temporal(TemporalType.DATE)
    @Column(name = "Purchase Date")
    private String purchaseDate;

//    @Temporal(TemporalType.DATE)
    @Column(name = "Date of Sale")
    private String saleDate;

    @Column(name = "Brand")
    private String brand;

    @Column(name = "Model")
    private String model;

    @Column(name = "Price")
    private double price;

    @Column(name = "Discount")
    private int discount;

    @Column(name = "Cost Price")
    private double costPrice;

    @Column(name = "Type")
    private String type;

    @Column(name = "Quantity")
    private int quantity;

    public AllData (){

    }

    public AllData(String purchaseDate, String saleDate, String brand, String model, double price, int discount, double costPrice, String type, int quantity) {
        this.purchaseDate = purchaseDate;
        this.saleDate = saleDate;
        this.brand = brand;
        this.model = model;
        this.price = price;
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

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String dateBuy) {
        this.purchaseDate = dateBuy;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String dateSell) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
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
