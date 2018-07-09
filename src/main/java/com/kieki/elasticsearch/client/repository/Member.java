package com.kieki.elasticsearch.client.repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Document(indexName = "member", type = "member", shards = 6, replicas = 1)
@Component
public class Member implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Field(type = FieldType.Long, index = FieldIndex.not_analyzed, store = true)
    private long memberId;
    @Field(type = FieldType.String, index = FieldIndex.not_analyzed, store = true)
    private String memberName;

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
}
