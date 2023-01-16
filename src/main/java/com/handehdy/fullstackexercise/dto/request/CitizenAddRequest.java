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
public class CitizenAddRequest {

    String name;
    boolean isCitizen;
    boolean hasDrivingLicence;
    Children children;
}
