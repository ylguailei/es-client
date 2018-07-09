package com.kieki.elasticsearch.client.repository;

import com.kieki.elasticsearch.client.response.BizResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
public class RespositoryServiceImpl implements RespositoryService {

    @Autowired
    ESRepository repository;

    @Override
    public BizResult query(SearchQuery query) {
        BizResult result = new BizResult();
        List<Member> bizList = new ArrayList<>();

        Page<Member> pageOrders = repository.search(query);
        if (pageOrders.getTotalElements() > 0) {
            for (Member order : pageOrders.getContent()) {
                bizList.add(order);
            }
        }
        result.setTotal(pageOrders.getTotalElements());
        result.setResultObject(bizList);
        return result;
    }
}
