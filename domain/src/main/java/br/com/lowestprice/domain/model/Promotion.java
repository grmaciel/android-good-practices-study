package br.com.lowestprice.domain.model;

import java.util.Date;

/**
 * Created by Gilson Maciel on 01/08/2015.
 */
public class Promotion {
    private String productName;
    private Double productPrice;
    private Date insertedAt;
    private String placeName;
    private String placeAdress;

    public Promotion(String productName, Double productPrice, Date insertedAt, String placeName, String placeAdress) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.insertedAt = insertedAt;
        this.placeName = placeName;
        this.placeAdress = placeAdress;
    }

    public String getProductName() {
        return productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public Date getInsertedAt() {
        return insertedAt;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getPlaceAdress() {
        return placeAdress;
    }
}
