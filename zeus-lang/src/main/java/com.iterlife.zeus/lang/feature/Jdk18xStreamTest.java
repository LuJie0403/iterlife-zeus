package com.iterlife.zeus.lang.feature;


import com.iterlife.zeus.demo.entity.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Jdk18xStreamTest {


    public static void main(String args[]) {
        List< User > users = new ArrayList< User >();
        users.add(new User("100", "lujie", 26));
        users.add(new User("102", "zhangsan", 29));
        users.add(new User("102", "zhangsan", 29));
        users.add(new User("102", "zhangsan", 24));
        users.add(new User("105", "lisi", 34));
        users.add(new User("105", "lisi", 34));
        doTest(users);

    }


    public static void doTest(List< User > list) {
        list.forEach(user -> System.out.println(user.getName()));
        list.stream().forEach(user -> System.out.println(user));
        list.stream().sorted(Comparator.comparing(User::getAge)).forEach(user -> System.out.println(user));
        list.forEach(user -> System.out.println(user.getName()));
        list.stream().filter((User user) -> user.getAge() > 30).forEach(user -> System.out.println(user));
        list.stream().limit(2).forEach(user -> System.out.println(user));
        list.stream().skip(1).forEach(user -> System.out.println(user));
        System.out.println("***************************");
        list.stream().distinct().forEach(user -> System.out.println(user));
        System.out.println("***************************");
        //去重+年龄小于30+从大到小+取前2
        list.stream().distinct().filter((User user) -> user.getAge() < 30).sorted(Comparator.comparing(user -> user.getAge())).limit(2).forEach(user -> System.out.println(user));
        list.stream().distinct().filter((User user) -> user.getAge() < 30).sorted(Comparator.comparing(User::getAge)).limit(2).forEach(user -> System.out.println(user));
        list.stream().distinct().filter((User user) -> user.getAge() < 30).sorted(Comparator.comparing(User::getAge).reversed()).limit(2).forEach(user -> System.out.println(user));

        IntSummaryStatistics statistics = list.stream().mapToInt(User::getAge).summaryStatistics();
        System.out.println(statistics);

        List<String> collect=list.stream().map(user->user.getName().toUpperCase()).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }


}
