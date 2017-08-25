package com.ak.learning.springjsonread.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@AllArgsConstructor
@Embeddable
@XmlRootElement
public class Geo {
    private String lat;
    private String lng;

    public Geo() {}
}
