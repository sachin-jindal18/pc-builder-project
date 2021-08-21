package com.example.demo.core.systems;

import com.example.demo.core.components.Cabinet;
import com.example.demo.core.components.Motherboard;
import com.example.demo.core.components.PSU;

public class Tower {
    private Motherboard motherboard;
    private Cabinet cabinet;
    private PSU psu;

    public Tower(Motherboard motherboard, Cabinet cabinet, PSU psu) {
        this.motherboard = motherboard;
        this.cabinet = cabinet;
        this.psu = psu;
    }
//
//    public boolean fullyConfigured() {
//        /*
//            TODO: add logic to check for minimum component's
//                    1. motherboard installed
//                    2. CPU installed
//                    3. RAM installed
//                    4. CPU has internal GPU, or GPU is installed.
//                    5. At least one storage installed
//                    6. SMPS installed
//                        6.a SMPS power >= CPU + GPU power requirement
//         */
//        return false;
//    }

    public static class Builder {
        private Motherboard motherboard;
        private Cabinet cabinet;
        private PSU psu;

        public Builder withMotherboard(Motherboard motherboard) {
            this.motherboard = motherboard;
            return this;
        }

        public Builder withCabinet(Cabinet cabinet) {
            this.cabinet = cabinet;
            return this;
        }

        public Builder withPSU(PSU psu) {
            this.psu = psu;
            return this;
        }


        //      TODO: installing motherboard to be mandatory  first step
        //          -> replacing motherboard won't be possible
        //          -> all other installation will first check if motherboard exists or not.
        public Tower build() {
            // TODO: Check fully configured logic here as well.
            if (cabinet == null) {
                throw new IllegalStateException("Cannot built tower without a cabinet");
            }

            if (motherboard == null) {
                throw new IllegalStateException("Cannot built tower without a motherboard");
            }

            if (psu == null) {
                throw new IllegalStateException("Cannot built tower without a psu");
            }
            var tower = new Tower(motherboard, cabinet, psu);


            return tower;
        }
    }
}
