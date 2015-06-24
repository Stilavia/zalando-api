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
import org.stilavia.service.zalando.model.Filter;

import java.util.List;

/**
 * Created by guillermoblascojimenez on 16/06/15.
 */
public class GetFilters extends ExecutableRequestChain<List<Filter>> {

    private static final String PATH = "/filters";
    private static final TypeReference<List<Filter>> TYPE_REFERENCE = new TypeReference<List<Filter>>() {
    };

    public GetFilters(RequestContext context) {
        super(context, PATH, TYPE_REFERENCE);
    }
}
