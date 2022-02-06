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
    public int size;
    public LinkedList[] xElemList;


    public XData(int size) {
        this.size = size;
        this.xElemList = new LinkedList[this.size];
        for (int i = 0; i < size; ++i) {
            this.xElemList[i] = new LinkedList();
        }
    }


    public void addData(int i, int j, double value) {
        XElem preXElem = getPreXElem(i);
        XElem xElem = new XElem(j, value, preXElem.getSumValue(), preXElem.getAccumulatedSdamValue());
        xElemList[i].addLast(xElem);
    }

    private XElem getPreXElem(int i) {
        LinkedList<XElem> xElemList = this.xElemList[i];
        if (xElemList.isEmpty()) {
            return new XElem(0, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d);
        }
        return xElemList.getLast();
    }
}
