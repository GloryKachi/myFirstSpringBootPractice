package com.learningSpringBoot.controllers;

import com.learningSpringBoot.data.models.Gender;
import com.learningSpringBoot.data.models.Human;
import com.learningSpringBoot.data.models.Race;
import com.learningSpringBoot.dtos.HumanDto;
import com.learningSpringBoot.services.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class HumanController {

    private final HumanService humanService;

    @Autowired
    public HumanController(HumanService humanService){
        this.humanService = humanService;
    }

    @GetMapping("human")
    public ResponseEntity<List <HumanDto>> getHuman() throws Exception {
        return new ResponseEntity<>(humanService.getAllHuman(),HttpStatus.OK);
//        List<Human> humans = new ArrayList<>();
//        humans.add(new Human(1, Gender.MALE,"Israel", Race.BLACK,20));
//        humans.add(new Human(2,Gender.FEMALE,"Kim",Race.ASIAN,27));
//        humans.add(new Human(3,Gender.FEMALE,"Bill",Race.WHITE,19));
//
//        System.out.println(humans);
//        return ResponseEntity.ok(humans);
    }

    @GetMapping("human/{id}")
    public ResponseEntity<HumanDto> humanDetail(@PathVariable int id){
        return ResponseEntity.ok(humanService.getHumanById(id));
    }

    @PutMapping("human/{id}/update")
    public ResponseEntity<HumanDto> updateHuman(@RequestBody HumanDto humanDto, @PathVariable("id") int humanId){
     HumanDto response = humanService.updateHuman(humanDto,humanId);
     return new ResponseEntity<>(response, HttpStatus.OK);
    }

  @DeleteMapping("human/{id}/delete")
  public ResponseEntity<String> deleteHuman(@PathVariable("id") int humanId){
        humanService.deleteHuman(humanId);
        return new ResponseEntity<>("Successfully deleted",HttpStatus.OK);

  }


    @PostMapping("human/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<HumanDto> createHuman(@RequestBody HumanDto humanDto){
        return new ResponseEntity<>(humanService.createHuman(humanDto),(HttpStatus.CREATED));
    }








}
