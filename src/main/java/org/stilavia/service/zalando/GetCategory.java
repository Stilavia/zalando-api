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
import org.stilavia.service.zalando.model.Category;

/**
 * Created by guillermoblascojimenez on 16/06/15.
 */
public class GetCategory extends ExecutableRequestChain<Category> {

    private static final String PATH = "/categories/%s";
    private static final ParameterizedTypeReference<Category> TYPE_REFERENCE = new ParameterizedTypeReference<Category>() {
    };

    public GetCategory(RequestContext context, String key) {
        super(context, getPath(key), TYPE_REFERENCE);
    }

    private static String getPath(String key) {
        return String.format(PATH, key);
    }
}
