package com.kieki.elasticsearch.client.repository;

import com.kieki.elasticsearch.client.response.BizResult;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象仓库，后续各自扩展可继承
 * Created by kieki on 2016/11/14.
 * @param <T>
 */
public abstract class AbstractRepository<T extends Object> implements ElasticsearchRepository<T, String> {

    public BizResult query(SearchQuery query) {
        BizResult result = new BizResult();
        List<T> bizList = new ArrayList<>();

        Page<T> pageOrders = search(query);
        if (pageOrders.getTotalElements() > 0) {
            for (T order : pageOrders.getContent()) {
                bizList.add(order);
            }
        }
        result.setTotal(pageOrders.getTotalElements());
        result.setResultObject(bizList);
        return result;
    }
}
