package com.example.demo.core;

import com.example.demo.core.compatibility.FormFactors;
import com.example.demo.core.components.Cabinet;
import com.example.demo.core.components.Motherboard;
import com.example.demo.core.components.PSU;
import com.example.demo.core.peripherals.Display;
import com.example.demo.core.peripherals.Keyboard;
import com.example.demo.core.peripherals.Mouse;
import com.example.demo.core.systems.KVM;
import com.example.demo.core.systems.Tower;
import org.junit.jupiter.api.Test;

public class PCBuilderTests {

    @Test
    public void canCreateBasicPCWithBuilder() {
        var pcBuilder = new PC.Builder().withKVM(
                new KVM
                        .Builder().withDisplay(new Display()).withKeyboard(new Keyboard()).withMouse(new Mouse()).build())
                .withTower(new Tower
                        .Builder().withCabinet(Cabinet.create(FormFactors.ATX))
                        .withMotherboard(Motherboard.create(FormFactors.ATX)).withPSU(PSU.create(500)).build());
        System.out.println("Test Passed");
    }
}
