package web;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class AddAllDataFormBean {
//    @Pattern(regexp = "[0-9]+(:[0-9]+)+", message = "Неверный формат кадастрового номера.")
//    private String cadNumber;
//    private String title;
//    private String address;
//    private String name;
//    private String passportNumber;

    @Temporal(TemporalType.DATE)
    private Date purchaseDate;
    @Temporal(TemporalType.DATE)
    private Date saleDate;
    private String brand;
    private String model;
    private double purchasePrice;
    private double salePrice;
    private double discount;
    private double costPrice;
    private String type;
    private int quantity;
    private String name;
    private String passportNumber;

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
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

    public void setPurchasePrice(double purchasePrice) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
}
