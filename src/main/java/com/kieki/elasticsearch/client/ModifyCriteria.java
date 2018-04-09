package com.kieki.elasticsearch.client;

/**
 * Created by kieki on 2016/11/11.
 */
public class ModifyCriteria {
    private String clounName;
    private String value;

    public ModifyCriteria() {
    }

    public ModifyCriteria(String clounName, String value) {
        this.clounName = clounName;
        this.value = value;
    }

    public String getClounName() {
        return clounName;
    }

    public void setClounName(String clounName) {
        this.clounName = clounName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
