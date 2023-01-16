package com.handehdy.fullstackexercise.repository;

import com.handehdy.fullstackexercise.repository.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ICitizenRepository extends JpaRepository<Citizen,Long> {


    List<Citizen> findByIsCitizen(Boolean isCitizen);
   // @Query("SELECT p FROM person p WHERE p.name=name")
    List<Citizen> findByName(String name);
    @Query("SELECT c FROM citizen c WHERE c.name LIKE %?1%")
    List<Citizen> findByNameContains(String letter);
    //List<Person> findByNumberOfChildren ( int numOfChildren);
    List<Citizen> findByHasDrivingLicense(Boolean hasDrivingLicence);
    //@Query("SELECT count(children) FROM person WHERE id= #{personId}")
    //Integer countChildren(Long personId);


    Optional<Citizen> findById(Optional<Long> citizenId);
}
