package com.handehdy.fullstackexercise.dto.request;

import com.handehdy.fullstackexercise.repository.entity.Children;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChildrenAddRequest {

    String name;
    Long citizenId;

}
