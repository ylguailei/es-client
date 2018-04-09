package com.kieki.elasticsearch.client;

/**
 * 比较操作符
 * Created by kieki on 2016/11/10.
 */
public enum Comparison {
    /**
     * 等于
     */
    Equals("0"),
    /**
     * 不等于
     */
    NotEquals("1"),
    /**
     * 类似（模糊查询）
     */
    Like("2"),
    /**
     * 不类似
     */
    NotLike("3"),
    /**
     * 大于
     */
    GreaterThan("4"),
    /**
     * 大于等于
     */
    GreaterOrEquals("5"),
    /**
     * 小于
     */
    LessThan("6"),
    /**
     * 小于等于
     */
    LessOrEquals("7"),
    /**
     * 在...之内
     */
    In("8"),
    /**
     * 不在...之内
     */
    NotIn("9"),
    /**
     * 在...之间
     */
    Between("10"),
    /**
     * 不在...之间
     */
    NotBetween("11");

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    Comparison(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
