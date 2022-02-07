package com.iterlife.zeus.tqi;

import lombok.*;

import java.util.LinkedList;

/**
 * @desc:
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2022/2/6 13:24
 **/
@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class XData {

    //项数量，默认等于7
    public int itemCapacity;
    public int mileageCounter;
    public double[] sumValue;
    public double[] avgValue;
    public LinkedList[] xElemList;


    public XData(int itemCapacity) {
        this.itemCapacity = itemCapacity;
        this.mileageCounter = 0;
        this.xElemList = new LinkedList[this.itemCapacity];
        for (int i = 0; i < itemCapacity; ++i) {
            this.sumValue[i] = 0.0d;
            this.avgValue[i] = 0.0d;
            this.xElemList[i] = new LinkedList();
        }
    }


    public void appendXElem(int itemIndex, int j, double value) {
        XElem lastXElem = getLastXElem(itemIndex);
        XElem xElem = new XElem(j, value, lastXElem.getSumValue(), lastXElem.getAccumulatedSdamValue());
        xElemList[itemIndex].addLast(xElem);
    }

    private XElem getLastXElem(int i) {
        LinkedList<XElem> xElemList = this.xElemList[i];
        if (xElemList.isEmpty()) {
            return new XElem(0, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d);
        }
        return xElemList.getLast();
    }
}
