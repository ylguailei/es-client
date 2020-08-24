package com.kieki.elasticsearch.client;

import com.kieki.elasticsearch.client.repository.Member;
import com.kieki.elasticsearch.client.response.BizResult;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticClientTest {

    /**
     * 该Repository继承自ElasticsearchRepository，由于运行时无法感知泛型类型，所以将整体Repository逻辑搬到上游业务上实现
     */
    @Autowired
    ElasticsearchRestTemplate repository;

    @Test
    public void query() {
        Member member = new Member();
        member.setMemberId(2);
        member.setMemberName("jack");
        repository.save(member);


        //step 1 实例化ES标准查询对象
        QueryCriteria criteria = new QueryCriteria();
        //step 2 确定排序规则
        List<OrderColumn> orderColumns = Lists.newArrayList();
        OrderColumn column = new OrderColumn();
        column.setColumnName("memberId");
        column.setSorting(DataSorting.Descending);
        orderColumns.add(column);

        //step 3 设置查询条件
        List<FilterColumn> filters = Lists.newArrayList();
//        if (StringUtils.isNotBlank("filterColumn")) {
//            FilterColumn filterColumn = new FilterColumn();
//            filterColumn.setColumnName("filterColumn");
//            filterColumn.setComparison(Comparison.Equals);
//            filterColumn.setValue("columnValue");
//            filters.add(filterColumn);
//        }

        //step 4 查询列及排序列添加至查询对象
        if (orderColumns != null && orderColumns.size() > 0) {
            criteria.setOrderColumns(orderColumns);
        }
        if (filters != null && filters.size() > 0) {
            criteria.setFilters(filters);
        }

        //step 5 设置查询翻页配置
        criteria.setPageNum(1);
        criteria.setPageSize(20);

        //step 6 实例化ES提供商
        ElasticSearchProviders elasticSearchProviders = new ElasticSearchProviders();

        //step 7 构建查询条件
        NativeSearchQuery searchQuery = elasticSearchProviders.buildSearchQuery(criteria);

        //step 8 通过封装过的query方法得到查询结果BizResult
        BizResult bizResult = query(searchQuery);
    }

    /**
     * 包装repository查询条件
     *
     * @param query
     * @return
     */
    private BizResult query(NativeSearchQuery query) {
        BizResult result = new BizResult();
        List<Member> bizList = Lists.newArrayList();

        SearchHits<Member> memberHits = repository.search(query, Member.class);
        if (memberHits.getTotalHits() > 0) {
            bizList = memberHits.stream().map(SearchHit::getContent).collect(Collectors.toList());
        }
        result.setTotal(memberHits.getTotalHits());
        result.setResultObject(bizList);
        return result;
    }
}
