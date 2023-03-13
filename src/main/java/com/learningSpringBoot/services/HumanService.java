package com.learningSpringBoot.services;

import com.learningSpringBoot.dtos.HumanDto;

import java.util.List;

public interface HumanService {

    HumanDto createHuman(HumanDto humanDto);
    List<HumanDto> getAllHuman() throws Exception;
    HumanDto getHumanById(int id);
    HumanDto updateHuman(HumanDto humanDto, int id);
    void deleteHuman(int id);
}
