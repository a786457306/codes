package com.zzw.java.base.enums;

import lombok.Getter;

/**
 * learn about enum
 *
 * @author Daydreamer
 * @date 2020/8/8 22:03
 */

@Getter
public enum PizzaStatus {
    DELIVERED("delivered", 30),
    ORDERED("ordered", 5),
    READY("ready", 10);

    /** 状态对应的名字 */
    private String name;

    /** 达到对应状态需要花费的时间 */
    private int time;

    PizzaStatus(String name, int time) {
        this.name = name;
        this.time = time;
    }
}
