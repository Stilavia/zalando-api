/*
 * Copyright (c) 2015 Stilavia
 */

package org.stilavia.service.zalando;

import org.codehaus.jackson.type.TypeReference;
import org.stilavia.service.zalando.model.Article;
import org.stilavia.service.zalando.model.PaginableResult;

/**
 * Created by guillermoblascojimenez on 04/07/15.
 */
public class GetArticles extends ExecutableRequestChain<PaginableResult<Article>> {

    private static final String PATH = "/articles";
    private static final TypeReference<PaginableResult<Article>> TYPE_REFERENCE = new TypeReference<PaginableResult<Article>>() {
    };

    public GetArticles(RequestContext context) {
        super(context, PATH, TYPE_REFERENCE);
    }

    public GetArticles page(int pageIndex) {
        super.getUriBuilder().addParameter("page", String.valueOf(pageIndex));
        return this;
    }

    public GetArticles pageSize(int pageSize) {
        super.getUriBuilder().addParameter("pageSize", String.valueOf(pageSize));
        return this;
    }

    public GetArticles name(String name) {
        super.getUriBuilder().addParameter("name", name);
        return this;
    }
}
