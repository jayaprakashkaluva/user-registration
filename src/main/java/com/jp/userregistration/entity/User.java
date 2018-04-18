package com.jp.userregistration.entity;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

@Document
public class User {
    @Id
    private String id;
    @Field
    private String firstName;
    @Field
    private String lastName;
}
