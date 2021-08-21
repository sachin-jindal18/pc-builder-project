package com.example.demo.core.components;

import com.example.demo.core.compatibility.PowerSupplier;

public abstract class PSU implements PowerSupplier {

    public  static  PSU create(int capacity) {
        return new PSU() {
            @Override
            public int suppliedPower() {
                return capacity;
            }
        };
    }
}
