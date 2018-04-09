package com.kieki.elasticsearch.client;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kieki on 2016/11/10.
 */
public class QueryCriteria {
    /// <summary>
    /// 查询列集合
    /// </summary>
    private List<IndexColumn> selectColumns;

    /// <summary>
    /// 排序列集合
    /// </summary>
    private List<OrderColumn> orderColumns;

    /// <summary>
    /// 过滤条件组
    /// </summary>
    private List<FilterColumn> filters;

    /// <summary>
    /// 起始行
    /// </summary>
    public Integer pageNum = null;

    /// <summary>
    /// 每页显示条数
    /// </summary>
    public Integer pageSize = null;

    public List<IndexColumn> getSelectColumns() {
        return selectColumns == null ? new ArrayList<IndexColumn>() : selectColumns;
    }

    public void setSelectColumns(List<IndexColumn> selectColumns) {
        this.selectColumns = selectColumns;
    }

    public List<OrderColumn> getOrderColumns() {
        return orderColumns == null ? new ArrayList<OrderColumn>() : orderColumns;
    }

    public void setOrderColumns(List<OrderColumn> orderColumns) {
        this.orderColumns = orderColumns;
    }

    public List<FilterColumn> getFilters() {
        return filters == null ? new ArrayList<FilterColumn>() : filters;
    }

    public void setFilters(List<FilterColumn> filters) {
        this.filters = filters;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("QueryCriteria{");
        sb.append("selectColumns=").append(selectColumns);
        sb.append(", orderColumns=").append(orderColumns);
        sb.append(", filters=").append(filters);
        sb.append(", pageNum=").append(pageNum);
        sb.append(", pageSize=").append(pageSize);
        sb.append('}');
        return sb.toString();
    }
}
