package com.learningSpringBoot.dtos;

import com.learningSpringBoot.data.models.Gender;
import com.learningSpringBoot.data.models.Race;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class HumanDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Gender gender;
    private String name;
    private Race race;
    private int age;
}
