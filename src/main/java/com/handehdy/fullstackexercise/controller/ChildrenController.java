package com.handehdy.fullstackexercise.controller;

import com.handehdy.fullstackexercise.dto.request.ChildrenAddRequest;
import com.handehdy.fullstackexercise.repository.entity.Children;
import com.handehdy.fullstackexercise.service.children.ChildrenServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/children")
@CrossOrigin
public class ChildrenController {

    private final ChildrenServiceImpl childrenService;
    public ChildrenController(ChildrenServiceImpl childrenService) {
        this.childrenService = childrenService;
    }
    @PostMapping("/add/{citizenId}")
    public Children addOneChild(@RequestBody ChildrenAddRequest newChild, @PathVariable Long citizenId){
        return childrenService.addOneChild(newChild,citizenId);
    }
}
