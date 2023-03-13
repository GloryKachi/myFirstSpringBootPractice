package com.learningSpringBoot.services;

import com.learningSpringBoot.data.models.Human;
import com.learningSpringBoot.data.repositories.HumanRepository;
import com.learningSpringBoot.dtos.HumanDto;
import com.learningSpringBoot.exception.HumanException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HumanServiceImpl implements HumanService{
    private HumanRepository humanRepository;

   @Autowired
public HumanServiceImpl(HumanRepository humanRepository){
    this.humanRepository = humanRepository;
}



    @Override
    public HumanDto createHuman(HumanDto humanDto) {
        Human human = new Human();
        human.setName(humanDto.getName());
        human.setAge(humanDto.getAge());
        human.setGender(humanDto.getGender());
        human.setRace(humanDto.getRace());

        Human newHuman = humanRepository.save(human);

        HumanDto humanResponse = new HumanDto();
        humanResponse.setId(newHuman.getId());
        humanResponse.setName(newHuman.getName());
        humanResponse.setRace(newHuman.getRace());
        humanResponse.setGender(newHuman.getGender());
        humanResponse.setAge(newHuman.getAge());
        return humanResponse;
    }

    @Override
    public List<HumanDto> getAllHuman() throws Exception {
        Human myHuman = humanRepository.findById(23L).orElseThrow(() -> new HumanException("Human not found by Id"));
       List<Human> humans = humanRepository.findAll();
       //map returns a new list
        return humans.stream().map(human -> mapToDto(human)).collect(Collectors.toList());
    }

    @Override
    public HumanDto getHumanById(int id) {
       Human human = humanRepository.findById((long) id).orElseThrow(() -> new HumanException("Human not found"));
        return mapToDto(human);
    }

    @Override
    public HumanDto updateHuman(HumanDto humanDto, int id) {
        Human human = humanRepository.findById((long) id).orElseThrow(() -> new HumanException("Human could not be updated"));

        human.setName(humanDto.getName());
        human.setAge(humanDto.getAge());

        Human updateHuman = humanRepository.save(human);
        return mapToDto(updateHuman);
    }

    @Override
    public void deleteHuman(int id) {
        Human human = humanRepository.findById((long)id).orElseThrow(() -> new HumanException("Human could not be deleted"));
        humanRepository.delete(human);
    }

    private HumanDto mapToDto(Human human){
       HumanDto humanDto = new HumanDto();
       humanDto.setId(human.getId());
       humanDto.setGender(human.getGender());
       humanDto.setAge(human.getAge());
       humanDto.setRace(human.getRace());
       humanDto.setName(human.getName());

       return humanDto;
    }

    private Human mapToEntity(HumanDto humanDto){
       Human human = new Human();
       human.setName(humanDto.getName());
       human.setAge(humanDto.getAge());

       return human;
    }
}
