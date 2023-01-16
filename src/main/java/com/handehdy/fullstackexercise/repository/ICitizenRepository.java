package com.handehdy.fullstackexercise.repository;

import com.handehdy.fullstackexercise.repository.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ICitizenRepository extends JpaRepository<Citizen,Long> {

    List<Citizen> findByIsCitizen(Boolean isCitizen);
    List<Citizen> findByName(String name);
    @Query("SELECT c FROM citizen c WHERE c.name LIKE %?1%")
    List<Citizen> findByNameContains(String letter);
    List<Citizen> findByHasDrivingLicense(Boolean hasDrivingLicence);
    Optional<Citizen> findById(Optional<Long> citizenId);
}
