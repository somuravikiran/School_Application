package com.greetlabs.School_Application.model;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "holidays")
public class Holiday extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "holiday_date")
    private String holidayDate;

    private String reason;

    @Column(name = "holiday_type")
    @Enumerated(EnumType.STRING)
    private Type holidayType;

    public enum Type {
        FESTIVAL, FEDERAL
    }
}