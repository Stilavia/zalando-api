# Java Client of Zalando's API

## Compilation

```shell
mvn compile
```

## Usage

First you have to install the maven artifact locally

```shell
mvn install
```

Then add the artifact to your dependencies:

```xml
<dependencies>
    ...
    <dependency>
        <groupId>org.stilavia</groupId>
        <artifactId>zalando-api</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>
    ...
</dependencies>
```

And then the usage is as follows:

```java
public static void main(String[] args) throws IOException, URISyntaxException {
    ZalandoApi zalandoApi = new ZalandoApiBuilder().setDomain(Domain.es_ES).build();
    PaginableResult<Category> categories = zalandoApi.categories().pageSize(20).get();
    System.out.println(categories);
}
```

To use this client ina Spring application consider the following setup:

```java
@Configuration
public class ZalandoApiConfiguration {

    @Bean
    public ZalandoApi zalandoApi(@Value("${zalando-api.domain:es_ES}") Domain domain) {
        return new ZalandoApiBuilder()
                    .setDomain(domain)
                    .build();
    }
    
}
```

## Dependencies

This API depends on three other popular modules:

* `org.apache.httpcomponents` artifact `httpclient` version `4.5`

* `com.google.guava` artifact `guava` version `18`

* `org.codehaus.jackson` artifact `jackson-mapper-asl` version `1.9.13`

Since all these artifacts are pretty popular take with care the possible artifact's version conflicts. If you are going
 to use this software under an Android device consider the [httpclient issues](https://hc.apache.org/httpcomponents-client-4.3.x/android-port.html).