package com.jobtify.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
@DynamicInsert
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "company", schema = "jobtify_service")
public class Company {
    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "com_id")
    String id;

    @Column(name = "comp_name", nullable = false)
    String name;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address", nullable = false)
    Address address;

    @Column(name = "web_url")
    String webURL;

    @Column(name = "phone", nullable = false)
    String phone;

    @Column(name = "email", nullable = false)
    String email;

    @Column(name = "about", length = 2000)
    String about;





    @OneToMany(mappedBy = "company")
    List<Job> jobs;

    @Override
    public String toString() {
        return "Company{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address=" + (address != null ? address.toString() : "null") +
                ", webURL='" + webURL + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", about='" + about + '\'' +
                '}';
    }

}