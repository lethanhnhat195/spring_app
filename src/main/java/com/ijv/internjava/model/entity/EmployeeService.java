package com.ijv.internjava.model.entity;

import com.ijv.internjava.model.dto.BaseEntity;
import javax.persistence.*;
import lombok.Data;


import java.util.Date;

@Data
@Entity
@Table(name = "employee_service")
public class EmployeeService extends BaseEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity=Employees.class,fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false)
    private Employees employee;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SERVICE_ID", nullable = false)
    private Services service;

    @Column(name = "NOTE")
    private String note;

}
