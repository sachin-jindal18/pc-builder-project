package com.example.demo.core.components;

import com.example.demo.core.compatibility.CompositePowerConsumer;
import com.example.demo.core.compatibility.FormFactor;
import com.example.demo.core.compatibility.FormFactors;
import com.example.demo.core.compatibility.PowerConsumer;

import java.util.Arrays;
import java.util.List;


public abstract class Motherboard implements FormFactor, CompositePowerConsumer {

     // TODO whenever CPU, GPU , PCI cards are connected, add them to child power consumers
    public static Motherboard create(FormFactors formFactors) {
        return new Motherboard() {
            @Override
            public List<PowerConsumer> getChildPowerConsumer() {
                return Arrays.asList();
            }

            @Override
            public int selfConsumedPower() {
                return 0;
            }

            @Override
            public int consumedPower() {
                return 0;
            }

            @Override
            public FormFactors formFactors() {
                return formFactors;
            }
        };
    }

}
