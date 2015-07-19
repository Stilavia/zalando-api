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

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by guillermoblascojimenez on 19/07/15.
 */
public class RestUriBuilder {

    private String host;
    private String protocol = "http";
    private StringBuilder path;
    private Map<String, String> parameters = new HashMap<String, String>();

    public RestUriBuilder host(String host) {
        Preconditions.checkNotNull(host);
        this.host = host;
        return this;
    }

    public RestUriBuilder protocol(String protocol) {
        Preconditions.checkNotNull(protocol);
        this.protocol = protocol;
        return this;
    }

    public RestUriBuilder path(String path) {
        Preconditions.checkNotNull(path);
        this.path = new StringBuilder();
        this.path.append(path);
        return this;
    }

    public RestUriBuilder appendPath(String path) {
        Preconditions.checkNotNull(path);
        this.path.append(path);
        return this;
    }

    public RestUriBuilder addParameter(String key, Object value) {
        Preconditions.checkNotNull(key);
        Preconditions.checkNotNull(value);
        this.parameters.put(key, String.valueOf(value));
        return this;
    }

    public String build() {
        StringBuilder builder = new StringBuilder();
        builder.append(protocol);
        builder.append("://");
        Preconditions.checkNotNull(host);
        Preconditions.checkNotNull(path);
        builder.append(host);
        builder.append(path);
        if (!parameters.isEmpty()) {
            builder.append("?");
            Joiner.on("&").appendTo(builder, Iterables.transform(parameters.entrySet(), new Function<Map.Entry<String,String>, Object>() {
                public Object apply(Map.Entry<String, String> stringStringEntry) {
                    return stringStringEntry.getKey() + "=" + stringStringEntry.getValue();
                }
            }));
        }
        return builder.toString();
    }
}
