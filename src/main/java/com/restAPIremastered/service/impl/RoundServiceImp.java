package com.restAPIremastered.service.impl;

import com.restAPIremastered.persistance.dto.RoundDTO;
import com.restAPIremastered.persistance.entity.Round;
import com.restAPIremastered.persistance.repository.RoundRepository;
import com.restAPIremastered.service.RoundService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoundServiceImp implements RoundService {

    private final RoundRepository roundRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public RoundDTO saveRound(RoundDTO roundDTO) {
        Round round = modelMapper.map(roundDTO, Round.class);
        return  modelMapper.map(roundRepository.save(round),RoundDTO.class);
    }

    @Override
    @Transactional
    public List<RoundDTO> getRounds() {
        List<Round> rounds = roundRepository.findAll();
        return rounds.stream()
                .map(round -> modelMapper.map(round, RoundDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public RoundDTO getRound(int theId) {
        Optional<Round> optionalRound = roundRepository.findById(theId);
        return optionalRound.map(round -> modelMapper.map(round, RoundDTO.class)).orElse(null);
    }

    @Override
    @Transactional
    public void deleteRound(int theId) {
        roundRepository.deleteById(theId);
    }

    @Override
    public Round findByRoundDate(String roundDate) {
        return roundRepository.findByRoundDate(roundDate);
    }

    @Override
    public RoundDTO findByRoundNumber(int roundNumber) {
        Round theRound = roundRepository.findByRoundNumber(roundNumber);
        RoundDTO round = modelMapper.map(theRound,RoundDTO.class);
         return round;
    }
    @Override
    @Transactional
    public void flush() {
        roundRepository.flush();
    }
}