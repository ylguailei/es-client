package com.kieki.elasticsearch.client;

/**
 * 用于排序的列
 * Created by kieki on 2016/11/10.
 */
public class OrderColumn extends IndexColumn {
    /**
     * 排序
     */
    public DataSorting Sorting;

    public DataSorting getSorting() {
        return Sorting;
    }

    public void setSorting(DataSorting sorting) {
        Sorting = sorting;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("OrderColumn{");
        sb.append("Sorting=").append(Sorting);
        sb.append('}');
        return sb.toString();
    }
}
