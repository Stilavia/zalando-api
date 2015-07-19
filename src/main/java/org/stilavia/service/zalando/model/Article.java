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
import java.util.Date;
import java.util.List;

/**
 * Created by guillermoblascojimenez on 15/06/15.
 */
public class Article implements Serializable {

    private static final long serialVersionUID = 42L;

    private String id;
    private String modelId;
    private String name;
    private String shopUrl;
    private String color;
    private boolean available;
    private String season;
    private String seasonYear;
    private Date activationDate;
    private List<String> genders;
    private List<String> additionalInfos;
    private List<String> ageGroups;
    private Brand brand;
    private List<String> categoryKeys;
    private List<Unit> units;
    private Media media;
    private List<Attribute> attributes;

    public Article() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShopUrl() {
        return shopUrl;
    }

    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getSeasonYear() {
        return seasonYear;
    }

    public void setSeasonYear(String seasonYear) {
        this.seasonYear = seasonYear;
    }

    public Date getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    public List<String> getGenders() {
        return genders;
    }

    public void setGenders(List<String> genders) {
        this.genders = genders;
    }

    public List<String> getAdditionalInfos() {
        return additionalInfos;
    }

    public void setAdditionalInfos(List<String> additionalInfos) {
        this.additionalInfos = additionalInfos;
    }

    public List<String> getAgeGroups() {
        return ageGroups;
    }

    public void setAgeGroups(List<String> ageGroups) {
        this.ageGroups = ageGroups;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<String> getCategoryKeys() {
        return categoryKeys;
    }

    public void setCategoryKeys(List<String> categoryKeys) {
        this.categoryKeys = categoryKeys;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        if (available != article.available) return false;
        if (id != null ? !id.equals(article.id) : article.id != null) return false;
        if (modelId != null ? !modelId.equals(article.modelId) : article.modelId != null) return false;
        if (name != null ? !name.equals(article.name) : article.name != null) return false;
        if (shopUrl != null ? !shopUrl.equals(article.shopUrl) : article.shopUrl != null) return false;
        if (color != null ? !color.equals(article.color) : article.color != null) return false;
        if (season != null ? !season.equals(article.season) : article.season != null) return false;
        if (seasonYear != null ? !seasonYear.equals(article.seasonYear) : article.seasonYear != null) return false;
        if (activationDate != null ? !activationDate.equals(article.activationDate) : article.activationDate != null)
            return false;
        if (genders != null ? !genders.equals(article.genders) : article.genders != null) return false;
        if (additionalInfos != null ? !additionalInfos.equals(article.additionalInfos) : article.additionalInfos != null)
            return false;
        if (ageGroups != null ? !ageGroups.equals(article.ageGroups) : article.ageGroups != null) return false;
        if (brand != null ? !brand.equals(article.brand) : article.brand != null) return false;
        if (categoryKeys != null ? !categoryKeys.equals(article.categoryKeys) : article.categoryKeys != null)
            return false;
        if (units != null ? !units.equals(article.units) : article.units != null) return false;
        if (media != null ? !media.equals(article.media) : article.media != null) return false;
        return !(attributes != null ? !attributes.equals(article.attributes) : article.attributes != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (modelId != null ? modelId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (shopUrl != null ? shopUrl.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (available ? 1 : 0);
        result = 31 * result + (season != null ? season.hashCode() : 0);
        result = 31 * result + (seasonYear != null ? seasonYear.hashCode() : 0);
        result = 31 * result + (activationDate != null ? activationDate.hashCode() : 0);
        result = 31 * result + (genders != null ? genders.hashCode() : 0);
        result = 31 * result + (additionalInfos != null ? additionalInfos.hashCode() : 0);
        result = 31 * result + (ageGroups != null ? ageGroups.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (categoryKeys != null ? categoryKeys.hashCode() : 0);
        result = 31 * result + (units != null ? units.hashCode() : 0);
        result = 31 * result + (media != null ? media.hashCode() : 0);
        result = 31 * result + (attributes != null ? attributes.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Article{");
        sb.append("id='").append(id).append('\'');
        sb.append(", modelId='").append(modelId).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", shopUrl='").append(shopUrl).append('\'');
        sb.append(", color='").append(color).append('\'');
        sb.append(", available=").append(available);
        sb.append(", season='").append(season).append('\'');
        sb.append(", seasonYear='").append(seasonYear).append('\'');
        sb.append(", activationDate=").append(activationDate);
        sb.append(", genders=").append(genders);
        sb.append(", additionalInfos=").append(additionalInfos);
        sb.append(", ageGroups=").append(ageGroups);
        sb.append(", brand=").append(brand);
        sb.append(", categoryKeys=").append(categoryKeys);
        sb.append(", units=").append(units);
        sb.append(", media=").append(media);
        sb.append(", attributes=").append(attributes);
        sb.append('}');
        return sb.toString();
    }
}
