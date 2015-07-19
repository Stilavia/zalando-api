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
import org.stilavia.service.zalando.model.Brand;

/**
 * Created by guillermoblascojimenez on 16/06/15.
 */
public class GetBrand extends ExecutableRequestChain<Brand> {

    private static final String PATH = "/brands/%s";
    private static final ParameterizedTypeReference<Brand> TYPE_REFERENCE = new ParameterizedTypeReference<Brand>() {
    };

    private final String brandKey;

    public GetBrand(RequestContext context, String brandKey) {
        super(context, getPath(brandKey), TYPE_REFERENCE);
        this.brandKey = brandKey;
    }

    private static String getPath(String brandKey) {
        return String.format(PATH, brandKey);
    }

}
