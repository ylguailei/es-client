package com.kieki.elasticsearch.client.response;

import java.util.Objects;

/**
 * 业务返回值
 * Created by kieki on 2016/11/14.
 */
public class BizResult<T> {
    private T resultObject;
    private long total;

    public T getResultObject() {
        return resultObject;
    }

    public void setResultObject(T resultObject) {
        this.resultObject = resultObject;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "BizResult{" +
                "resultObject=" + resultObject +
                ", total=" + total +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BizResult<?> bizResult = (BizResult<?>) o;
        return total == bizResult.total &&
                Objects.equals(resultObject, bizResult.resultObject);
    }

    @Override
    public int hashCode() {

        return Objects.hash(resultObject, total);
    }
}
