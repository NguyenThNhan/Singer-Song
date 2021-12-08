package com.example.singerservice.controller;

import com.example.singerservice.entity.Singer;
import com.example.singerservice.service.SingerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/singers")
@Slf4j
public class SingerController {

    @Autowired
    private SingerService singerService;
    @PostMapping("/")
    public Singer saveSinger(@RequestBody Singer singer){
        log.info("inside saveSinger method of Singer controller!");
        return singerService.saveSinger(singer);
    }

    @GetMapping("/{id}")
    public Singer findSingerById(@PathVariable("id") Long singerId){
        log.info("inside findSingerById method of Singer controller!");
        return singerService.findSingerById(singerId);
    }

}
