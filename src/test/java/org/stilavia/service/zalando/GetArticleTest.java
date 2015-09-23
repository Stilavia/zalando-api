package org.stilavia.service.zalando;

import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.stilavia.service.zalando.model.Article;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * Created by guillermoblascojimenez on 24/09/15.
 */

public class GetArticleTest {

    private ZalandoApi zalandoApi;
    private MockRestServiceServer mockRestServiceServer;


    @org.junit.Before
    public void setUp() throws Exception {
        zalandoApi = new ZalandoApiBuilder().build();
        mockRestServiceServer = MockRestServiceServer.createServer(zalandoApi.getContext().getRestTemplate());
    }

    @Test
    public void singleArticle() throws IOException, URISyntaxException {
        mockRestServiceServer.expect(requestTo("https://api.zalando.com/articles/" + productId))
        .andExpect(method(HttpMethod.GET))
                .andExpect(header("Accept-Language", zalandoApi.getDomain().getLocale()))
                .andRespond(withSuccess(productInfo, MediaType.APPLICATION_JSON));

        Article article = zalandoApi.articles(productId).get();

        mockRestServiceServer.verify();

        assertEquals(productId, article.getId());
        assertEquals("ES929E00H", article.getModelId());
        assertEquals("skirt - white", article.getName());
        assertEquals("https://www.zalando.co.uk/fancy.html", article.getShopUrl());
        assertEquals("White", article.getColor());
        assertEquals(true, article.isAvailable());
        assertEquals("SUMMER", article.getSeason());
        assertEquals("2015", article.getSeasonYear());
        assertEquals(Collections.emptyList(), article.getAdditionalInfos());
            assertNotNull(article.getGenders());
        assertEquals(1, article.getGenders().size());
        assertTrue(article.getGenders().contains("FEMALE"));
            assertNotNull(article.getAgeGroups());
        assertEquals(1, article.getAgeGroups().size());
        assertTrue(article.getAgeGroups().contains("ADULT"));

            assertNotNull(article.getBrand());
            assertEquals("E", article.getBrand().getKey());
            assertEquals("E Maternity", article.getBrand().getName());
            assertEquals("https://i5.ztat.net/brand/e-collection-2.jpg", article.getBrand().getLogoUrl());
            assertEquals("https://i5.ztat.net/brandxl/e-collection-2.jpg", article.getBrand().getLogoLargeUrl());
            assertEquals("E", article.getBrand().getBrandFamily().getKey());
            assertEquals("e", article.getBrand().getBrandFamily().getName());
            assertEquals("https://www.zalando.co.uk/e-online-shop", article.getBrand().getBrandFamily().getShopUrl());



            assertEquals(38.5, article.getUnits().get(0).getPrice().getValue(), 0.00001);

    }


    private static final String productId = "ES929E00H-A11";
    private static final String productInfo = "\n" +
            "{\n" +
            "  \"id\" : \"ES929E00H-A11\",\n" +
            "  \"modelId\" : \"ES929E00H\",\n" +
            "  \"name\" : \"skirt - white\",\n" +
            "  \"shopUrl\" : \"https://www.zalando.co.uk/fancy.html\",\n" +
            "  \"color\" : \"White\",\n" +
            "  \"available\" : true,\n" +
            "  \"season\" : \"SUMMER\",\n" +
            "  \"seasonYear\" : \"2015\",\n" +
            "  \"activationDate\" : \"2015-03-30T14:25:33+02:00\",\n" +
            "  \"additionalInfos\" : [ ],\n" +
            "  \"genders\" : [ \"FEMALE\" ],\n" +
            "  \"ageGroups\" : [ \"ADULT\" ],\n" +
            "  \"brand\" : {\n" +
            "    \"key\" : \"E\",\n" +
            "    \"name\" : \"E Maternity\",\n" +
            "    \"logoUrl\" : \"https://i5.ztat.net/brand/e-collection-2.jpg\",\n" +
            "    \"logoLargeUrl\" : \"https://i5.ztat.net/brandxl/e-collection-2.jpg\",\n" +
            "    \"brandFamily\" : {\n" +
            "      \"key\" : \"E\",\n" +
            "      \"name\" : \"e\",\n" +
            "      \"shopUrl\" : \"https://www.zalando.co.uk/e-online-shop\"\n" +
            "    },\n" +
            "    \"shopUrl\" : \"https://www.zalando.co.uk/e-maternity\"\n" +
            "  },\n" +
            "  \"categoryKeys\" : [ \"catalog\", \"women\", \"womens-sale\", \"womens-clothing-sale\", \"womens-skirts-sale\", \"all\", \"sale\", \"womens-clothing-denim-skirts-sale\" ],\n" +
            "  \"attributes\" : [ {\n" +
            "    \"name\" : \"Total length\",\n" +
            "    \"values\" : [ \"24.5 \\\" (Size 36)\" ]\n" +
            "  }, {\n" +
            "    \"name\" : \"Details\",\n" +
            "    \"values\" : [ \"deep pockets\", \"Elasticated waist\" ]\n" +
            "  }, {\n" +
            "    \"name\" : \"Fit\",\n" +
            "    \"values\" : [ \"High-waisted\" ]\n" +
            "  }, {\n" +
            "    \"name\" : \"Washing Instructions\",\n" +
            "    \"values\" : [ \"Machine wash at 40°C\", \"Do not tumble dry\" ]\n" +
            "  }, {\n" +
            "    \"name\" : \"outer fabric material\",\n" +
            "    \"values\" : [ \"97% cotton, 3% spandex\" ]\n" +
            "  }, {\n" +
            "    \"name\" : \"Our model's height\",\n" +
            "    \"values\" : [ \"Our model is 70.0 \\\" tall and is wearing size 36\" ]\n" +
            "  } ],\n" +
            "  \"units\" : [ {\n" +
            "    \"id\" : \"ES929E00H-A11038R000\",\n" +
            "    \"size\" : \"12\",\n" +
            "    \"price\" : {\n" +
            "      \"currency\" : \"GBP\",\n" +
            "      \"value\" : 38.50,\n" +
            "      \"formatted\" : \"£38.50\"\n" +
            "    },\n" +
            "    \"originalPrice\" : {\n" +
            "      \"currency\" : \"GBP\",\n" +
            "      \"value\" : 55.00,\n" +
            "      \"formatted\" : \"£55.00\"\n" +
            "    },\n" +
            "    \"available\" : true,\n" +
            "    \"stock\" : 3\n" +
            "  }, {\n" +
            "    \"id\" : \"ES929E00H-A11036R000\",\n" +
            "    \"size\" : \"10\",\n" +
            "    \"price\" : {\n" +
            "      \"currency\" : \"GBP\",\n" +
            "      \"value\" : 38.50,\n" +
            "      \"formatted\" : \"£38.50\"\n" +
            "    },\n" +
            "    \"originalPrice\" : {\n" +
            "      \"currency\" : \"GBP\",\n" +
            "      \"value\" : 55.00,\n" +
            "      \"formatted\" : \"£55.00\"\n" +
            "    },\n" +
            "    \"available\" : true,\n" +
            "    \"stock\" : 1\n" +
            "  }, {\n" +
            "    \"id\" : \"ES929E00H-A11034R000\",\n" +
            "    \"size\" : \"8\",\n" +
            "    \"price\" : {\n" +
            "      \"currency\" : \"GBP\",\n" +
            "      \"value\" : 38.50,\n" +
            "      \"formatted\" : \"£38.50\"\n" +
            "    },\n" +
            "    \"originalPrice\" : {\n" +
            "      \"currency\" : \"GBP\",\n" +
            "      \"value\" : 55.00,\n" +
            "      \"formatted\" : \"£55.00\"\n" +
            "    },\n" +
            "    \"available\" : true,\n" +
            "    \"stock\" : 3\n" +
            "  }, {\n" +
            "    \"id\" : \"ES929E00H-A11042R000\",\n" +
            "    \"size\" : \"16\",\n" +
            "    \"price\" : {\n" +
            "      \"currency\" : \"GBP\",\n" +
            "      \"value\" : 38.50,\n" +
            "      \"formatted\" : \"£38.50\"\n" +
            "    },\n" +
            "    \"originalPrice\" : {\n" +
            "      \"currency\" : \"GBP\",\n" +
            "      \"value\" : 55.00,\n" +
            "      \"formatted\" : \"£55.00\"\n" +
            "    },\n" +
            "    \"available\" : false,\n" +
            "    \"stock\" : 0\n" +
            "  }, {\n" +
            "    \"id\" : \"ES929E00H-A11044R000\",\n" +
            "    \"size\" : \"18\",\n" +
            "    \"price\" : {\n" +
            "      \"currency\" : \"GBP\",\n" +
            "      \"value\" : 38.50,\n" +
            "      \"formatted\" : \"£38.50\"\n" +
            "    },\n" +
            "    \"originalPrice\" : {\n" +
            "      \"currency\" : \"GBP\",\n" +
            "      \"value\" : 55.00,\n" +
            "      \"formatted\" : \"£55.00\"\n" +
            "    },\n" +
            "    \"available\" : false,\n" +
            "    \"stock\" : 0\n" +
            "  }, {\n" +
            "    \"id\" : \"ES929E00H-A11040R000\",\n" +
            "    \"size\" : \"14\",\n" +
            "    \"price\" : {\n" +
            "      \"currency\" : \"GBP\",\n" +
            "      \"value\" : 38.50,\n" +
            "      \"formatted\" : \"£38.50\"\n" +
            "    },\n" +
            "    \"originalPrice\" : {\n" +
            "      \"currency\" : \"GBP\",\n" +
            "      \"value\" : 55.00,\n" +
            "      \"formatted\" : \"£55.00\"\n" +
            "    },\n" +
            "    \"available\" : true,\n" +
            "    \"stock\" : 2\n" +
            "  } ],\n" +
            "  \"media\" : {\n" +
            "    \"images\" : [ {\n" +
            "      \"orderNumber\" : 1,\n" +
            "      \"type\" : \"NON_MODEL\",\n" +
            "      \"thumbnailHdUrl\" : \"https://i1.ztat.net/thumb_hd/ES/92/9E/00/HA/11/ES929E00H-A11@9.jpg\",\n" +
            "      \"smallUrl\" : \"https://i1.ztat.net/catalog/ES/92/9E/00/HA/11/ES929E00H-A11@9.jpg\",\n" +
            "      \"smallHdUrl\" : \"https://i1.ztat.net/catalog_hd/ES/92/9E/00/HA/11/ES929E00H-A11@9.jpg\",\n" +
            "      \"mediumUrl\" : \"https://i1.ztat.net/detail/ES/92/9E/00/HA/11/ES929E00H-A11@9.jpg\",\n" +
            "      \"mediumHdUrl\" : \"https://i1.ztat.net/detail_hd/ES/92/9E/00/HA/11/ES929E00H-A11@9.jpg\",\n" +
            "      \"largeUrl\" : \"https://i1.ztat.net/large/ES/92/9E/00/HA/11/ES929E00H-A11@9.jpg\",\n" +
            "      \"largeHdUrl\" : \"https://i1.ztat.net/large_hd/ES/92/9E/00/HA/11/ES929E00H-A11@9.jpg\"\n" +
            "    }, {\n" +
            "      \"orderNumber\" : 2,\n" +
            "      \"type\" : \"MODEL\",\n" +
            "      \"thumbnailHdUrl\" : \"https://i2.ztat.net/thumb_hd/ES/92/9E/00/HA/11/ES929E00H-A11@13.jpg\",\n" +
            "      \"smallUrl\" : \"https://i2.ztat.net/catalog/ES/92/9E/00/HA/11/ES929E00H-A11@13.jpg\",\n" +
            "      \"smallHdUrl\" : \"https://i2.ztat.net/catalog_hd/ES/92/9E/00/HA/11/ES929E00H-A11@13.jpg\",\n" +
            "      \"mediumUrl\" : \"https://i2.ztat.net/detail/ES/92/9E/00/HA/11/ES929E00H-A11@13.jpg\",\n" +
            "      \"mediumHdUrl\" : \"https://i2.ztat.net/detail_hd/ES/92/9E/00/HA/11/ES929E00H-A11@13.jpg\",\n" +
            "      \"largeUrl\" : \"https://i2.ztat.net/large/ES/92/9E/00/HA/11/ES929E00H-A11@13.jpg\",\n" +
            "      \"largeHdUrl\" : \"https://i2.ztat.net/large_hd/ES/92/9E/00/HA/11/ES929E00H-A11@13.jpg\"\n" +
            "    }, {\n" +
            "      \"orderNumber\" : 3,\n" +
            "      \"type\" : \"MODEL\",\n" +
            "      \"thumbnailHdUrl\" : \"https://i3.ztat.net/thumb_hd/ES/92/9E/00/HA/11/ES929E00H-A11@10.jpg\",\n" +
            "      \"smallUrl\" : \"https://i3.ztat.net/catalog/ES/92/9E/00/HA/11/ES929E00H-A11@10.jpg\",\n" +
            "      \"smallHdUrl\" : \"https://i3.ztat.net/catalog_hd/ES/92/9E/00/HA/11/ES929E00H-A11@10.jpg\",\n" +
            "      \"mediumUrl\" : \"https://i3.ztat.net/detail/ES/92/9E/00/HA/11/ES929E00H-A11@10.jpg\",\n" +
            "      \"mediumHdUrl\" : \"https://i3.ztat.net/detail_hd/ES/92/9E/00/HA/11/ES929E00H-A11@10.jpg\",\n" +
            "      \"largeUrl\" : \"https://i3.ztat.net/large/ES/92/9E/00/HA/11/ES929E00H-A11@10.jpg\",\n" +
            "      \"largeHdUrl\" : \"https://i3.ztat.net/large_hd/ES/92/9E/00/HA/11/ES929E00H-A11@10.jpg\"\n" +
            "    }, {\n" +
            "      \"orderNumber\" : 4,\n" +
            "      \"type\" : \"MODEL\",\n" +
            "      \"thumbnailHdUrl\" : \"https://i4.ztat.net/thumb_hd/ES/92/9E/00/HA/11/ES929E00H-A11@11.jpg\",\n" +
            "      \"smallUrl\" : \"https://i4.ztat.net/catalog/ES/92/9E/00/HA/11/ES929E00H-A11@11.jpg\",\n" +
            "      \"smallHdUrl\" : \"https://i4.ztat.net/catalog_hd/ES/92/9E/00/HA/11/ES929E00H-A11@11.jpg\",\n" +
            "      \"mediumUrl\" : \"https://i4.ztat.net/detail/ES/92/9E/00/HA/11/ES929E00H-A11@11.jpg\",\n" +
            "      \"mediumHdUrl\" : \"https://i4.ztat.net/detail_hd/ES/92/9E/00/HA/11/ES929E00H-A11@11.jpg\",\n" +
            "      \"largeUrl\" : \"https://i4.ztat.net/large/ES/92/9E/00/HA/11/ES929E00H-A11@11.jpg\",\n" +
            "      \"largeHdUrl\" : \"https://i4.ztat.net/large_hd/ES/92/9E/00/HA/11/ES929E00H-A11@11.jpg\"\n" +
            "    }, {\n" +
            "      \"orderNumber\" : 5,\n" +
            "      \"type\" : \"MODEL\",\n" +
            "      \"thumbnailHdUrl\" : \"https://i1.ztat.net/thumb_hd/ES/92/9E/00/HA/11/ES929E00H-A11@12.jpg\",\n" +
            "      \"smallUrl\" : \"https://i1.ztat.net/catalog/ES/92/9E/00/HA/11/ES929E00H-A11@12.jpg\",\n" +
            "      \"smallHdUrl\" : \"https://i1.ztat.net/catalog_hd/ES/92/9E/00/HA/11/ES929E00H-A11@12.jpg\",\n" +
            "      \"mediumUrl\" : \"https://i1.ztat.net/detail/ES/92/9E/00/HA/11/ES929E00H-A11@12.jpg\",\n" +
            "      \"mediumHdUrl\" : \"https://i1.ztat.net/detail_hd/ES/92/9E/00/HA/11/ES929E00H-A11@12.jpg\",\n" +
            "      \"largeUrl\" : \"https://i1.ztat.net/large/ES/92/9E/00/HA/11/ES929E00H-A11@12.jpg\",\n" +
            "      \"largeHdUrl\" : \"https://i1.ztat.net/large_hd/ES/92/9E/00/HA/11/ES929E00H-A11@12.jpg\"\n" +
            "    }, {\n" +
            "      \"orderNumber\" : 6,\n" +
            "      \"type\" : \"NON_MODEL\",\n" +
            "      \"thumbnailHdUrl\" : \"https://i5.ztat.net/thumb_hd/ES/92/9E/00/HA/11/ES929E00H-A11@7.jpg\",\n" +
            "      \"smallUrl\" : \"https://i5.ztat.net/catalog/ES/92/9E/00/HA/11/ES929E00H-A11@7.jpg\",\n" +
            "      \"smallHdUrl\" : \"https://i5.ztat.net/catalog_hd/ES/92/9E/00/HA/11/ES929E00H-A11@7.jpg\",\n" +
            "      \"mediumUrl\" : \"https://i5.ztat.net/detail/ES/92/9E/00/HA/11/ES929E00H-A11@7.jpg\",\n" +
            "      \"mediumHdUrl\" : \"https://i5.ztat.net/detail_hd/ES/92/9E/00/HA/11/ES929E00H-A11@7.jpg\",\n" +
            "      \"largeUrl\" : \"https://i5.ztat.net/large/ES/92/9E/00/HA/11/ES929E00H-A11@7.jpg\",\n" +
            "      \"largeHdUrl\" : \"https://i5.ztat.net/large_hd/ES/92/9E/00/HA/11/ES929E00H-A11@7.jpg\"\n" +
            "    }, {\n" +
            "      \"orderNumber\" : 7,\n" +
            "      \"type\" : \"NON_MODEL\",\n" +
            "      \"thumbnailHdUrl\" : \"https://i4.ztat.net/thumb_hd/ES/92/9E/00/HA/11/ES929E00H-A11@8.jpg\",\n" +
            "      \"smallUrl\" : \"https://i4.ztat.net/catalog/ES/92/9E/00/HA/11/ES929E00H-A11@8.jpg\",\n" +
            "      \"smallHdUrl\" : \"https://i4.ztat.net/catalog_hd/ES/92/9E/00/HA/11/ES929E00H-A11@8.jpg\",\n" +
            "      \"mediumUrl\" : \"https://i4.ztat.net/detail/ES/92/9E/00/HA/11/ES929E00H-A11@8.jpg\",\n" +
            "      \"mediumHdUrl\" : \"https://i4.ztat.net/detail_hd/ES/92/9E/00/HA/11/ES929E00H-A11@8.jpg\",\n" +
            "      \"largeUrl\" : \"https://i4.ztat.net/large/ES/92/9E/00/HA/11/ES929E00H-A11@8.jpg\",\n" +
            "      \"largeHdUrl\" : \"https://i4.ztat.net/large_hd/ES/92/9E/00/HA/11/ES929E00H-A11@8.jpg\"\n" +
            "    } ]\n" +
            "  }\n" +
            "}";
}