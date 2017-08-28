package com.ak.learning.common.persistence.service;

import com.ak.learning.common.interfaces.IByNameApi;
import com.ak.learning.common.persistence.model.INameableEntity;

public interface IService<T extends INameableEntity> extends IRawService<T>, IByNameApi<T> {

    //

}
