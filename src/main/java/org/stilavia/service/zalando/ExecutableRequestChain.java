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

import org.apache.http.client.utils.URIBuilder;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by guillermoblascojimenez on 15/06/15.
 */
class ExecutableRequestChain<E> extends RequestChain {

    private final TypeReference<E> typeReference;
    private final URIBuilder uriBuilder;

    public ExecutableRequestChain(RequestChain parent, String path, TypeReference<E> typeReference) {
        super(parent, path);
        this.uriBuilder = getContext().getUriBuilder();
        this.uriBuilder.setPath(resolvePath());
        this.typeReference = typeReference;
    }

    public ExecutableRequestChain(RequestContext context, String path, TypeReference<E> typeReference) {
        super(context, path);
        this.uriBuilder = getContext().getUriBuilder();
        this.uriBuilder.setPath(resolvePath());
        this.typeReference = typeReference;
    }

    protected URIBuilder getUriBuilder() {
        return this.uriBuilder;
    }

    public E get() throws IOException, URISyntaxException {
        RequestResponse response = getContext().execute(uriBuilder);
        if (response.getResponse() != null) {
            return getContext().getObjectMapper().readValue(response.getResponse(), typeReference);
        } else {
            return null;
        }
    }
}
