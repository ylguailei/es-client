package com.kieki.elasticsearch.client.congiguration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.convert.ElasticsearchConverter;
import org.springframework.data.elasticsearch.core.geo.CustomGeoModule;

import java.io.IOException;

@Configuration
public class ElasticSearchConfiguration {

//    @Bean
//    public ElasticsearchRestTemplate elasticsearchTemplate(RestHighLevelClient client, ElasticsearchConverter converter) {
//        return new ElasticsearchRestTemplate(client, converter);
//    }

//    public static class CustomEntityMapper implements ResultsMapper {
//
//        private final ObjectMapper objectMapper;
//
//        public CustomEntityMapper() {
//            objectMapper = new ObjectMapper();
//            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//            objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
//            objectMapper.registerModule(new CustomGeoModule());
//            //如上是默认的Elasticsearch使用的ObjectMapper配置，下面一句添加对日期的处理，特别是java8后的日期处理。
//            objectMapper.registerModule(new JavaTimeModule());
//        }
//
//        @Override
//        public String mapToString(Object object) throws IOException {
//            return objectMapper.writeValueAsString(object);
//        }
//
//        @Override
//        public <T> T mapToObject(String source, Class<T> clazz) throws IOException {
//            return objectMapper.readValue(source, clazz);
//        }
//    }
}
