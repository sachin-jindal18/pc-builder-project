package com.example.demo.core.systems;

import com.example.demo.core.compatibility.FormFactors;
import com.example.demo.core.components.Cabinet;
import com.example.demo.core.components.Motherboard;
import com.example.demo.core.components.PSU;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


public class TowerBuilderTests {
    @Test
    void canCreatePCTower() {
        var towerBuilder = new Tower.Builder().withCabinet(Cabinet.create(FormFactors.ATX))
                .withMotherboard(Motherboard.create(FormFactors.ATX))
                .withPSU(PSU.create(500)).build();
    }

    @Test
    void failedCreatePCTowerWithoutCabinet() {
        try {
            var towerBuilder = new Tower.Builder()
                    .withMotherboard(Motherboard.create(FormFactors.microATX)).withPSU(PSU.create(500))
                    .build();
        } catch (IllegalStateException illegalStateException) {
            assertEquals("Cannot built tower without a cabinet", illegalStateException.getMessage());
        }

    }

    @Test
    void failedCreatePCTowerWithoutPSU() {
        try {
            var towerBuilder = new Tower.Builder().withCabinet(Cabinet.create(FormFactors.ATX))
                    .withMotherboard(Motherboard.create(FormFactors.microATX))
                    .build();
        } catch (IllegalStateException illegalStateException) {
            assertEquals("Cannot built tower without a psu", illegalStateException.getMessage());
        }

    }

    @Test
    void failedCreatePCTowerWithSizeMismatch() {

        try {
            var towerBuilder = new Tower.Builder().withCabinet(Cabinet.create(FormFactors.microATX))
                    .withMotherboard(Motherboard.create(FormFactors.ATX))
                    .withPSU(PSU.create(500)).build();

        } catch (IllegalStateException illegalStateException) {
            assertEquals("cannot fit bigger motherboard in small cabinet", illegalStateException.getMessage());
        }
    }
}
