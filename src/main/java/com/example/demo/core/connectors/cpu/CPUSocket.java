package com.example.demo.core.connectors.cpu;

import com.example.demo.core.components.cpu.CPU;
import com.example.demo.core.vendors.ChipVendor;
import com.example.demo.core.vendors.Vendors;
import lombok.Getter;

public abstract class CPUSocket {
    @Getter
    CPU cpu;

    void connect(CPU cpu) {

        ChipVendor cpuChipVendor = cpu.getClass().getAnnotation(Vendors.class).chip();
        ChipVendor socketChipVendor = this.getClass().getAnnotation(Vendors.class).chip();
        if (cpuChipVendor != socketChipVendor) {
            throw new IllegalArgumentException("Cannot connect " + cpuChipVendor + " CPU to " + socketChipVendor + " socket");
        }
        this.cpu = cpu;
    }
}
