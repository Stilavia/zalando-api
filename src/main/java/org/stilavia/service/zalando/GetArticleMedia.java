/*
 * Copyright (c) 2015 Stilavia
 */

package org.stilavia.service.zalando;

import org.codehaus.jackson.type.TypeReference;
import org.stilavia.service.zalando.model.Media;

/**
 * Created by guillermoblascojimenez on 04/07/15.
 */
public class GetArticleMedia extends ExecutableRequestChain<Media> {

    private static final String PATH = "/media";
    private static final TypeReference<Media> TYPE_REFERENCE = new TypeReference<Media>() {
    };
    public GetArticleMedia(RequestChain parent) {
        super(parent, PATH, TYPE_REFERENCE);
    }
}
