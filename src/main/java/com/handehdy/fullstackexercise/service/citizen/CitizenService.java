package com.handehdy.fullstackexercise.service.citizen;

import com.handehdy.fullstackexercise.dto.response.CitizenResponse;
import com.handehdy.fullstackexercise.repository.entity.Citizen;

import java.util.List;
import java.util.Optional;

public interface CitizenService {

     List<Citizen> getAllCitizens();
     Citizen getCitizenById(Long id);
     List<Citizen> getByName(String name);
     List<Citizen> getByNameContains(String str);
     List<Citizen> getByHasDrivingLicense(Boolean hasDrivingLicence);
     List<Citizen> getByIsCitizen(Boolean isCitizen);
    Citizen updateOneCitizen(Long citizenId, Citizen newCitizen);
    Citizen addOneCitizen(Citizen newCitizen);
    Integer countChildren(Optional<Long> citizenId);
    CitizenResponse getCitizenByIdWithChildren(Long citizenId);

}


