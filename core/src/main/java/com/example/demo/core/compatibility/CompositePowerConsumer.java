package com.example.demo.core.compatibility;

import java.util.List;

public interface CompositePowerConsumer extends PowerConsumer {
    List<PowerConsumer> getChildPowerConsumer();

    int selfConsumedPower();

    @Override
    default int consumedPower() {
        int consumePower = selfConsumedPower();
        for (PowerConsumer powerConsumer : getChildPowerConsumer()) {
            consumePower += powerConsumer.consumedPower();
        }
        return consumePower;
    }


}
