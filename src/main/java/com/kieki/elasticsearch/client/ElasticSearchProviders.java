package com.kieki.elasticsearch.client;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

/**
 * ES查询的提供者
 * Created by kieki on 2016/11/14.
 */
public class ElasticSearchProviders {

    /**
     * 编译查询方法
     *
     * @param criteria
     * @return
     */
    public static NativeSearchQuery buildSearchQuery(QueryCriteria criteria) {
        Integer startIndex = criteria.getPageNum();
        Integer maxRecordReturn = criteria.getPageSize();
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();

        if (criteria.getSelectColumns().size() > 0) {
            String[] fields = new String[criteria.getSelectColumns().size()];
            for (int i = 0; i < criteria.getSelectColumns().size(); i++) {
                fields[i] = criteria.getSelectColumns().get(i).getColumnName();
            }
            nativeSearchQueryBuilder.withFields(fields);
        }
        if (criteria.getOrderColumns().size() > 0) {
            for (int i = 0; i < criteria.getOrderColumns().size(); i++) {
                OrderColumn bean = criteria.getOrderColumns().get(i);
                SortBuilder sortBuilder = SortBuilders.fieldSort(bean.getColumnName())
                        .order(bean.getSorting() == DataSorting.Ascending ? SortOrder.ASC : SortOrder.DESC);
                nativeSearchQueryBuilder.withSort(sortBuilder);
            }
        }
        if (criteria.getFilters().size() > 0) {
            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
            for (FilterColumn column : criteria.getFilters()) {
                //Filtercolumns.add(column);
                QueryBuilder queryBuilder = appendFilter(column);//QueryBuilders.termQuery(column.getColumnName(), column.getValue());
                if (queryBuilder == null)
                    throw new IllegalArgumentException("筛选条件参数异常");
                boolQueryBuilder.must(queryBuilder);
            }
            nativeSearchQueryBuilder.withFilter(boolQueryBuilder);
        }
        if (startIndex != null && maxRecordReturn != null)
            return nativeSearchQueryBuilder.withPageable(new PageRequest(startIndex - 1, maxRecordReturn)).build();
        else
            return nativeSearchQueryBuilder.build();
    }

    /**
     * 添加查询筛选
     *
     * @param column
     * @return
     */
    private static QueryBuilder appendFilter(FilterColumn column) {
        switch (column.getComparison()) {
            case Equals: {
                return QueryBuilders.termQuery(column.getColumnName(), column.getValue());
            }
            case NotEquals: {
                return QueryBuilders.boolQuery().mustNot(QueryBuilders.termQuery(column.getColumnName(), column.getValue()));
            }
            case Between: {
                Object[] objArrys = (Object[]) column.getValue();
                return QueryBuilders.rangeQuery(column.getColumnName()).gte(objArrys[0]).lte(objArrys[1]);
            }
            case NotBetween: {
                Object[] objArrys = (Object[]) column.getValue();
                return QueryBuilders.boolQuery().mustNot(QueryBuilders.rangeQuery(column.getColumnName()).gte(objArrys[0]).lte(objArrys[1]));
            }
            case Like: {
                return QueryBuilders.fuzzyQuery(column.getColumnName(), String.valueOf(column.getValue()));
            }
            case NotLike: {
                return QueryBuilders.boolQuery().mustNot(QueryBuilders.fuzzyQuery(column.getColumnName(), String.valueOf(column.getValue())));
            }
            case In: {
                Object[] objArrys = (Object[]) column.getValue();
                return QueryBuilders.termsQuery(column.getColumnName(), objArrys);
            }
            case NotIn: {
                Object[] objArrys = (Object[]) column.getValue();
                return QueryBuilders.boolQuery().mustNot(QueryBuilders.termsQuery(column.getColumnName(), objArrys));
            }
            case GreaterThan: {
                return QueryBuilders.rangeQuery(column.getColumnName()).gt(column.getValue());
            }
            case GreaterOrEquals: {
                return QueryBuilders.rangeQuery(column.getColumnName()).gte(column.getValue());
            }
            case LessThan: {
                return QueryBuilders.rangeQuery(column.getColumnName()).lt(column.getValue());
            }
            case LessOrEquals: {
                return QueryBuilders.rangeQuery(column.getColumnName()).lte(column.getValue());
            }
        }
        return null;
    }
}
