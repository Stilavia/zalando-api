/*
 * Copyright (c) 2015 Stilavia
 */

package org.stilavia.service.zalando.model;

import java.util.List;

/**
 * Created by guillermoblascojimenez on 04/07/15.
 */
public class Media {

    private List<ImageMedia> images;

    public Media() {
    }

    public List<ImageMedia> getImages() {
        return images;
    }

    public void setImages(List<ImageMedia> images) {
        this.images = images;
    }
}
