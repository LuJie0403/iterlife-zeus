package com.iterlife.zeus.demo.entity;

import lombok.*;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class User1 {

    private String id;

    private String name;

    public int age;
}