package com.iterlife.zeus.feature;


import com.iterlife.zeus.demo.entity.User1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Jdk18xStreamTest 类用于演示和测试 Java 1.8 及以上版本中 Stream API 的用法。
 */
public class Jdk18xStreamTest {
    // 该类中包含的示例方法将演示 Stream API 的各种操作，如过滤、映射和收集等。
    /**
     * 主函数入口
     * @param args 命令行参数
     * 初始化一个用户列表并对其进行测试
     */
    public static void main(String[] args) {
        // 创建用户列表并添加用户对象
        List<User1> users = new ArrayList<User1>();
        users.add(new User1("100", "lujie", 26));
        users.add(new User1("102", "zhangsan", 29));
        users.add(new User1("102", "zhangsan", 29));
        users.add(new User1("102", "zhangsan", 24));
        users.add(new User1("105", "lisi", 34));
        users.add(new User1("105", "lisi", 34));
        // 对用户列表进行测试
        doTest(users);

    }



    /**
     * 对用户列表进行一系列操作和筛选展示。
     *
     * @param list 包含User1对象的列表，该列表不为空。
     */
    public static void doTest(List<User1> list) {
        // 打印用户列表中每个用户的名称
        list.forEach(user -> System.out.println(user.getName()));

        // 通过stream遍历用户列表，并打印每个用户对象
        list.stream().forEach(user -> System.out.println(user));

        // 按年龄排序后，打印用户列表
        list.stream().sorted(Comparator.comparing(User1::getAge)).forEach(user -> System.out.println(user));

        // 再次打印用户列表中每个用户的名称
        list.forEach(user -> System.out.println(user.getName()));

        // 筛选出年龄大于30的用户，并打印
        list.stream().filter((User1 user) -> user.getAge() > 30).forEach(user -> System.out.println(user));

        // 打印列表中前两个用户对象
        list.stream().limit(2).forEach(user -> System.out.println(user));

        // 打印列表中跳过第一个用户后的所有用户对象
        list.stream().skip(1).forEach(user -> System.out.println(user));
        System.out.println("***************************");

        // 打印去重后的用户列表
        list.stream().distinct().forEach(user -> System.out.println(user));
        System.out.println("***************************");

        // 筛选年龄小于30的用户，按年龄升序取前两个，并打印
        list.stream().distinct().filter((User1 user) -> user.getAge() < 30).sorted(Comparator.comparing(User1::getAge)).limit(2).forEach(user -> System.out.println(user));

        // 同上，另一种写法
        list.stream().distinct().filter((User1 user) -> user.getAge() < 30).sorted(Comparator.comparing(User1::getAge)).limit(2).forEach(user -> System.out.println(user));

        // 筛选年龄小于30的用户，按年龄降序取前两个，并打印
        list.stream().distinct().filter((User1 user) -> user.getAge() < 30).sorted(Comparator.comparing(User1::getAge).reversed()).limit(2).forEach(user -> System.out.println(user));

        // 计算并打印用户列表中年龄的统计信息
        IntSummaryStatistics statistics = list.stream().mapToInt(User1::getAge).summaryStatistics();
        System.out.println(statistics);

        // 将用户名称转换为大写，并收集到新列表中，然后打印该列表
        List<String> collect = list.stream().map(user -> user.getName().toUpperCase()).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }


}
