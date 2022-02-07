package com.iterlife.zeus.tqi;

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
        //全量计算所有测试数据
        calcTQI4AllMileage();

        //区间计算所有测试数据
        calcTQIByPartitionMileage();

    }

    /**
     * 区间计算所有测试数据
     */
    private static void calcTQIByPartitionMileage() {
        try {
            FileReader fileReader = new FileReader("../iterlife-zeus/zeus-tqi/src/main/resources/input.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            XData xData = new XData(DATA_ITEM_SIZE);
            String dataLine = null;
            int jCounter = 1;
            while ((dataLine = bufferedReader.readLine()) != null) {
                double[] dData = resolveItems(dataLine);
                for (int iCounter = 0; iCounter < DATA_ITEM_SIZE; ++iCounter) {
                    xData.appendXElem(iCounter, jCounter, dData[iCounter + 1]);
                }
                jCounter++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 全量计算所有测试数据
     */
    private static void calcTQI4AllMileage() {
        //初始化结构化数据存储器
        XData xData = new XData(DATA_ITEM_SIZE);

        //格式化数据计算与保存
        calcXData(xData);

        //计算各项标准差值
        Double[] tqis = calcItemTQI(xData);

        //计算 TQI
        double tqi = calcTQI(tqis);

        //输出 TQI
        System.out.println(tqi);
    }

    /**
     * 计算 TQI
     */
    private static double calcTQI(Double[] tqis) {
        double tqi = Arrays.asList(tqis).stream().mapToDouble(Double::doubleValue).sum();
        Arrays.asList(tqis).stream().mapToDouble(Double::doubleValue).forEach(System.out::println);
        return tqi;
    }

    /**
     * 计算各项标准差值
     */
    private static Double[] calcItemTQI(XData xData) {
        Double[] tqis = new Double[DATA_ITEM_SIZE];
        for (int i = 0; i < DATA_ITEM_SIZE; ++i) {
            XElem xElem = (XElem) xData.xElemList[i].getLast();
            tqis[i] = Math.sqrt(xElem.accumulatedSdamValue / xElem.offset);
        }
        return tqis;
    }

    /**
     * 格式化数据计算与保存
     */
    private static void calcXData(XData xData) {
        try {
            FileReader fileReader = new FileReader("../iterlife-zeus/zeus-tqi/src/main/resources/input.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String dataLine = null;
            int jCounter = 1;
            while ((dataLine = bufferedReader.readLine()) != null) {
                double[] dData = resolveItems(dataLine);
                for (int iCounter = 0; iCounter < DATA_ITEM_SIZE; ++iCounter) {
                    xData.appendXElem(iCounter, jCounter, dData[iCounter + 1]);
                }
                jCounter++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析并转换测量值
     */
    private static double[] resolveItems(String dataLine) {
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
