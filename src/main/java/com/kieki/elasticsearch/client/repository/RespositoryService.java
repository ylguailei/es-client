package com.kieki.elasticsearch.client.repository;

import com.kieki.elasticsearch.client.response.BizResult;
import org.springframework.data.elasticsearch.core.query.SearchQuery;

import java.io.Serializable;

public interface RespositoryService {
    BizResult query(SearchQuery query);
}
