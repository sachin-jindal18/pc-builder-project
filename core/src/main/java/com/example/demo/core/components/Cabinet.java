package com.example.demo.core.components;

import com.example.demo.core.compatibility.CompositePowerConsumer;
import com.example.demo.core.compatibility.FormFactor;
import com.example.demo.core.compatibility.FormFactors;
import com.example.demo.core.compatibility.PowerConsumer;

import java.util.List;

public abstract class Cabinet implements FormFactor , CompositePowerConsumer {
    public static Cabinet create(FormFactors formFactors) {
        return new Cabinet() {
            @Override
            public List<PowerConsumer> getChildPowerConsumer() {
                return null;
            }

            @Override
            public int selfConsumedPower() {
                return 0;
            }

            @Override
            public FormFactors formFactors() {
                return formFactors;
            }
        };
    }
}
