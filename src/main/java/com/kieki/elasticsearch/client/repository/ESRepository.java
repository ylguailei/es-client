package com.kieki.elasticsearch.client.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.io.Serializable;


public interface ESRepository extends ElasticsearchRepository<Member,Long> {
}
