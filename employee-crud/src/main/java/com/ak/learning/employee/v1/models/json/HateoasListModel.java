package com.ak.learning.employee.v1.models.json;

import org.springframework.beans.factory.annotation.Value;

import java.util.Collection;

public class HateoasListModel<T> {
    protected Collection<T> entities;
    protected String previousURL;
    protected String nextUrl;
    protected String first;
    protected String last;

    private int currentPageIndex;

    @Value("app.rest.pageSize")
    private Integer pageSize;

    @Value("app.rest.url")
    private String appURL;

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

//
//    public String getPreviousUrl() {
//        System.out.println("Prev URL pageSize: " + pageSize);
//
//        if (currentPageIndex < pageSize) {
//            return "";
//        } else {
//            return appURL + "page/" + (getCount()/pageSize - currentPageIndex);
//        }
//    }

//    public String getNextUrl() {
//        System.out.println("NextURL pageSize: " + pageSize);
//
//        if (currentPageIndex == getCount()/pageSize) {
//            return "";
//        }
//        return appURL + "page/" + (currentPageIndex+1);
//    }

    public String first() {
        this.first = appURL + "page/" + currentPageIndex;
        return first;
    }

    public String last() {
        this.last = appURL + "page/" + (getCount() / pageSize);
        return last;
    }

}

