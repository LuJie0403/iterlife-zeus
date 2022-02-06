package com.iterlife.zeus.tqi;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.Arrays;

/**
 * @desc:
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2022/2/4 22:50
 **/
public class Main {
    public final static int DATA_ITEM_SIZE = 7;

    public static void main(String args[]) {

        XData xData = new XData(DATA_ITEM_SIZE);

        //数据格式化保存
        calcXData(xData);
        //System.out.println(JSON.toJSONString(xData, true));

        //计算标准差
        Double[] tqis = new Double[DATA_ITEM_SIZE];
        for (int i = 0; i < DATA_ITEM_SIZE; ++i) {
            XElem xElem = (XElem) xData.xElemList[i].getLast();
            tqis[i] = Math.sqrt(xElem.accumulatedSdamValue / xElem.index);
        }

        Arrays.asList(tqis).stream().mapToDouble(Double::doubleValue).forEach(System.out::println);
        //计算 TQI
        double tqi = Arrays.asList(tqis).stream().mapToDouble(Double::doubleValue).sum();
        System.out.println(tqi);

    }

    private static void calcXData(XData xData) {
        try {
            FileReader fileReader = new FileReader("../iterlife-zeus/zeus-tqi/src/main/resources/input.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String dataLine = null;
            int jCounter = 1;
            while ((dataLine = bufferedReader.readLine()) != null) {
                double[] dData = getData(dataLine);
                for (int iCounter = 0; iCounter < DATA_ITEM_SIZE; ++iCounter) {
                    xData.addData(iCounter, jCounter, dData[iCounter + 1]);
                }
                jCounter++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double[] getData(String dataLine) {
        String[] sData = dataLine.split("\\t");
        double[] dData = new double[8];
        for (int i = 0; i < 8; ++i) {
            if (i < sData.length) {
                dData[i] = Double.parseDouble(sData[i]);
            } else {
                dData[i] = 0.0d;
            }
        }
        return dData;
    }
}
