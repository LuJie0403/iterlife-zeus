package com.iterlife.zeus.common.entity;

import lombok.*;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class User {

    private String id;

    private String name;

    public int age;
}