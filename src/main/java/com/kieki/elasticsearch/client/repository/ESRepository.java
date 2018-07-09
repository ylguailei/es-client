package com.kieki.elasticsearch.client.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ESRepository extends ElasticsearchRepository<String,String> {
}
