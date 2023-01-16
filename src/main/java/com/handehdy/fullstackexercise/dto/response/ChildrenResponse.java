package com.handehdy.fullstackexercise.dto.response;

import com.handehdy.fullstackexercise.repository.entity.Children;
import lombok.Data;
@Data
public class ChildrenResponse {
    Long id;
    String name;
    Boolean isCitizen;
    public ChildrenResponse(Children entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.isCitizen=entity.getIsCitizen();
    }
}
