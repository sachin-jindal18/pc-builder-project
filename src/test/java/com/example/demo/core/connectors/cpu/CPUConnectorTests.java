package com.example.demo.core.connectors.cpu;

import com.example.demo.core.components.cpu.AMDCCPU;
import com.example.demo.core.components.cpu.IntelCPU;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CPUConnectorTests {

    @Test
    void canConnectIntelCPUtoIntelSocket() {
        var socket = new LGA1200();
        var cpu = new IntelCPU();
        socket.connect(cpu);
    }

    @Test
    void canNotConnectIntelCPUtoAMDSocket() {
        try {
            var socket = new LGA1200();
            var cpu = new AMDCCPU();
            socket.connect(cpu);
            assertNull(socket.getCpu());
            throw new IllegalStateException("Mismatched vendors should not work");
        } catch (IllegalArgumentException illegalArgumentException) {
            assertEquals("Cannot connect AMD CPU to INTEL socket", illegalArgumentException.getMessage());
        }
    }
}
