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
import com.google.common.base.Preconditions;
import org.springframework.web.client.RestTemplate;

/**
 * Created by guillermoblascojimenez on 15/06/15.
 */
public class ZalandoApiBuilder {

    private static final String ZALANDO_API_DNS = "api.zalando.com";

    private ZalandoApi.Domain domain = ZalandoApi.Domain.en_GB;
    private Optional<String> clientId = Optional.absent();
    private Optional<RestTemplate> restTemplate = Optional.absent();

    public ZalandoApiBuilder setDomain(ZalandoApi.Domain domain) {
        Preconditions.checkNotNull(domain);
        this.domain = domain;
        return this;
    }

    public ZalandoApiBuilder setClientId(String clientId) {
        this.clientId = Optional.of(clientId);
        return this;
    }

    public ZalandoApiBuilder setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = Optional.of(restTemplate);
        return this;
    }

    public ZalandoApi build() {
        RequestContext context;
        if (restTemplate.isPresent()) {
            context = new RequestContext(ZALANDO_API_DNS, domain.getLocale(), clientId, restTemplate.get());
        } else {
            context = new RequestContext(ZALANDO_API_DNS, domain.getLocale(), clientId);
        }
        return new ZalandoApi(context, domain);
    }
}
