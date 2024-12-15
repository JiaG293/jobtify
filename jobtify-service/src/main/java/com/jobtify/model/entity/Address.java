package com.jobtify.model.entity;

import com.neovisionaries.i18n.CountryCode;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
@DynamicInsert
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "address", schema = "jobtify_service")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "add_id")
    String id;
    @Column(name = "number")
    String number;
    @Column(name = "street")
    String street;
    @Column(name = "city")
    String city;
    @Column(name = "zipcode")
    String zipcode;
    @Column(name = "country")
    CountryCode country = CountryCode.VN;


}