package com.zzw.java.base.enums;

import lombok.Data;

/**
 * learn about enum
 * application of enum
 *
 * @author Daydreamer
 * @date 2020/8/8 22:02
 */

@Data
public class Pizza {

    private PizzaStatus status;

    /**
     * 判断 pizza 是否已经送达
     *
     * @return
     */
    public boolean deliverable() {
        return this.getStatus().equals(PizzaStatus.DELIVERED);
    }
}
