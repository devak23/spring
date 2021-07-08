package com.rnd.ak.model;

import org.immutables.value.Value;

@Value.Immutable
public abstract class User {
    public abstract String name();
    public abstract float age();
    public abstract String address();
    public abstract String cell();
}
