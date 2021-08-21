package com.example.demo.core;

import com.example.demo.core.systems.Tower;
import com.example.demo.core.systems.KVM;
import com.example.demo.core.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This is the main class which having all the components for the pc builder
 */
public class PC {

    private PC(Tower tower, KVM kvm, List<Peripheral> peripherals) {
        this.tower = tower;
        this.kvm = kvm;
        this.peripherals = peripherals;
    }

    //KVM -> KVM stands for "keyboard, video, mouse," and
    // allows you to control multiple computers from a single keyboard, mouse, and monitor.
    KVM kvm;

    // cabinet
    Tower tower;

    //peripherals
    List<Peripheral> peripherals;

    public static class Builder {

        Tower tower;
        List<Peripheral> peripherals;
        KVM kvm;

        public Builder() {

        }

        public Builder withTower(Tower tower) {
            if (!tower.fullyConfigured()) {
                throw new IllegalStateException("Trying to add a cabinet not fully configured");
            }
            this.tower = tower;
            return this;
        }

        public Builder withKVM(KVM kvm) {

            if (!kvm.fullyConfigured()) {
                throw new IllegalStateException("Trying to add a kvm not fully configured");
            }
            this.kvm = kvm;
            return this;
        }

        public Builder addPeripherals(Peripheral... peripherals) {
            if (this.peripherals == null) {
                this.peripherals = new ArrayList<>();
            }
            this.peripherals.addAll(Arrays.asList(peripherals));
            return this;
        }

        public Builder clearPeripherals() {
            if (this.peripherals != null) {
                this.peripherals.clear();
            }
            return this;
        }

        public PC build() {
            var pc = new PC(tower, kvm, peripherals);
            //  TODO: check cabinet exists
            // TODO: check kvm exists
            // TODO: cabinet has all ports that kvm needs
            // TODO: caninet has ports required for the peripherls
            return pc;
        }
    }

}
