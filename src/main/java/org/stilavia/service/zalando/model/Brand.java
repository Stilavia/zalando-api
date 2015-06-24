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

/**
 * Created by guillermoblascojimenez on 16/06/15.
 */
public class Brand {
    private String key;
    private String name;
    private String logoUrl;
    private BrandFamily brandFamily;
    private String shopUrl;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public BrandFamily getBrandFamily() {
        return brandFamily;
    }

    public void setBrandFamily(BrandFamily brandFamily) {
        this.brandFamily = brandFamily;
    }

    public String getShopUrl() {
        return shopUrl;
    }

    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Brand brand = (Brand) o;

        if (key != null ? !key.equals(brand.key) : brand.key != null) return false;
        if (name != null ? !name.equals(brand.name) : brand.name != null) return false;
        if (logoUrl != null ? !logoUrl.equals(brand.logoUrl) : brand.logoUrl != null) return false;
        if (brandFamily != null ? !brandFamily.equals(brand.brandFamily) : brand.brandFamily != null) return false;
        return !(shopUrl != null ? !shopUrl.equals(brand.shopUrl) : brand.shopUrl != null);

    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (logoUrl != null ? logoUrl.hashCode() : 0);
        result = 31 * result + (brandFamily != null ? brandFamily.hashCode() : 0);
        result = 31 * result + (shopUrl != null ? shopUrl.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Brand{");
        sb.append("key='").append(key).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", logoUrl='").append(logoUrl).append('\'');
        sb.append(", brandFamily=").append(brandFamily);
        sb.append(", shopUrl='").append(shopUrl).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
