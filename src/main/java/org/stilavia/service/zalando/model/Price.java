/*
 * Copyright (c) 2015 Stilavia
 */

package org.stilavia.service.zalando.model;

/**
 * Created by guillermoblascojimenez on 04/07/15.
 */
public class Price {

    private String currency;
    private double value;
    private String formatted;

    public Price() {
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getFormatted() {
        return formatted;
    }

    public void setFormatted(String formatted) {
        this.formatted = formatted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Price price = (Price) o;

        if (Double.compare(price.value, value) != 0) return false;
        if (currency != null ? !currency.equals(price.currency) : price.currency != null) return false;
        return !(formatted != null ? !formatted.equals(price.formatted) : price.formatted != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = currency != null ? currency.hashCode() : 0;
        temp = Double.doubleToLongBits(value);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (formatted != null ? formatted.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Price{");
        sb.append("currency='").append(currency).append('\'');
        sb.append(", value=").append(value);
        sb.append(", formatted='").append(formatted).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
