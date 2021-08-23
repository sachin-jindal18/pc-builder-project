package com.example.demo.core.compatibility;

public enum FormFactors {


    miniITX(100),
    microATX(200),
    ATX(300);

    int size;

    FormFactors(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
