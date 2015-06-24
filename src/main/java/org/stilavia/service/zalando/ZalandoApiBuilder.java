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

import com.google.common.base.Preconditions;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * Created by guillermoblascojimenez on 15/06/15.
 */
public class ZalandoApiBuilder {

    private ZalandoApi.Domain domain = ZalandoApi.Domain.en_GB;
    private String schema = "http";
    private String clientId = null;

    public ZalandoApiBuilder setDomain(ZalandoApi.Domain domain) {
        Preconditions.checkNotNull(domain);
        this.domain = domain;
        return this;
    }

    public ZalandoApiBuilder enableHttps() {
        this.schema = "https";
        return this;
    }

    public ZalandoApiBuilder setClientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    public ZalandoApi build() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        ObjectMapper objectMapper = new ObjectMapper();
        RequestContext context = new RequestContext(schema, "api.zalando.com", httpClient, objectMapper, domain, clientId);
        return new ZalandoApi(context);
    }
}
