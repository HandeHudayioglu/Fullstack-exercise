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
public class CitizenUpdateRequest {

    String name;
    boolean isCitizen;
    boolean hasDrivinLicence;
    Children child;
}
