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

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.Closeable;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by guillermoblascojimenez on 15/06/15.
 */
public class RequestContext implements Closeable {

    private final String schema;
    private final String host;
    private final ObjectMapper objectMapper;
    private final CloseableHttpClient httpclient;
    private final ZalandoApi.Domain domain;
    private final String clientId;

    public RequestContext(String schema, String host, CloseableHttpClient httpclient, ObjectMapper objectMapper, ZalandoApi.Domain domain, String clientId) {
        this.schema = schema;
        this.host = host;
        this.objectMapper = objectMapper;
        this.httpclient = httpclient;
        this.domain = domain;
        this.clientId = clientId;
    }

    public URIBuilder getUriBuilder() {
        return new URIBuilder()
                .setScheme(schema)
                .setHost(host);
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public RequestResponse execute(URIBuilder uriBuilder) throws IOException, URISyntaxException {
        URI uri = uriBuilder.build();
        HttpGet httpGet = new HttpGet(uri);
        httpGet.addHeader(new BasicHeader("Accept-Language", domain.getLocale()));
        if (this.clientId != null) {
            httpGet.addHeader(new BasicHeader("x-client-name", this.clientId));
        }
        CloseableHttpResponse response = httpclient.execute(httpGet);
        RequestResponse requestResponse;
        try {
            HttpEntity entity = response.getEntity();
            int code = response.getStatusLine().getStatusCode();
            if (code >= 400) {
                requestResponse = new RequestResponse(code, null);
            } else {
                requestResponse = new RequestResponse(code, EntityUtils.toString(entity));
            }
        } finally {
            response.close();
        }
        return requestResponse;
    }

    public void close() throws IOException {
        this.httpclient.close();
    }
}
