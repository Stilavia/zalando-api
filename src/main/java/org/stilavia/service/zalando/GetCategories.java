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

package org.stilavia.service.zalando;

import org.codehaus.jackson.type.TypeReference;
import org.stilavia.service.zalando.model.Category;
import org.stilavia.service.zalando.model.PaginableResult;

/**
 * Created by guillermoblascojimenez on 16/06/15.
 */
public class GetCategories extends ExecutableRequestChain<PaginableResult<Category>> {

    private static final String PATH = "/categories";
    private static final TypeReference<PaginableResult<Category>> TYPE_REFERENCE = new TypeReference<PaginableResult<Category>>() {
    };

    public GetCategories(RequestContext context) {
        super(context, PATH, TYPE_REFERENCE);
    }

    public GetCategories page(int pageIndex) {
        super.getUriBuilder().addParameter("page", String.valueOf(pageIndex));
        return this;
    }

    public GetCategories pageSize(int pageSize) {
        super.getUriBuilder().addParameter("pageSize", String.valueOf(pageSize));
        return this;
    }

    public GetCategories name(String name) {
        super.getUriBuilder().addParameter("name", name);
        return this;
    }

    public GetCategories type(String type) {
        super.getUriBuilder().addParameter("type", type);
        return this;
    }

    public GetCategories outlet(boolean outlet) {
        super.getUriBuilder().addParameter("outlet", (outlet) ? "true" : "false");
        return this;
    }


    public GetCategories hidden(boolean hidden) {
        super.getUriBuilder().addParameter("hidden", (hidden) ? "true" : "false");
        return this;
    }

    public GetCategories targetGroup(String targetGroup) {
        super.getUriBuilder().addParameter("targetGroup", targetGroup);
        return this;
    }


}
