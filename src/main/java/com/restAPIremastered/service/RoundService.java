package com.restAPIremastered.service;

import com.restAPIremastered.persistance.dto.RoundDTO;
import com.restAPIremastered.persistance.entity.Round;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface RoundService {

    RoundDTO saveRound(RoundDTO roundDTO);

    List<RoundDTO> getRounds();

    RoundDTO getRound(int theId);

    void deleteRound(int theId);

     Round findByRoundDate(String roundDate);


}