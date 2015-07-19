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
public class ImageMedia implements Serializable {

    private static final long serialVersionUID = 42L;

    public enum Type {
        MODEL,
        NON_MODEL,
        PREMIUM,
        STYLE,
        MANUFACTURER,
        UNSPECIFIED
    }

    private int orderNumber;
    private Type type;
    private String thumbnailHdUrl;
    private String smallUrl;
    private String smallHdUrl;
    private String mediumUrl;
    private String mediumHdUrl;
    private String largeUrl;
    private String largeHdUrl;

    public ImageMedia() {
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getThumbnailHdUrl() {
        return thumbnailHdUrl;
    }

    public void setThumbnailHdUrl(String thumbnailHdUrl) {
        this.thumbnailHdUrl = thumbnailHdUrl;
    }

    public String getSmallUrl() {
        return smallUrl;
    }

    public void setSmallUrl(String smallUrl) {
        this.smallUrl = smallUrl;
    }

    public String getSmallHdUrl() {
        return smallHdUrl;
    }

    public void setSmallHdUrl(String smallHdUrl) {
        this.smallHdUrl = smallHdUrl;
    }

    public String getMediumUrl() {
        return mediumUrl;
    }

    public void setMediumUrl(String mediumUrl) {
        this.mediumUrl = mediumUrl;
    }

    public String getMediumHdUrl() {
        return mediumHdUrl;
    }

    public void setMediumHdUrl(String mediumHdUrl) {
        this.mediumHdUrl = mediumHdUrl;
    }

    public String getLargeUrl() {
        return largeUrl;
    }

    public void setLargeUrl(String largeUrl) {
        this.largeUrl = largeUrl;
    }

    public String getLargeHdUrl() {
        return largeHdUrl;
    }

    public void setLargeHdUrl(String largeHdUrl) {
        this.largeHdUrl = largeHdUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImageMedia that = (ImageMedia) o;

        if (orderNumber != that.orderNumber) return false;
        if (type != that.type) return false;
        if (thumbnailHdUrl != null ? !thumbnailHdUrl.equals(that.thumbnailHdUrl) : that.thumbnailHdUrl != null)
            return false;
        if (smallUrl != null ? !smallUrl.equals(that.smallUrl) : that.smallUrl != null) return false;
        if (smallHdUrl != null ? !smallHdUrl.equals(that.smallHdUrl) : that.smallHdUrl != null) return false;
        if (mediumUrl != null ? !mediumUrl.equals(that.mediumUrl) : that.mediumUrl != null) return false;
        if (mediumHdUrl != null ? !mediumHdUrl.equals(that.mediumHdUrl) : that.mediumHdUrl != null) return false;
        if (largeUrl != null ? !largeUrl.equals(that.largeUrl) : that.largeUrl != null) return false;
        return !(largeHdUrl != null ? !largeHdUrl.equals(that.largeHdUrl) : that.largeHdUrl != null);

    }

    @Override
    public int hashCode() {
        int result = orderNumber;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (thumbnailHdUrl != null ? thumbnailHdUrl.hashCode() : 0);
        result = 31 * result + (smallUrl != null ? smallUrl.hashCode() : 0);
        result = 31 * result + (smallHdUrl != null ? smallHdUrl.hashCode() : 0);
        result = 31 * result + (mediumUrl != null ? mediumUrl.hashCode() : 0);
        result = 31 * result + (mediumHdUrl != null ? mediumHdUrl.hashCode() : 0);
        result = 31 * result + (largeUrl != null ? largeUrl.hashCode() : 0);
        result = 31 * result + (largeHdUrl != null ? largeHdUrl.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ImageMedia{");
        sb.append("orderNumber=").append(orderNumber);
        sb.append(", type=").append(type);
        sb.append(", thumbnailHdUrl='").append(thumbnailHdUrl).append('\'');
        sb.append(", smallUrl='").append(smallUrl).append('\'');
        sb.append(", smallHdUrl='").append(smallHdUrl).append('\'');
        sb.append(", mediumUrl='").append(mediumUrl).append('\'');
        sb.append(", mediumHdUrl='").append(mediumHdUrl).append('\'');
        sb.append(", largeUrl='").append(largeUrl).append('\'');
        sb.append(", largeHdUrl='").append(largeHdUrl).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
