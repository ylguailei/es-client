package com.kieki.elasticsearch.client;

import org.apache.commons.lang3.StringUtils;

/**
 * 数据排序方式
 * Created by kieki on 2016/11/10.
 */
public enum DataSorting {
    /**
     * 升序
     */
    Ascending("1"),

    /**
     * 降序
     */
    Descending("2");

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    public static DataSorting toDateSorting(String direaction){
        if(StringUtils.isEmpty(direaction)){
            return null;
        }
        switch (direaction.toUpperCase()) {
            case "ASC":
                return Ascending;
            case "1":
                return Ascending;
            case "DESC":
                return Descending;
            case "2":
                return Descending;
            default:
                return null;
        }
    }

    DataSorting(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
