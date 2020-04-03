package com.yahu.live.event;

/**
 * Created by Dun on 2019/1/19.
 */

public class MyBusEvent {

    public static final int NETWORK_ENABLE = 9;



    public int event;
    public Object action;

    public MyBusEvent(int event, Object action){
        this.event = event;
        this.action = action;
    }
}
