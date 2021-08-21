package com.example.demo.core.systems;

public class Tower {


    public boolean fullyConfigured() {
        /*
            TODO: add logic to check for minimum component's
                    1. motherboard installed
                    2. CPU installed
                    3. RAM installed
                    4. CPU has internal GPU, or GPU is installed.
                    5. At least one storage installed
                    6. SMPS installed
                        6.a SMPS power >= CPU + GPU power requirement
         */
        return false;
    }

    public static class Builder {


        //      TODO: installing motherboard to be mandatory  first step
        //          -> replacing motherboard won't be possible
        //          -> all other installation will first check if motherboard exists or not.
        public Tower build() {
            // TODO: Check fully configured logic here as well.
            var tower = new Tower();


            return tower;
        }
    }
}
