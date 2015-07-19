/*
 * Copyright 2015 Stilavia S.L.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.stilavia.service.zalando.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * Created by guillermoblascojimenez on 04/07/15.
 */
public class Unit implements Serializable {

    private static final long serialVersionUID = 42L;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Unit unit = (Unit) o;

        if (available != unit.available) return false;
        if (stock != unit.stock) return false;
        if (id != null ? !id.equals(unit.id) : unit.id != null) return false;
        if (partnerId != null ? !partnerId.equals(unit.partnerId) : unit.partnerId != null) return false;
        if (size != null ? !size.equals(unit.size) : unit.size != null) return false;
        if (price != null ? !price.equals(unit.price) : unit.price != null) return false;
        return !(originalPrice != null ? !originalPrice.equals(unit.originalPrice) : unit.originalPrice != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (partnerId != null ? partnerId.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (originalPrice != null ? originalPrice.hashCode() : 0);
        result = 31 * result + (available ? 1 : 0);
        result = 31 * result + stock;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Unit{");
        sb.append("id='").append(id).append('\'');
        sb.append(", partnerId='").append(partnerId).append('\'');
        sb.append(", size='").append(size).append('\'');
        sb.append(", price=").append(price);
        sb.append(", originalPrice=").append(originalPrice);
        sb.append(", available=").append(available);
        sb.append(", stock=").append(stock);
        sb.append('}');
        return sb.toString();
    }
}
