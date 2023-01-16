package com.handehdy.fullstackexercise.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity (name = "citizen")
@Table(name = "citizen_table")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @Column(name = "is_citizen", columnDefinition = "boolean default true")
    Boolean isCitizen;
    @Column(name = "has_driving_license", columnDefinition = "boolean default true")
    Boolean hasDrivingLicense;
    @OneToMany(mappedBy = "citizenId")
    @Column(name = "children")
    Set<Children> children;


}
