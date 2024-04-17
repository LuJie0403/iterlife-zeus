package com.iterlife.zeus.demo.osf;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @desc:
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/3/29 17:05
 **/
public class FastJsonSerializedTest {

    public static void main(String args[]) {
        Object1 object1 = Object1.buildDefault();
        String objectJSONString = JSON.toJSONString(object1, SerializerFeature.PrettyFormat, SerializerFeature.DisableCircularReferenceDetect);
        //输出结果没有转义符
        System.out.println(String.format("objectString=%s", objectJSONString));
        Object1 object1Obj = JSON.parseObject(objectJSONString, Object1.class);

    }


}



