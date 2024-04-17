package com.iterlife.zeus.algo.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @desc:https://leetcode-cn.com/problems/traffic-light-controlled-intersection/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/4/25 18:05
 **/
public class TrafficLightControlledIntersection {
    public static void main(String[] args) {

    }
}


class TrafficLight {
    //绿灯变化控制信号量，取值为1表示信号灯可以变更为A，取值为2表示信号灯可以变更为B
    private volatile AtomicInteger nextRoadCtl = new AtomicInteger(2);
    //当前通行道路信号量，取值为1表示当前A道路可以通行，取值为2表示当前B道路可以通行
    private volatile AtomicInteger curRoadId = new AtomicInteger(1);

    public TrafficLight() {

    }

    public void carArrived(
            int carId,           // ID of the car
            int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
            int direction,       // Direction of the car
            Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
            Runnable crossCar    // Use crossCar.run() to make car cross the intersection
    ) {
        synchronized (this) {
            //当前通行的道路和目标通行道路一致，直接通过
            if (roadId == curRoadId.get()) {
                crossCar.run();
                if (roadId == 1) {
                    nextRoadCtl.set(2);
                }
                if (roadId == 2) {
                    nextRoadCtl.set(1);
                }
                return;
            }
            //当前通行的道路和目标通行道路一致，等待获取绿灯变化控制信号量
            if (roadId == 1 && curRoadId.get() == 2 && nextRoadCtl.get() == 1) {
                turnGreen.run();
                curRoadId.set(roadId);
                nextRoadCtl.set(2);
            }
            if (roadId == 2 && curRoadId.get() == 1 && nextRoadCtl.get() == 2) {
                turnGreen.run();
                curRoadId.set(roadId);
                nextRoadCtl.set(1);
            }
            crossCar.run();
        }
    }
}