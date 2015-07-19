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

import java.io.Serializable;

/**
 * Created by guillermoblascojimenez on 04/07/15.
 */
public class Price implements Serializable {

    private static final long serialVersionUID = 42L;

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
