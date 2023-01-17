package com.handehdy.fullstackexercise.controller;

import com.handehdy.fullstackexercise.exceptions.CitizenNotFoundException;
import com.handehdy.fullstackexercise.repository.entity.Citizen;
import com.handehdy.fullstackexercise.service.citizen.CitizenServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/citizens")
@CrossOrigin
public class CitizenController {

    private CitizenServiceImpl citizenService;
    public CitizenController(CitizenServiceImpl citizenService) {
        this.citizenService = citizenService;
    }

    @GetMapping
    public List<Citizen> getAllCitizens() {
       return citizenService.getAllCitizens();
    }
    @GetMapping("/getname")
    public  List<Citizen> getByName(@RequestParam String name) {
        return citizenService.getByName(name);
    }
    @GetMapping("/getnamecontains")
    public List<Citizen> getByNameContains(@RequestParam String str) {
        return citizenService.getByNameContains(str);
    }
    @GetMapping("/hasdrivinglicense")
    public List<Citizen> getByHasDrivingLicense(@RequestParam Boolean hasDrivingLicense){
        return citizenService.getByHasDrivingLicense(hasDrivingLicense);
    }
    @GetMapping("/iscitizen")
    public List<Citizen> getByIsCitizen(@RequestParam Boolean isCitizen){
        return citizenService.getByIsCitizen(isCitizen);
    }
    @PutMapping("/{citizenId}")
    public ResponseEntity<Void> updateOnePerson(@PathVariable Long citizenId, @RequestBody Citizen newCitizen){
       Citizen citizen = citizenService.updateOneCitizen(citizenId,newCitizen);
       if(citizen != null) {
           return new ResponseEntity<>(HttpStatus.OK);
       }
       return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @PostMapping("/add")
    public ResponseEntity<Void> addOneCitizen(@RequestBody Citizen newCitizen){
       Citizen citizen = citizenService.addOneCitizen(newCitizen);
       if(citizen != null) {
           return new ResponseEntity<>(HttpStatus.CREATED);
       } else
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/{citizenId}")
    public Citizen getOneCitizen(@PathVariable Long citizenId) {
        Citizen citizen = citizenService.getCitizenById(citizenId);
        if(citizen == null) {
            throw new CitizenNotFoundException("Citizen not found!");
        }
        return citizenService.getCitizenById(citizenId);
    }
    @GetMapping("/countchildren/{citizenId}")
    public Integer countChildren(@PathVariable Optional<Long> citizenId){
       return citizenService.countChildren(citizenId);
    }
}
