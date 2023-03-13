package com.learningSpringBoot.services;

import com.learningSpringBoot.data.models.Gender;
import com.learningSpringBoot.data.models.Race;
import com.learningSpringBoot.dtos.HumanDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class HumanServiceImplTest {
    @Autowired
    HumanService humanService;
    HumanDto humanDto;
    @BeforeEach
    void setUp() {
    humanDto = new HumanDto();
    humanDto.setName("saheed");
    humanDto.setRace(Race.ASIAN);
    humanDto.setAge(16);
    humanDto.setGender(Gender.FEMALE);

    }
    @Test
    void testThatWeCanCreateHuman(){
        assertEquals(16, humanService.createHuman(humanDto).getAge());
    }
}