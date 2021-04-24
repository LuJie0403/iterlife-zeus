package com.iterlife.zeus.osf;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @desc:
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/3/29 17:52
 **/
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Object2 {
    private Integer id;
    private String name;
    private Map<String, String> map;
}