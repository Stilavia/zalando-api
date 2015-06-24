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

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by guillermoblascojimenez on 15/06/15.
 */
public class ZalandoApi implements Closeable {

    private final RequestContext context;

    public enum Domain {
        da_DK("da_DK", "www.zalando.dk", "EU", "DKK", 25),
        de_AT("de-AT", "www.zalando.at", "EU", "EUR", 20),
        de_CH("de-CH", "www.zalando.ch", "EU", "CHF", 8),
        de_DE("de-DE", "www.zalando.de", "EU", "EUR", 19),
        en_GB("en-GB", "www.zalando.co.uk", "UK", "GBP", 20),
        es_ES("es-ES", "www.zalando.es", "FR", "EUR", 21),
        fi_FI("fi-FI", "www.zalando.fi", "EU", "EUR", 24),
        fr_BE("fr-BE", "fr.zalando.be", "EU", "EUR", 21),
        fr_CH("fr-CH", "fr.zalando.ch", "EU", "CHF", 8),
        fr_FR("fr-FR", "www.zalando.fr", "FR", "EUR", 20),
        it_IT("it-IT", "www.zalando.it", "IT", "EUR", 22),
        nl_BE("nl-BE", "www.zalando.be", "EU", "EUR", 21),
        nl_NL("nl-NL", "www.zalando.nl", "EU", "EUR", 21),
        no_NO("no-NO", "www.zalando.no", "EU", "NOK", 25),
        pl_PL("pl-PL", "www.zalando.pl", "EU", "EUR", 23),
        sv_SE("sv-SE", "www.zalando.se", "EU", "SEK", 25);

        private final String locale;
        private final String shopUrl;
        private final String sizeCode;
        private final String moneyCode;
        private final int vatPercentage;

        Domain(String locale, String shopUrl, String sizeCode, String moneyCode, int vatPercentage) {
            this.locale = locale;
            this.shopUrl = shopUrl;
            this.sizeCode = sizeCode;
            this.moneyCode = moneyCode;
            this.vatPercentage = vatPercentage;
        }

        public String getLocale() {
            return locale;
        }

        public String getShopUrl() {
            return shopUrl;
        }

        public String getSizeCode() {
            return sizeCode;
        }

        public String getMoneyCode() {
            return moneyCode;
        }

        public int getVatPercentage() {
            return vatPercentage;
        }
    }

    public ZalandoApi(RequestContext context) {
        this.context = context;
    }

    public GetArticle articles(String articleId) {
        return new GetArticle(context, articleId);
    }

    public GetBrands brands() {
        return new GetBrands(context);
    }

    public GetBrand brands(String brandKey) {
        return new GetBrand(context, brandKey);
    }

    public GetFilter filters(String filterName) {
        return new GetFilter(context, filterName);
    }

    public GetFilters filters() {
        return new GetFilters(context);
    }

    public GetCategory categories(String key) {
        return new GetCategory(context, key);
    }

    public GetCategories categories() {
        return new GetCategories(context);
    }

    public void close() throws IOException {
        context.close();
    }
}
