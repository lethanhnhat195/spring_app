package com.ijv.internjava.model.entity;

import com.ijv.internjava.model.dto.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "employees")
public class Employees extends BaseEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "GENDER")
    private Boolean gender;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "BIRTHDAY")
    private Date birthday;

    @Column(name = "PHONE", nullable = false)
    private String phone;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "IMAGE")
    private String image;

    @Column(name = "USER_NAME", nullable = false)
    private String userName;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "WORK_SHIFT_ID", nullable = false)
    private Integer workShiftId;


    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> roles = new LinkedHashSet<>();
}
