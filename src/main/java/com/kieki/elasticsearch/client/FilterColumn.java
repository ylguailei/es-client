package com.kieki.elasticsearch.client;

/**
 * Created by kieki on 2016/11/10.
 */
public class FilterColumn {

    /**
     * 列名
     */
    public String columnName;

    /// <summary>
    /// 比较操作符
    /// </summary>
    public Comparison comparison;

    /// <summary>
    /// 比较值
    /// </summary>
    public Object value;

    public FilterColumn() {
    }

    public FilterColumn(String columnName, Comparison comparison, Object value) {
        this.columnName = columnName;
        this.comparison = comparison;
        this.value = value;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Comparison getComparison() {
        return comparison;
    }

    public void setComparison(Comparison comparison) {
        this.comparison = comparison;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("FilterColumn{");
        sb.append("columnName='").append(columnName).append('\'');
        sb.append(", comparison=").append(comparison);
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}
