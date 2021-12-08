package com.example.singerservice.service;

import com.example.singerservice.entity.Singer;
import com.example.singerservice.repository.SingerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SingerService {
    @Autowired
    private SingerRepository singerRepository;

    public Singer saveSinger(Singer singer) {
        log.info("inside saveSinger of Singer controller!");
        return  singerRepository.save(singer);
    }

    public Singer findSingerById(Long singerId) {
        log.info("inside findSingerById of Singer controller!");
        return singerRepository.findById(singerId).get();
    }
}
