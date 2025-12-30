package com.saintdenis.economy.model;

import jakarta.persistence.*;

@Entity
@Table(name = "trader_prices")
public class TraderPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String productName;
    private double buyPrice;
    private double sellPrice;
    private double profit;
    private int deliveryTimeMinutes;

    public TraderPrice() {

    }

    public TraderPrice(String productName,
            double buyPrice, double sellPrice,
            int deliveryTimeMinutes) {
        this.productName = productName;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.deliveryTimeMinutes = deliveryTimeMinutes;
        this.profit = sellPrice - buyPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public double getProfit() {
        return sellPrice - buyPrice; // Calculate on-the-fly instead of returning stored value
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public int getDeliveryTimeMinutes() {
        return deliveryTimeMinutes;
    }

    public void setDeliveryTimeMinutes(int deliveryTimeMinutes) {
        this.deliveryTimeMinutes = deliveryTimeMinutes;
    }

}
