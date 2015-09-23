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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

/**
 * Created by guillermoblascojimenez on 15/06/15.
 */
public class RequestContext {

    private final String host;
    private final String locale;
    private final Optional<String> clientId;
    private final RestTemplate restTemplate;

    public RequestContext(String host, String locale, Optional<String> clientId, RestTemplate restTemplate) {
        Preconditions.checkNotNull(host);
        Preconditions.checkArgument(!host.isEmpty());
        Preconditions.checkNotNull(locale);
        Preconditions.checkNotNull(clientId);
        Preconditions.checkNotNull(restTemplate);
        this.host = host;
        this.locale = locale;
        this.clientId = clientId;
        this.restTemplate = restTemplate;
    }

    public RequestContext(String host, String locale, Optional<String> clientId) {
        this(host, locale, clientId, buildRestTemplate());
    }

    public RequestContext(String host, String locale, String clientId) {
        this(host, locale, Optional.of(clientId));
    }

    public RequestContext(String host, String locale) {
        this(host, locale, Optional.<String>absent(), buildRestTemplate());
    }

    public RestUriBuilder getUriBuilder() {
        return new RestUriBuilder()
                .protocol("https")
                .host(host);
    }



    public <E> E execute(RestUriBuilder uriBuilder, ParameterizedTypeReference<E> entityClass) throws IOException, URISyntaxException {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("Accept-Language", locale);
        headers.set("Accept-Encoding", "gzip,deflate");
        if (this.clientId.isPresent()) {
            headers.set("x-client-name", this.clientId.get());
        }
        HttpEntity<E> httpEntity = new HttpEntity<E>(headers);
        ResponseEntity<E> response = restTemplate.exchange(uriBuilder.build(), HttpMethod.GET, httpEntity, entityClass);

        return response.getBody();
    }

    RestTemplate getRestTemplate() {
        return restTemplate;
    }

    private static RestTemplate buildRestTemplate() {
        HttpClient httpClient = HttpClientBuilder.create().build();
        ClientHttpRequestFactory requestFactory= new HttpComponentsClientHttpRequestFactory(httpClient);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        restTemplate.setMessageConverters(Arrays.<HttpMessageConverter<?>>asList(new MappingJackson2HttpMessageConverter(new ObjectMapper())));
        return restTemplate;
    }
}
