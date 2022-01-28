package com.ynov.devandroiddevoir.bo;


import java.io.Serializable;

public class Accommodation implements Serializable {
    String title;
    double price;
    double rate;
    ImageBnb illustrations;

    public Accommodation(String title, double price, double rate, ImageBnb illustrations) {
        this.title = title;
        this.price = price;
        this.rate = rate;
        this.illustrations = illustrations;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return Double.toString(price)+"€/nuit";
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public ImageBnb getIllustrations() {
        return illustrations;
    }

    public void setIllustrations(ImageBnb illustrations) {
        this.illustrations = illustrations;
    }
}
