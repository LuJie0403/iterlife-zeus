package com.iterlife.zeus.tqi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @desc:
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2022/2/6 13:21
 **/
@ToString
@Data
@Builder
@AllArgsConstructor
public class XElem {

    //XDate内部偏移量(从0开始计数)
    public int offset;

    //测量值
    public double value;
    // 平均值
    public double avgValue;

    // 累加和（当前值/后值）
    public double sumValue;
    // 累加和（前值）
    public double preSumValue;

    // 平方差（当前值）
    public double sdamValue;
    // 平方差（累加值）
    public double accumulatedSdamValue;

    public XElem(int counter, double value, double preSumValue, double accumulatedSdamValue) {
        this.offset = counter;

        this.value = value;
        this.preSumValue = preSumValue;
        this.sumValue = this.preSumValue + this.value;

        this.sdamValue = Math.pow(this.value, 2) - Math.pow(this.avgValue, 2);
        this.accumulatedSdamValue = this.sdamValue + accumulatedSdamValue;

        this.avgValue = this.sumValue / counter;
    }
}
