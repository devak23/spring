package com.ak.learning.common.interfaces;

public interface IByNameApi<T extends IWithName> {

    T findByName(final String name);

}
