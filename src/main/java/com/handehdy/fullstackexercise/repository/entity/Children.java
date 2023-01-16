package com.handehdy.fullstackexercise.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Children {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String name;
    @JoinColumn(name = "citizenId", nullable = false)
    Long citizenId;
    @Builder.Default
    @Column(name = "is_citizen", columnDefinition = "boolean default true", nullable = false)
    Boolean isCitizen = true;
}
