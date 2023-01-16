package com.handehdy.fullstackexercise.controller;

import com.handehdy.fullstackexercise.exceptions.CitizenNotFoundException;
import com.handehdy.fullstackexercise.repository.entity.Citizen;
import com.handehdy.fullstackexercise.service.CitizenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/citizens")
@CrossOrigin
public class CitizenController {

    private CitizenService citizenService;

    public CitizenController(CitizenService citizenService) {
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


    @GetMapping("/hasdrivinglicence")
    public List<Citizen> getByHasDrivingLicense(@RequestParam Boolean hasDrivingLicence){
        return citizenService.getByHasDrivingLicense(hasDrivingLicence);
    }
    @GetMapping("/iscitizen")
    public List<Citizen> getByIsCitizen(@RequestParam Boolean isCitizen){
        return citizenService.getByIsCitizen(isCitizen);
    }

    @PutMapping("/{citizenId}")
    public ResponseEntity updateOnePerson(@PathVariable Long citizenId, @RequestBody Citizen newCitizen){
       Citizen citizen = citizenService.updateOneCitizen(citizenId,newCitizen);
       if(citizen != null) {
           return new ResponseEntity<>(HttpStatus.OK);
       }
       return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/add")
    public ResponseEntity addOneCitizen(@RequestBody Citizen newCitizen){
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
            throw new CitizenNotFoundException();
        }
        return citizenService.getCitizenById(citizenId);
    }
    @GetMapping("/countchildren/{citizenId}")
    public Integer countChildren(@PathVariable Optional<Long> citizenId){
       return citizenService.countChildren(citizenId);
    }

}
