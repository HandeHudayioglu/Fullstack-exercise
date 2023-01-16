package com.handehdy.fullstackexercise.service.children;

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
public class ChildrenServiceImpl implements ChildrenService {

    private final IChildrenRepository childrenRepository;
    private final ICitizenRepository citizenRepository;
    public ChildrenServiceImpl(IChildrenRepository childrenRepository, ICitizenRepository citizenRepository) {
        this.childrenRepository = childrenRepository;
        this.citizenRepository = citizenRepository;
    }
    @Override
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
    @Override
    public List<ChildrenResponse> getAllChildrenWithParam(Optional<Long> citizenId) {
        List<Children> list;
        if(citizenId.isPresent()) {
            list = childrenRepository.findByCitizenId(citizenId.get());
        }else
            list = childrenRepository.findAll();
        return list.stream().map(child -> new ChildrenResponse(child)).collect(Collectors.toList());
    }
   }

