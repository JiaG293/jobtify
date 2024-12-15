package com.jobtify.model.entity;

import com.neovisionaries.i18n.CountryCode;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "addresses")
public class Address {
    @Id
    private String addId;
    private String street;
    private String number;
    private String city;
    private String zipcode;
    private String country;
}