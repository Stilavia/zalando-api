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
import java.util.List;

/**
 * Created by guillermoblascojimenez on 04/07/15.
 */
public class Media implements Serializable {

    private static final long serialVersionUID = 42L;

    private List<ImageMedia> images;

    public Media() {
    }

    public List<ImageMedia> getImages() {
        return images;
    }

    public void setImages(List<ImageMedia> images) {
        this.images = images;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Media media = (Media) o;

        return !(images != null ? !images.equals(media.images) : media.images != null);

    }

    @Override
    public int hashCode() {
        return images != null ? images.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Media{");
        sb.append("images=").append(images);
        sb.append('}');
        return sb.toString();
    }
}
