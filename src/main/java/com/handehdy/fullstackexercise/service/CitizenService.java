package com.handehdy.fullstackexercise.service;

import com.handehdy.fullstackexercise.dto.response.ChildrenResponse;
import com.handehdy.fullstackexercise.dto.response.CitizenResponse;
import com.handehdy.fullstackexercise.repository.ICitizenRepository;
import com.handehdy.fullstackexercise.repository.entity.Citizen;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CitizenService {

    private final ICitizenRepository citizenRepository;
    private final ChildrenService childrenService;

   public CitizenService(ICitizenRepository citizenRepository, ChildrenService childrenService) {

       this.citizenRepository = citizenRepository;
       this.childrenService = childrenService;
   }
    public List<Citizen> getAllCitizens() {
      return citizenRepository.findAll();
    }
    public Citizen getCitizenById(Long id) {
        return citizenRepository.findById(id).orElse(null);
    }

    public List<Citizen> getByName(String name) {
          return citizenRepository.findByName(name);

    }
    public List<Citizen> getByNameContains(String letter) {
       return citizenRepository.findByNameContains(letter);
    }
    public List<Citizen> getByHasDrivingLicense(Boolean hasDrivingLicence) {
       return citizenRepository.findByHasDrivingLicense(hasDrivingLicence);
    }
    public List<Citizen> getByIsCitizen(Boolean isCitizen) {
       return citizenRepository.findByIsCitizen(isCitizen);
    }
    public Citizen updateOneCitizen(Long citizenId, Citizen newCitizen) {
       Optional<Citizen> citizen = citizenRepository.findById(citizenId);
       if(citizen.isPresent()){
           Citizen foundCitizen = citizen.get();
           foundCitizen.setHasDrivingLicense(newCitizen.getHasDrivingLicense());
           foundCitizen.setIsCitizen(newCitizen.getIsCitizen());
           foundCitizen.setName(newCitizen.getName());
           //foundCitizen.setChildren(foundCitizen.getChildren());
           citizenRepository.save(foundCitizen);
           return foundCitizen;
       } else
       return null;
    }
    public Citizen addOneCitizen(Citizen newCitizen) {
       Citizen citizenToSave = new Citizen();
       citizenToSave.setChildren(newCitizen.getChildren());
        citizenToSave.setIsCitizen(newCitizen.getIsCitizen());
        citizenToSave.setHasDrivingLicense(newCitizen.getHasDrivingLicense());
        citizenToSave.setName(newCitizen.getName());
       return citizenRepository.save(citizenToSave);
    }

    public Integer countChildren(Optional<Long>citizenId) {
    Optional<Citizen> citizen = citizenRepository.findById(citizenId);
       if(citizen.isPresent()){
           List<ChildrenResponse> children = childrenService.getAllChildrenWithParam(citizenId);
           return children.size();
       }
       return 0;
    }

    public CitizenResponse getCitizenByIdWithChildren(Long citizenId){
        Citizen citizen = citizenRepository.findById(citizenId).orElse(null);
        List<ChildrenResponse> children = childrenService.getAllChildrenWithParam(Optional.of(citizenId));
        return new CitizenResponse(citizen, (Set<ChildrenResponse>) children);
    }

}
