package com.example.demo.core.vendors;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Vendors {
    ChipVendor chip();

    BoardVendor board() default BoardVendor.GENERIC;
}
