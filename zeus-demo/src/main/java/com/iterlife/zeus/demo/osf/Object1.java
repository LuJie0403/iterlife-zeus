package com.iterlife.zeus.demo.osf;

/**
 * @desc:
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/3/29 17:51
 **/

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Object1 {
    private Integer id;
    private String name;
    private Object2 object2;
    private List<Object2> object2List;

    public static Object1 buildDefault() {
        Map<String, String> testMap = new HashMap<>();
        testMap.put("k1", "v1");
        testMap.put("k2", "v2");

        Object2 object21 = Object2.builder().id(21).name("object21").map(testMap).build();
        Object2 object22 = Object2.builder().id(22).name("object22").map(testMap).build();
        Object2 object23 = Object2.builder().id(23).name("object23").map(testMap).build();

        List<Object2> object2List = new ArrayList<>();
        object2List.add(object21);
        object2List.add(object22);
        object2List.add(object23);

        Object1 object1 = Object1.builder()
                .id(1)
                .name("object1")
                .object2(object21)
                .object2List(object2List)
                .build();
        return object1;
    }
}