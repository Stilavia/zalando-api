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

import com.google.common.base.Optional;

/**
 * Created by guillermoblascojimenez on 15/06/15.
 */
class RequestChain {

    private final RequestContext context;

    private final Optional<RequestChain> parent;

    private final String path;

    public RequestChain(RequestContext context, String path) {
        this.context = context;
        this.path = path;
        this.parent = Optional.absent();
    }

    public RequestChain(RequestContext context, RequestChain parent, String path) {
        this.context = context;
        this.parent = Optional.of(parent);
        this.path = path;
    }

    protected String resolvePath() {
        return ((parent.isPresent()) ? parent.get().resolvePath() : "") + path;
    }

    protected RequestContext getContext() {
        return context;
    }
}
