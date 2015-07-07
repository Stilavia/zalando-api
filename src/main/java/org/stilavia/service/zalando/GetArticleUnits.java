/*
 * Copyright (c) 2015 Stilavia
 */

package org.stilavia.service.zalando;

import org.codehaus.jackson.type.TypeReference;
import org.stilavia.service.zalando.model.Unit;

import java.util.List;

/**
 * Created by guillermoblascojimenez on 04/07/15.
 */
public class GetArticleUnits extends ExecutableRequestChain<List<Unit>> {

    private static final String PATH = "/units";
    private static final TypeReference<List<Unit>> TYPE_REFERENCE = new TypeReference<List<Unit>>() { };

    public GetArticleUnits(RequestChain parent) {
        super(parent, PATH, TYPE_REFERENCE);
    }
}
