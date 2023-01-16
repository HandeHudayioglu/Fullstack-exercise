package com.handehdy.fullstackexercise.service.citizen;

import com.handehdy.fullstackexercise.dto.response.ChildrenResponse;
import com.handehdy.fullstackexercise.dto.response.CitizenResponse;
import com.handehdy.fullstackexercise.repository.ICitizenRepository;
import com.handehdy.fullstackexercise.repository.entity.Citizen;
import com.handehdy.fullstackexercise.service.children.ChildrenServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CitizenServiceImpl implements CitizenService {

    private final ICitizenRepository citizenRepository;
    private final ChildrenServiceImpl childrenService;

   public CitizenServiceImpl(ICitizenRepository citizenRepository, ChildrenServiceImpl childrenService) {

       this.citizenRepository = citizenRepository;
       this.childrenService = childrenService;
   }
   @Override
    public List<Citizen> getAllCitizens() {
      return citizenRepository.findAll();
    }
    @Override
    public Citizen getCitizenById(Long id) {
        return citizenRepository.findById(id).orElse(null);
    }
    @Override
    public List<Citizen> getByName(String name) {
          return citizenRepository.findByName(name);
    }
    @Override
    public List<Citizen> getByNameContains(String str) {
       return citizenRepository.findByNameContains(str);
    }
    @Override
    public List<Citizen> getByHasDrivingLicense(Boolean hasDrivingLicence) {
       return citizenRepository.findByHasDrivingLicense(hasDrivingLicence);
    }
    @Override
    public List<Citizen> getByIsCitizen(Boolean isCitizen) {
       return citizenRepository.findByIsCitizen(isCitizen);
    }
    @Override
    public Citizen updateOneCitizen(Long citizenId, Citizen newCitizen) {
       Optional<Citizen> citizen = citizenRepository.findById(citizenId);
       if(citizen.isPresent()){
           Citizen foundCitizen = citizen.get();
           foundCitizen.setHasDrivingLicense(newCitizen.getHasDrivingLicense());
           foundCitizen.setIsCitizen(newCitizen.getIsCitizen());
           foundCitizen.setName(newCitizen.getName());
           citizenRepository.save(foundCitizen);
           return foundCitizen;
       } else
       return null;
    }
    @Override
    public Citizen addOneCitizen(Citizen newCitizen) {
       Citizen citizenToSave = new Citizen();
       citizenToSave.setChildren(newCitizen.getChildren());
        citizenToSave.setIsCitizen(newCitizen.getIsCitizen());
        citizenToSave.setHasDrivingLicense(newCitizen.getHasDrivingLicense());
        citizenToSave.setName(newCitizen.getName());
       return citizenRepository.save(citizenToSave);
    }
    @Override
    public Integer countChildren(Optional<Long>citizenId) {
    Optional<Citizen> citizen = citizenRepository.findById(citizenId);
       if(citizen.isPresent()){
           List<ChildrenResponse> children = childrenService.getAllChildrenWithParam(citizenId);
           return children.size();
       }
       return 0;
    }
    @Override
    public CitizenResponse getCitizenByIdWithChildren(Long citizenId){
        Citizen citizen = citizenRepository.findById(citizenId).orElse(null);
        List<ChildrenResponse> children = childrenService.getAllChildrenWithParam(Optional.of(citizenId));
        return new CitizenResponse(citizen, (Set<ChildrenResponse>) children);
    }

}
