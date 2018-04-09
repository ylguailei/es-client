package com.kieki.elasticsearch.client.response;

/**
 * 业务返回值
 * Created by kieki on 2016/11/14.
 */
public class BizResult {
    private int resultCode;
    private String resultMessage;
    private Object resultObject;
    private long total;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public Object getResultObject() {
        return resultObject;
    }

    public void setResultObject(Object resultObject) {
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
        final StringBuffer sb = new StringBuffer("BizResult{");
        sb.append("resultCode=").append(resultCode);
        sb.append(", resultMessage='").append(resultMessage).append('\'');
        sb.append(", resultObject=").append(resultObject);
        sb.append(", total=").append(total);
        sb.append('}');
        return sb.toString();
    }
}
