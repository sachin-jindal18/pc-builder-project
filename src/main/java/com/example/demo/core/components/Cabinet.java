package com.example.demo.core.components;

import com.example.demo.core.compatibility.FormFactor;
import com.example.demo.core.compatibility.FormFactors;

public abstract class Cabinet implements FormFactor {
    public static Cabinet create(FormFactors formFactors) {
        return new Cabinet() {
            @Override
            public FormFactors formFactors() {
                return formFactors;
            }
        };
    }
}
