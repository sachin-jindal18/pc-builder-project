package com.example.demo.core.components;

import com.example.demo.core.compatibility.FormFactor;
import com.example.demo.core.compatibility.FormFactors;

public class Cabinet implements FormFactor {
    @Override
    public FormFactors formFactors() {
        return FormFactors.ATX;
    }
}
