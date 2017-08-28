package com.ak.learning.employee.v1.models;

import org.springframework.beans.factory.annotation.Value;

import java.util.Collection;

public abstract class HateoasListModel<T> {
    protected Collection<T> entities;

    protected int currentPageIndex;

    @Value("app.rest.pageSize")
    protected int pageSize;

    @Value("app.rest.url")
    protected String appURL;

    public HateoasListModel(Collection<T> listOfModel) {
        this.entities = listOfModel;
        this.currentPageIndex = 1;
    }

    public Collection<T> getHateoasModels() {
        return this.entities;
    }

    public int getCount() {
        return this.entities.size();
    }


    public String getPreviousUrl() {
        if (currentPageIndex < pageSize) {
            return null;
        } else {
            return appURL + "page/" + (getCount()/pageSize - currentPageIndex);
        }
    }

    public String getNextUrl() {
        if (currentPageIndex == getCount()/pageSize) {
            return null;
        }
        return appURL + "page/" + (currentPageIndex+1);
    }
    public String first() {
        return appURL + "page/" + currentPageIndex;
    }

    public String last() {
        return appURL + "page/" + (getCount()/pageSize);
    }

}

