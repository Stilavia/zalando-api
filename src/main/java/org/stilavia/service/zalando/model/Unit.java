/*
 * Copyright (c) 2015 Stilavia
 */

package org.stilavia.service.zalando.model;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * Created by guillermoblascojimenez on 04/07/15.
 */
public class Unit {

    private String id;
    @JsonIgnore
    private String partnerId;
    private String size;
    private Price price;
    private Price originalPrice;
    private boolean available;
    private int stock;

    public Unit() {
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Price getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Price originalPrice) {
        this.originalPrice = originalPrice;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
