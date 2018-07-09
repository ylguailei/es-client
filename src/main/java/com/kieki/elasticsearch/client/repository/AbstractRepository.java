package com.kieki.elasticsearch.client.repository;

import com.kieki.elasticsearch.client.response.BizResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象仓库，后续各自扩展可继承
 * Created by kieki on 2016/11/14.
 *
 * @param <T>
 */
@Component
public class AbstractRepository implements RespositoryService {
    @Autowired
    ESRepository repository;

    @Override
    public BizResult query(SearchQuery query) {
        BizResult result = new BizResult();
        List<String> bizList = new ArrayList<>();

        Page<String> pageOrders = repository.search(query);
        if (pageOrders.getTotalElements() > 0) {
            for (String order : pageOrders.getContent()) {
                bizList.add(order);
            }
        }
        result.setTotal(pageOrders.getTotalElements());
        result.setResultObject(bizList);
        return result;
    }
}
