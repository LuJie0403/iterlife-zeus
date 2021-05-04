package com.iterlife.zeus.lang.feature;
import org.apache.commons.lang3.ObjectUtils;
import java.util.HashMap;
import java.util.Map;

public class ConditionalExpressionTest {
    public static void main(String[] args){
        testBoxCondition();
    }


    /**
     * 下述测试方法在JDK1.8以前版本和JDK1.8以后版本(含)三目运算符与引用表达式类型的问题
     * <JDK1.8版本：NPE,NPE,NPE
     * 三目运算符表达式 2 和表达式 3 分别为基本类型和包装类型时，其运算结果默认为基本类型（包装类型通过拆箱xxxValue()生成原始类型），所以拆箱时可能发生NPE
     * 如果最终结果需要转换为包装类型，则需要通过装箱valueOf() 装换为包装类型
     * <p>
     * >=JDK1.8版本:null,NPE,null,null
     * 存在引用表达式的概念：JSL 规定 Object 对象引用表达式的类型与其目标对象的类型一致(泛型编译后被擦除，默认全部是 Object 类型，通过强制类型转换成为目标类型)
     * Object 引用表达式约定优先于引用、拆箱、装箱，所以 result1=null,而 result2 会继续NPE
     * <p>
     * BTW:
     * result4 属于属于常量赋值问题，不涉及拆箱问题
     */
    private static void testBoxCondition() {
        Boolean nullObject = null;
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        Boolean result1 = (map != null) ? map.get("key") : false;
        System.out.println(result1);

        Boolean result2 = (map != null) ? nullObject : false;
        System.out.println(result2);

        Boolean result3 = (map != null) ? ObjectUtils.defaultIfNull(nullObject, nullObject) : false;
        System.out.println(result3);

        Boolean result4 = (map != null) ? null : false;
        System.out.println(result4);

    }
}
