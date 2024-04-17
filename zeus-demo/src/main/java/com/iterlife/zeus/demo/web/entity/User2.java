package com.iterlife.zeus.demo.web.entity;

import com.iterlife.zeus.starter.annotation.IterLife;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;

/**
 * @desc:
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2020/10/7 16:51
 **/
@Getter
@Setter
@NoArgsConstructor
@IterLife(id = "000000", name = "iterlife-user", desc = "this is a test annotation for IterLife")
@Slf4j
public class User2 {

    public String id;
    public String name;
    public String gender;
    public int age;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }

    public void printAnnotation() {
        Class clazz = this.getClass();
        if (clazz.isAnnotationPresent(IterLife.class)) {
            Annotation annotation = clazz.getAnnotation(IterLife.class);
            log.info(annotation.toString());
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
