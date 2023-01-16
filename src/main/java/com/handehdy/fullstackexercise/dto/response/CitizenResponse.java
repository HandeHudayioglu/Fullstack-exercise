package com.handehdy.fullstackexercise.dto.response;

import com.handehdy.fullstackexercise.repository.entity.Citizen;
import lombok.Data;
import java.util.Set;
@Data
public class CitizenResponse {
    Long id;
    String name;
    boolean isCitizen = true;
    boolean hasDrivingLicense = true;
    Set<ChildrenResponse> children;

    public CitizenResponse (Citizen entity){
        this.id = entity.getId();
    }
    public CitizenResponse(Citizen entity, Set<ChildrenResponse> children) {
        this.id = entity.getId();
        this.children = children;
        this.hasDrivingLicense = entity.getHasDrivingLicense();
        this.isCitizen = entity.getIsCitizen();
        this.name = entity.getName();
    }
}
