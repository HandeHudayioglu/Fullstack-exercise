package com.handehdy.fullstackexercise.service.children;

import com.handehdy.fullstackexercise.dto.request.ChildrenAddRequest;
import com.handehdy.fullstackexercise.dto.response.ChildrenResponse;
import com.handehdy.fullstackexercise.repository.entity.Children;

import java.util.List;
import java.util.Optional;

public interface ChildrenService {

    Children addOneChild(ChildrenAddRequest newChild, Long citizenId);
    List<ChildrenResponse> getAllChildrenWithParam(Optional<Long> citizenId);
}
