/*
 * Copyright (c) 2015 Stilavia
 */

package org.stilavia.service.zalando.model;

/**
 * Created by guillermoblascojimenez on 04/07/15.
 */
public class ImageMedia {

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

}
