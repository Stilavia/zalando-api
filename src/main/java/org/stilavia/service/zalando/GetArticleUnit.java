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

/**
 * Created by guillermoblascojimenez on 04/07/15.
 */
public class GetArticleUnit extends ExecutableRequestChain<Unit> {


    private static final String PATH = "/units/%s";
    private static final ParameterizedTypeReference<Unit> TYPE_REFERENCE = new ParameterizedTypeReference<Unit>() { };

    private final String unitId;

    public GetArticleUnit(RequestChain parent, String unitId) {
        super(parent, getPath(unitId), TYPE_REFERENCE);
        this.unitId = unitId;
    }

    private static String getPath(String articleId) {
        return String.format(PATH, articleId);
    }
}
