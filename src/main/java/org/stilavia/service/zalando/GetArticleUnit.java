/*
 * Copyright (c) 2015 Stilavia
 */

package org.stilavia.service.zalando;

import org.codehaus.jackson.type.TypeReference;
import org.stilavia.service.zalando.model.Unit;

/**
 * Created by guillermoblascojimenez on 04/07/15.
 */
public class GetArticleUnit extends ExecutableRequestChain<Unit> {


    private static final String PATH = "/units/%s";
    private static final TypeReference<Unit> TYPE_REFERENCE = new TypeReference<Unit>() { };

    private final String unitId;

    public GetArticleUnit(RequestChain parent, String unitId) {
        super(parent, getPath(unitId), TYPE_REFERENCE);
        this.unitId = unitId;
    }

    private static String getPath(String articleId) {
        return String.format(PATH, articleId);
    }
}
