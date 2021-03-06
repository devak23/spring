package com.ak.learning.springjsonread.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@AllArgsConstructor
@Embeddable
@XmlRootElement
public class Company {

    @Column(name = "company_name")
    private String name;
    @Column(name = "catch_phrase")
    private String catchPhrase;
    private String bs;

    public Company() {}
}
