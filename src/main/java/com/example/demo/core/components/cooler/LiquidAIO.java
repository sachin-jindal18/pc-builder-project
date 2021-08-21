package com.example.demo.core.components.cooler;

public class LiquidAIO implements Cooler {
    @Override
    public int consumedPower() {
        return 12; // make configurable
    }
}
