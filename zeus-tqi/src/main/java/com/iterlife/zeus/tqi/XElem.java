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

    public int index;
    public double value;
    public double avgValue;
    public double sumValue;
    public double preSumValue;

    // 平方差（当前值）
    public double sdamValue;
    // 平方差（累加值）
    public double accumulatedSdamValue;

    public XElem(int counter, double value, double preSumValue, double accumulatedSdamValue) {
        this.index = counter;

        this.value = value;
        this.preSumValue = preSumValue;
        this.sumValue = this.preSumValue + this.value;

        this.sdamValue = Math.pow(this.value, 2) - Math.pow(this.avgValue, 2);
        this.accumulatedSdamValue = this.sdamValue + accumulatedSdamValue;

        this.avgValue = this.sumValue / counter;
    }
}
