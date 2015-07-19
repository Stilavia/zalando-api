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

import org.springframework.core.ParameterizedTypeReference;
import org.stilavia.service.zalando.model.Unit;

import java.util.List;

/**
 * Created by guillermoblascojimenez on 04/07/15.
 */
public class GetArticleUnits extends ExecutableRequestChain<List<Unit>> {

    private static final String PATH = "/units";
    private static final ParameterizedTypeReference<List<Unit>> TYPE_REFERENCE = new ParameterizedTypeReference<List<Unit>>() { };

    public GetArticleUnits(RequestChain parent) {
        super(parent, PATH, TYPE_REFERENCE);
    }
}
