package com.handehdy.fullstackexercise.service;

import com.handehdy.fullstackexercise.dto.request.ChildrenAddRequest;
import com.handehdy.fullstackexercise.dto.response.ChildrenResponse;
import com.handehdy.fullstackexercise.repository.IChildrenRepository;
import com.handehdy.fullstackexercise.repository.ICitizenRepository;
import com.handehdy.fullstackexercise.repository.entity.Children;
import com.handehdy.fullstackexercise.repository.entity.Citizen;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChildrenService {

    private final IChildrenRepository childrenRepository;
    private final ICitizenRepository citizenRepository;


    public ChildrenService(IChildrenRepository childrenRepository, ICitizenRepository citizenRepository) {

        this.childrenRepository = childrenRepository;
        this.citizenRepository = citizenRepository;

    }


    public Children addOneChild(ChildrenAddRequest newChild, Long citizenId) {
        Optional<Citizen> citizen = citizenRepository.findById(citizenId);
        if(citizen.isPresent()){
            Children childToSave = new Children();
            childToSave.setName(newChild.getName());
            childToSave.setCitizenId(newChild.getCitizenId());
            return childrenRepository.save(childToSave);
        } else
            return null;
    }

    public List<ChildrenResponse> getAllChildrenWithParam(Optional<Long> citizenId) {
        List<Children> list;
        if(citizenId.isPresent()) {
            list = childrenRepository.findByCitizenId(citizenId.get());
        }else
            list = childrenRepository.findAll();
        return list.stream().map(child -> new ChildrenResponse(child)).collect(Collectors.toList());
    }


  /*
   public List<ChildrenResponse> findByPersonId(Optional<Long> personId){
      List<Children> list;
      if(personId.isPresent()){
          list = childrenRepository.findByPersonId(personId.get());
      } else
          list = childrenRepository.findAll();
      return list.stream().map(children -> new ChildrenResponse(children)).collect(Collectors.toList());

   } */


   }

